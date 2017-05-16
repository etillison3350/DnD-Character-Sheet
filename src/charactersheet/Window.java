package charactersheet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	// private Stage stage;
	//
	// private Scene characterScene;
	// private TextField playerName;
	// private TextField name;
	// private TableView<CharacterClass> classTable;
	// private ComboBox<CharacterClass> charClass;
	// private Spinner<Integer> level;
	// private ComboBox<Race> race;
	// private ComboBox<Background> background;
	// private ComboBox<Alignment> alignment;
	// private Spinner<Integer> experience;
	// private final List<Spinner<Integer>> baseAbilityScores = new
	// ArrayList<>(Ability.values().length);
	// private final List<RadioButton> savingThrows = new ArrayList<>(Ability.values().length);
	// private final List<RadioButton> skills = new ArrayList<>(Skill.values().length);
	// private TextArea personality;
	// private TextArea ideals;
	// private TextArea bonds;
	// private TextArea flaws;

	private Scene scene1;
	private GridPane details;
	private TextField name;
	private ComboBox<String> characterClass;
	private Spinner<Integer> level;
	private GridPane mainSection;
	private VBox abilityScorePane;
	private TextField[] abilityScores;
	private TextField[] abilityModifiers;
	private HBox inspirationBox;
	private TextField inspiration;
	private HBox proficiencyBox;
	private VBox savingThrows;
	private HBox[] savingThrowBoxes;
	private RadioButton[] proficientSavingThrows;
	private TextField[] savingThrowModifiers;
	private VBox skills;
	private HBox[] skillBoxes;
	private RadioButton[] proficientSkills;
	private TextField[] skillModifiers;
	private HBox passiveWisdomBox;
	private TextField passiveWisdom;
	private TextArea otherProficiencies;
	private GridPane topCenterPane;
	private TextField armorClass;
	private TextField initiative;
	private TextField speed;
	private VBox hitPointBox;
	private HBox maxHPBox;
	private TextField maxHP;
	private TextField currentHP;
	private TextField tempHP;

	@Override
	public void start(final Stage stage) throws Exception {

		stage.show();
	}

}
