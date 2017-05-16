package charactersheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import charactersheet.values.Ability;
import charactersheet.values.Alignment;
import charactersheet.values.Background;
import charactersheet.values.CharacterClass;
import charactersheet.values.Race;

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
	private List<Spinner<Integer>> abilityScores;
	private Label[] abilityModifiers;
	private TextField inspiration;
	private VBox savingThrows;
	private RadioButton[] proficientSavingThrows;
	private TextField[] savingThrowModifiers;
	private VBox skills;
	private RadioButton[] proficientSkills;
	private TextField[] skillModifiers;
	private TextField passiveWisdom;
	private TextArea otherProficiencies;
	private TextField armorClass;
	private TextField initiative;
	private TextField speed;
	private TextField maxHP;
	private TextField currentHP;
	private TextField tempHP;

	@Override
	public void start(final Stage stage) throws Exception {
		sheet1 = new VBox();
		sheet1.setFillWidth(true);
		sheet1.setSpacing(8);
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
		experience = new Spinner<>(0, 355000, 0, 50);
		experience.setEditable(true);
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

		final Button roll = new Button("Randomize");
		roll.setOnAction(e -> {
			for (int a = 0; a < Ability.values().length; a++) {

			}
		});

		abilityBox.getChildren().add(roll);

		abilityScores = new ArrayList<>(Ability.values().length);
		abilityModifiers = new Label[Ability.values().length];
		for (int a = 0; a < Ability.values().length; a++) {
			abilityScores.add(new Spinner<>(0, 30, 10));
			abilityScores.get(a).setMaxWidth(Double.POSITIVE_INFINITY);
			abilityModifiers[a] = new Label("+0");

			final GridPane abilityHBox = new GridPane();
			abilityHBox.addRow(0, new Label(Ability.values()[a].toString()), abilityScores.get(a), abilityModifiers[a]);
			final ColumnConstraints ten = new ColumnConstraints();
			ten.setPercentWidth(10);
			ten.setHalignment(HPos.RIGHT);
			abilityHBox.getColumnConstraints().addAll(percentConstraints(50), percentConstraints(40), ten);
			abilityBox.getChildren().add(abilityHBox);
		}
		sheet1.getChildren().add(new TitledPane("Ability Scores", abilityBox));

		scene1 = new Scene(sheet1, 640, 480);
		stage.setScene(scene1);
		stage.show();
	}

	public static GridPane makeRow(final Node... components) {
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
