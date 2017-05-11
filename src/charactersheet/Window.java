package charactersheet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import charactersheet.values.Ability;
import charactersheet.values.Alignment;
import charactersheet.values.Background;
import charactersheet.values.CharacterClass;
import charactersheet.values.Race;
import charactersheet.values.Skill;

public class Window extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	private Stage stage;

	private Scene characterScene;
	private TextField playerName;
	private TextField name;
	private TableView<CharacterClass> classTable;
	private ComboBox<CharacterClass> charClass;
	private Spinner<Integer> level;
	private ComboBox<Race> race;
	private ComboBox<Background> background;
	private ComboBox<Alignment> alignment;
	private Spinner<Integer> experience;
	private final List<Spinner<Integer>> baseAbilityScores = new ArrayList<>(Ability.values().length);
	private final List<RadioButton> savingThrows = new ArrayList<>(Ability.values().length);
	private final List<RadioButton> skills = new ArrayList<>(Skill.values().length);
	private TextArea personality;
	private TextArea ideals;
	private TextArea bonds;
	private TextArea flaws;

	@Override
	public void start(final Stage stage) throws Exception {
		final WebView wv = new WebView();
		wv.getEngine().loadContent(new String(Files.readAllBytes(Paths.get("sheet1.svg"))));

		characterScene = new Scene(wv, 640, 480);
		stage.setScene(characterScene);
		stage.show();
	}

}
