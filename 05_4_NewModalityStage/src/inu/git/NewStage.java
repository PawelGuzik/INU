package inu.git;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewStage {
private static Button btnNew;
	private static void btnNew_Click() {
		Stage newStage = new Stage();
		newStage.setWidth(300);
		newStage.setHeight(200);
		newStage.setTitle("New Window");
		newStage.setAlwaysOnTop(true);
		newStage.centerOnScreen();
		newStage.setResizable(false);
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.showAndWait();
	}

	public static void createWindow() {
		Stage primaryStage = new Stage();
		btnNew = new Button("New window");

		btnNew.setOnAction(e -> btnNew_Click());
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(btnNew);
		Scene scene = new Scene(borderPane, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lambda Expression");
		primaryStage.show();

	}

}
