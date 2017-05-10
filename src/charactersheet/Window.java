package charactersheet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	private Stage stage;
	private Scene characterScene;

	@Override
	public void start(final Stage stage) throws Exception {
		characterScene = new Scene(null, 640, 480);
	}

}
