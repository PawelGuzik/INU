package inu.git;

import javafx.stage.Stage;
import inu.git.StatementWindows.MessageBoxButton;
import inu.git.StatementWindows.MessageBoxIcon;
import inu.git.StatementWindows.MessageBoxResult;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		StatementWindows.show("To jest treœæ wiadomoœci w oknie z ostrze¿eniem!", 
				"Okno z ostrze¿eniem", MessageBoxIcon.Warning, MessageBoxButton.YesNo);

		StatementWindows.show("To jest wiadomoœæ w oknie informacyjnym.",
				"Okno informacyjne", MessageBoxIcon.Information, MessageBoxButton.YesNo);
		
		StatementWindows.show("To jest wiadomoœæ w oknie z alertem.",
				"Okno z alertem", MessageBoxIcon.Alert, MessageBoxButton.OkCancel);
		StatementWindows.show("To jest wiadomoœæ w oknie z b³êdem krytycznym.",
				"Okno z b³edem krytycznym", MessageBoxIcon.CriticalError, MessageBoxButton.OK);
		
	}

}