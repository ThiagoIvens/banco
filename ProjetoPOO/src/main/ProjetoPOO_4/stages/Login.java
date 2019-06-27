package stages;

import javafx.scene.control.TextField;

import com.aquafx_project.AquaFx;

import bd.BDUsuarios;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.BD;
import ui.textos;

public class Login {
	private Button btnLogin;
	private TextField txtUsername;
	private PasswordField txtPassword;
	private Label lblLogin;

	public Login(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(280, 120);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		lblLogin = new Label(textos.lblLogin);
		lblLogin.setLayoutX(10);
		lblLogin.setLayoutY(10);

		txtUsername = new TextField();
		txtUsername.setLayoutX(10);
		txtUsername.setLayoutY(31);
		txtUsername.setMaxWidth(150);
		txtUsername.setMinWidth(150);
		txtUsername.setPrefWidth(150);

		txtPassword = new PasswordField();
		txtPassword.setLayoutX(10);
		txtPassword.setLayoutY(70);
		txtPassword.setMaxWidth(150);
		txtPassword.setMinWidth(150);
		txtPassword.setPrefWidth(150);

		btnLogin = new Button(textos.btnLogin);
		btnLogin.setLayoutX(200);
		btnLogin.setLayoutY(40);
		btnLogin.setOnMouseClicked(e -> login(stage));
		
		ComboBox<String> dbSource = new ComboBox<String>();
		dbSource.getItems().add("JSON");
		dbSource.getItems().add("XML");
		dbSource.getSelectionModel().select(0);
		dbSource.setLayoutX(10);
		dbSource.setLayoutY(150);
		dbSource.setOnAction(e -> changeDB(dbSource.getSelectionModel().getSelectedItem()));

		pane.getChildren().add(lblLogin);
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txtUsername);
		pane.getChildren().add(txtPassword);

		AquaFx.style();
		AquaFx.styleStage(stage, StageStyle.DECORATED);

		stage.setTitle(textos.appTitle);
		stage.setResizable(false);

		stage.show();
	}

	private void login(Stage stage) {
		if (txtUsername.getText().isEmpty() || txtUsername.getText() == "admin") {
			try {
				new Error(textos.ErrorUser).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		if (txtPassword.getText().isEmpty() || txtPassword.getText() == "admin") {
			try {
				new Error(textos.ErrorPassword).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		try {
			new MainStage(new Stage(), txtUsername.getText());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void changeDB(String selectedItem) {
		
		BD.users = new BDUsuarios();

	}
}
