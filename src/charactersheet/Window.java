package charactersheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import charactersheet.values.Ability;
import charactersheet.values.Alignment;
import charactersheet.values.Background;
import charactersheet.values.CharacterClass;
import charactersheet.values.Race;
import charactersheet.values.Skill;
import charactersheet.values.Util;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {

	public static final Random rand = new Random();

	public static void main(final String[] args) {
		Application.launch(args);
	}

	private Scene scene1;
	private VBox sheet1;

	private TextField name;
	private ComboBox<CharacterClass> characterClass;
	private ComboBox<Race> race;
	private ComboBox<Background> background;
	private ComboBox<Alignment> alignment;
	private TextField playerName;
	private Spinner<Integer> experience;
	private Label level;
	private Label proficiency;
	private Button roll;
	private Label rollResult;
	private List<Spinner<Integer>> abilityScores;
	private Label[] abilityModifiers;
	private TextField inspiration;
	private CheckBox[] proficientSavingThrows;
	private Label[] savingThrowModifiers;
	private CheckBox[] proficientSkills;
	private Label[] skillModifiers;
	private TextField passiveWisdom;
	private TextArea otherProficiencies;
	private TextField armorClass;
	private TextField initiative;
	private TextField speed;
	private TextField maxHP;
	private TextField currentHP;
	private TextField tempHP;

	private int levelValue;

	@Override
	public void start(final Stage stage) throws Exception {
		sheet1 = new VBox(8);
		sheet1.setFillWidth(true);
		sheet1.setPadding(new Insets(8));

		playerName = new TextField();
		sheet1.getChildren().add(makeRow(new Label("Player Name"), playerName));

		name = new TextField();
		sheet1.getChildren().add(makeRow(new Label("Character Name"), name));

		characterClass = new ComboBox<>();
		sheet1.getChildren().add(makeRow(new Label("Class"), characterClass));

		race = new ComboBox<>();
		sheet1.getChildren().add(makeRow(new Label("Race"), race));

		background = new ComboBox<>();
		sheet1.getChildren().add(makeRow(new Label("Background"), background));

		alignment = new ComboBox<>(FXCollections.observableArrayList(Alignment.values()));
		sheet1.getChildren().add(makeRow(new Label("Alignment"), alignment));

		final GridPane xpPane = new GridPane();
		experience = new Spinner<>(new SpinnerValueFactory<Integer>() {

			{
				setValue(0);
			}

			@Override
			public void decrement(final int steps) {
				setValue(Util.XP_PER_LEVEL[Math.max(0, getCurrentIndex() - steps)]);
			}

			@Override
			public void increment(final int steps) {
				setValue(Util.XP_PER_LEVEL[Math.min(Util.XP_PER_LEVEL.length - 1, getCurrentIndex() + steps)]);
			}

			private int getCurrentIndex() {
				for (int lvl = 0; lvl < Util.XP_PER_LEVEL.length; lvl++) {
					if (getValue() < Util.XP_PER_LEVEL[lvl]) {
						return --lvl;
					}
				}
				return Util.XP_PER_LEVEL.length - 1;
			}

		});
		experience.setEditable(true);
		experience.valueProperty().addListener((observable, oldValue, newValue) -> {
			for (levelValue = 0; levelValue < Util.XP_PER_LEVEL.length; levelValue++) {
				if (newValue < Util.XP_PER_LEVEL[levelValue]) {
					break;
				}
			}
			level.setText(String.format("Level %d", levelValue));
			proficiency.setText(String.format("Proficiency: %+d", 2 + (levelValue - 1) / 4));
			setProficiencyScores(-1);
		});
		experience.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!experience.isEditable()) return;
			final String text = experience.getEditor().getText();
			final SpinnerValueFactory<Integer> valueFactory = experience.getValueFactory();
			if (valueFactory != null) {
				valueFactory.setValue(Integer.parseInt(text));
			}
		});
		experience.setMaxWidth(Double.POSITIVE_INFINITY);
		level = new Label("Level 1");
		proficiency = new Label("Proficiency: +2");
		xpPane.add(new Label("Experience"), 0, 0, 1, 2);
		xpPane.add(experience, 1, 0, 2, 1);
		xpPane.add(level, 1, 1);
		xpPane.add(proficiency, 2, 1);
		xpPane.getColumnConstraints().addAll(percentConstraints(50), percentConstraints(25), percentConstraints(25));
		sheet1.getChildren().add(xpPane);

		final VBox abilityBox = new VBox(8);
		abilityBox.setFillWidth(true);

		roll = new Button("Roll");
		roll.setOnAction(e -> {
			rollResult.setText(Arrays.stream(Ability.values()).mapToInt(a -> rand.ints(4, 1, 7).sorted().skip(1).sum()).sorted().collect(StringBuffer::new, (sb, i) -> {
				if (sb.length() > 0) sb.append(", ");
				sb.append(i);
			}, StringBuffer::append).insert(0, ' ').toString());
		});
		rollResult = new Label(" 8, 10, 12, 13, 14, 15");
		abilityBox.getChildren().add(makeRow(roll, rollResult));

		abilityScores = new ArrayList<>(Ability.values().length);
		abilityModifiers = new Label[Ability.values().length];
		for (int a = 0; a < Ability.values().length; a++) {
			final int index = a;

			abilityScores.add(new Spinner<>(0, 30, 10));
			abilityScores.get(a).setMaxWidth(Double.POSITIVE_INFINITY);
			abilityScores.get(a).valueProperty().addListener((observable, oldValue, newValue) -> {
				abilityModifiers[index].setText(String.format("%+d", (int) Math.floor((newValue - 10.0) / 2)));
				setProficiencyScores(index);
			});
			abilityScores.get(a).focusedProperty().addListener((observable, oldValue, newValue) -> {
				if (!newValue) abilityScores.get(index).increment(0);
			});
			abilityScores.get(a).setEditable(true);
			abilityModifiers[a] = new Label("+0");

			final GridPane abilityGrid = new GridPane();
			abilityGrid.addRow(0, new Label(Ability.values()[a].toString()), abilityScores.get(a), abilityModifiers[a]);
			final ColumnConstraints ten = new ColumnConstraints();
			ten.setPercentWidth(10);
			ten.setHalignment(HPos.RIGHT);
			abilityGrid.getColumnConstraints().addAll(percentConstraints(50), percentConstraints(40), ten);
			abilityBox.getChildren().add(abilityGrid);
		}
		sheet1.getChildren().add(new TitledPane("Ability Scores", abilityBox));

		final VBox savingThrowBox = new VBox(8);
		proficientSavingThrows = new CheckBox[Ability.values().length];
		savingThrowModifiers = new Label[Ability.values().length];
		for (int a = 0; a < Ability.values().length; a++) {
			final int index = a;

			proficientSavingThrows[a] = new CheckBox(Ability.values()[a].toString());
			proficientSavingThrows[a].setOnAction(e -> {
				setProficiencyScores(index);
			});

			savingThrowModifiers[a] = new Label("+0");

			final GridPane row = makeRow(false, proficientSavingThrows[a], savingThrowModifiers[a]);
			row.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);
			savingThrowBox.getChildren().add(row);
		}
		sheet1.getChildren().add(new TitledPane("Saving Throws", savingThrowBox));

		final VBox skillBox = new VBox(8);
		proficientSkills = new CheckBox[Skill.values().length];
		skillModifiers = new Label[Skill.values().length];
		for (int s = 0; s < Skill.values().length; s++) {
			final int index = s;

			proficientSkills[s] = new CheckBox(Skill.values()[s].toString());
			proficientSkills[s].setOnAction(e -> {
				setProficiencyScores(Ability.indexOf(Skill.values()[index].ability));
			});

			skillModifiers[s] = new Label("+0");

			final GridPane row = makeRow(false, proficientSkills[s], skillModifiers[s]);
			row.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);
			skillBox.getChildren().add(row);
		}
		sheet1.getChildren().add(new TitledPane("Skills", skillBox));

		final ScrollPane scrollPane = new ScrollPane(sheet1);
		scrollPane.setFitToWidth(true);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		scene1 = new Scene(scrollPane, 640, 480);
		stage.setScene(scene1);
		stage.show();
	}

	private void setProficiencyScores(final int abilityIndex) {
		for (int ai = abilityIndex == -1 ? 0 : abilityIndex; ai < (abilityIndex == -1 ? Ability.values().length : abilityIndex + 1); ai++)
			savingThrowModifiers[ai].setText(String.format("%+d", (int) Math.floor((abilityScores.get(ai).getValue() - 10.0) / 2) + (proficientSavingThrows[ai].isSelected() ? 2 + (levelValue - 1) / 4 : 0)));
		for (int s = 0; s < Skill.values().length; s++) {
			final int ai = Ability.indexOf(Skill.values()[s].ability);
			if (abilityIndex == -1 || ai == abilityIndex) //
				skillModifiers[s].setText(String.format("%+d", (int) Math.floor((abilityScores.get(ai).getValue() - 10.0) / 2) + (proficientSkills[s].isSelected() ? 2 + (levelValue - 1) / 4 : 0)));
		}
	}

	public static GridPane makeRow(final Region... components) {
		return makeRow(true, components);
	}

	public static GridPane makeRow(final boolean expand, final Region... components) {
		if (expand) for (final Region r : components)
			r.setMaxWidth(Double.POSITIVE_INFINITY);

		final GridPane ret = new GridPane();
		ret.addRow(0, components);

		final ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(50);
		ret.getColumnConstraints().add(cc);
		for (int i = 1; i < components.length; i++) {
			final ColumnConstraints ccc = new ColumnConstraints();
			ccc.setPercentWidth(50.0 / (components.length - 1));
			ret.getColumnConstraints().add(ccc);
		}

		return ret;
	}

	public static ColumnConstraints percentConstraints(final double percent) {
		final ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(percent);
		return cc;
	}
}
