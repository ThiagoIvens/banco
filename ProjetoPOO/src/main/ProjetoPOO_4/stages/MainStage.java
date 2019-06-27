package stages;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.textos;

public class MainStage{
	private Button btnMinhaConta;
	private Button btnTransferencia;
	private Button btnPagamento;
	private Button btnLoteria;

	public MainStage(Stage stage, String username) {
	
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(1024, 720);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// labels
		Label lblMain = new Label(textos.lblMain + " " + username);
		lblMain.setLayoutX(10);
		lblMain.setLayoutY(10);


		// buttons
		ButtonBar btnBar = new ButtonBar();

		btnMinhaConta = new Button(textos.btnMinhaConta);

		btnMinhaConta.setOnMouseClicked(e -> {
			try {
				new MinhaConta(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		


		btnTransferencia = new Button(textos.btnTransferencia);

		btnTransferencia.setOnMouseClicked(e -> {
			try {
				new Transferencia(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btnPagamento = new Button(textos.btnPagamento);
		btnPagamento.setOnMouseClicked(e -> {
			try {
				new Pagamento(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btnLoteria = new Button(textos.btnLoteria);
		btnLoteria.setOnMouseClicked(e -> {
			try {
				new Loteria(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btnBar.getButtons().addAll(btnMinhaConta, btnTransferencia, btnPagamento, btnLoteria);
		btnBar.setLayoutX(10);
		btnBar.setLayoutY(70);

		// pane
		pane.getChildren().add(lblMain);
		pane.getChildren().add(btnBar);

		// stage
		stage.setTitle(textos.appTitle);
		stage.setResizable(false);

		stage.show();

	}

}
