package charactersheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import charactersheet.util.Height;
import charactersheet.util.UnitConverter;
import charactersheet.util.Util;
import charactersheet.values.Ability;
import charactersheet.values.Alignment;
import charactersheet.values.Background;
import charactersheet.values.CharacterClass;
import charactersheet.values.Race;
import charactersheet.values.Skill;
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
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
	private CheckBox multiclass;
	private ComboBox<CharacterClass> characterClass;
	private ComboBox<Race> race;
	private ComboBox<Background> background;
	private ComboBox<Alignment> alignment;
	private TextField playerName;
	private Spinner<Integer> experience;
	private Label level;
	private Label proficiency;
	private Spinner<Integer> currentHP;
	private Spinner<Integer> tempHP;
	private Label maxHP;
	private GridPane[] levelGrids;
	private List<ComboBox<CharacterClass>> multiclassCombobox;
	private List<Spinner<Integer>> newHPs;
	private Spinner<Integer> speed;
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
	private TextArea personalityTraits;
	private TextArea ideals;
	private TextArea bonds;
	private TextArea flaws;
	private Spinner<Double> age;
	private Spinner<Height> height;
	private Spinner<Double> weight;
	private TextField eyes;
	private TextField skin;
	private TextField hair;

	private int levelValue;

	@Override
	public void start(final Stage stage) throws Exception {
		sheet1 = new VBox(8);
		sheet1.setFillWidth(true);
		sheet1.setPadding(new Insets(8));

		playerName = new TextField();
		sheet1.getChildren().add(Util.makeRow(new Label("Player Name"), playerName));

		name = new TextField();
		sheet1.getChildren().add(Util.makeRow(new Label("Character Name"), name));

		race = new ComboBox<>();
		sheet1.getChildren().add(Util.makeRow(new Label("Race"), race));

		background = new ComboBox<>();
		sheet1.getChildren().add(Util.makeRow(new Label("Background"), background));

		alignment = new ComboBox<>(FXCollections.observableArrayList(Alignment.values()));
		sheet1.getChildren().add(Util.makeRow(new Label("Alignment"), alignment));

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
		Util.configureEditable(experience);
		experience.getValueFactory().setConverter(Util.converterWithDefault(0, String::valueOf, Integer::parseInt));
		experience.setMaxWidth(Double.POSITIVE_INFINITY);
		Util.configureNumerical(experience.getEditor());
		level = new Label("Level 1");
		proficiency = new Label("Proficiency: +2");
		xpPane.add(new Label("Experience"), 0, 0, 1, 2);
		xpPane.add(experience, 1, 0, 2, 1);
		xpPane.add(level, 1, 1);
		xpPane.add(proficiency, 2, 1);
		xpPane.getColumnConstraints().addAll(Util.percentConstraints(50), Util.percentConstraints(25), Util.percentConstraints(25));
		sheet1.getChildren().add(xpPane);

		final GridPane classPane = new GridPane();
		classPane.setVgap(8);
		classPane.getColumnConstraints().addAll(Util.percentConstraints(50), Util.percentConstraints(50));
		classPane.add(new Label("Class"), 0, 0, 1, 2);
		characterClass = new ComboBox<>();
		characterClass.setMaxWidth(Double.POSITIVE_INFINITY);
		classPane.add(characterClass, 1, 0);
		multiclass = new CheckBox("Multiclass");
		classPane.add(multiclass, 1, 1);

		sheet1.getChildren().add(classPane);

		currentHP = new Spinner<>(0, 0, 0);
		tempHP = new Spinner<>(0, Integer.MAX_VALUE, 0);
		// private final Label maxHP;
		// private final GridPane[] levelGrids;
		// private final List<ComboBox<CharacterClass>> multiclassCombobox;
		// private final List<Spinner<Integer>> newHPs;
		// private final Spinner<Integer> speed;
		// TODO

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
		abilityBox.getChildren().add(Util.makeRow(roll, rollResult));

		abilityScores = new ArrayList<>(Ability.values().length);
		abilityModifiers = new Label[Ability.values().length];
		for (int a = 0; a < Ability.values().length; a++) {
			final int index = a;

			final Spinner<Integer> abilityScore = new Spinner<>(0, 30, 10);
			abilityScores.add(abilityScore);
			abilityScore.setMaxWidth(Double.POSITIVE_INFINITY);
			abilityScore.valueProperty().addListener((observable, oldValue, newValue) -> {
				abilityModifiers[index].setText(String.format("%+d", (int) Math.floor((newValue - 10.0) / 2)));
				setProficiencyScores(index);
			});
			Util.configureEditable(abilityScore);
			abilityScore.getValueFactory().setConverter(Util.converterWithDefault(10, String::valueOf, Integer::parseInt));
			Util.configureNumerical(abilityScore.getEditor());
			abilityModifiers[a] = new Label("+0");

			final GridPane abilityGrid = new GridPane();
			abilityGrid.addRow(0, new Label(Ability.values()[a].toString()), abilityScore, abilityModifiers[a]);
			final ColumnConstraints ten = new ColumnConstraints();
			ten.setPercentWidth(10);
			ten.setHalignment(HPos.RIGHT);
			abilityGrid.getColumnConstraints().addAll(Util.percentConstraints(50), Util.percentConstraints(40), ten);
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

			final GridPane row = Util.makeRow(false, proficientSavingThrows[a], savingThrowModifiers[a]);
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

			final GridPane row = Util.makeRow(false, proficientSkills[s], skillModifiers[s]);
			row.getColumnConstraints().get(1).setHalignment(HPos.RIGHT);
			skillBox.getChildren().add(row);
		}
		sheet1.getChildren().add(new TitledPane("Skills", skillBox));

		final VBox charDetailsBox = new VBox(8);
		charDetailsBox.setFillWidth(true);

		personalityTraits = new TextArea();
		personalityTraits.setPrefRowCount(4);
		charDetailsBox.getChildren().addAll(new Label("Personality Traits"), personalityTraits);

		ideals = new TextArea();
		ideals.setPrefRowCount(3);
		charDetailsBox.getChildren().addAll(new Label("Ideals"), ideals);

		bonds = new TextArea();
		bonds.setPrefRowCount(3);
		charDetailsBox.getChildren().addAll(new Label("Bonds"), bonds);

		flaws = new TextArea();
		flaws.setPrefRowCount(3);
		charDetailsBox.getChildren().addAll(new Label("Flaws"), flaws);

		charDetailsBox.getChildren().add(new Separator());

		age = new Spinner<>(0, Double.POSITIVE_INFINITY, 0);
		age.setValueFactory(new SpinnerValueFactory<Double>() {

			@Override
			public void decrement(final int steps) {
				setValue(Math.max(0, getValue() - steps));
			}

			@Override
			public void increment(final int steps) {
				setValue(getValue() + steps);
			}

		});
		age.getValueFactory().setConverter(Util.converterWithDefault(20.0, d -> String.format("%s y", Util.MIN_DECIMAL.format(d)), UnitConverter::toYears));
		age.getValueFactory().setValue(20.);
		Util.configureEditable(age);
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Age"), age));

		height = new Spinner<>(new SpinnerValueFactory<Height>() {
			{
				setValue(new Height(72));
			}

			@Override
			public void decrement(final int steps) {
				if (steps == 0) return;
				setValue(new Height(Math.max(0, getValue().inches - steps)));
			}

			@Override
			public void increment(final int steps) {
				if (steps == 0) return;
				setValue(new Height(getValue().inches + steps));
			}

		});
		height.getValueFactory().setConverter(Util.converterWithDefault(new Height(72), Height::toString, Height::new));
		Util.configureEditable(height);
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Height"), height));

		weight = new Spinner<>(0, Double.POSITIVE_INFINITY, 0, 10);
		weight.setValueFactory(new SpinnerValueFactory<Double>() {

			@Override
			public void decrement(final int steps) {
				setValue(Math.max(0, getValue() - steps * 10));
			}

			@Override
			public void increment(final int steps) {
				setValue(getValue() + steps * 10);
			}

		});
		weight.getValueFactory().setConverter(Util.converterWithDefault(200.0, d -> String.format("%.2f lb", d), UnitConverter::toPounds));
		weight.getValueFactory().setValue(200.0);
		Util.configureEditable(weight);
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Weight"), weight));

		eyes = new TextField();
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Eyes"), eyes));

		skin = new TextField();
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Skin"), skin));

		hair = new TextField();
		charDetailsBox.getChildren().add(Util.makeRow(new Label("Hair"), hair));

		sheet1.getChildren().add(new TitledPane("Character Details", charDetailsBox));

		final ScrollPane scrollPane = new ScrollPane(sheet1);
		scrollPane.setFitToWidth(true);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		scene1 = new Scene(scrollPane, 480, 480);
		stage.setScene(scene1);
		stage.setTitle("D&D 5e Character Sheet Generator");
		stage.setWidth(640);
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
}
