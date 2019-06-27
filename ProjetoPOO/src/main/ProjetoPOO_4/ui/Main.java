package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import stages.Login;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new Login(primaryStage);
	}
}