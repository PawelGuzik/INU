package inu.StatementWindows;

import javafx.stage.Stage;
import inu.StatementWindows.StatementWindows.MessageBoxButton;
import inu.StatementWindows.StatementWindows.MessageBoxIcon;
import javafx.application.Application;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		StatementWindows.show("To jest tre�� wiadomo�ci w oknie z ostrze�eniem!", 
				"Okno z ostrze�eniem", MessageBoxIcon.Warning, MessageBoxButton.YesNo);

		StatementWindows.show("To jest wiadomo�� w oknie informacyjnym.",
				"Okno informacyjne", MessageBoxIcon.Information, MessageBoxButton.YesNo);
		
		StatementWindows.show("To jest wiadomo�� w oknie z alertem.",
				"Okno z alertem", MessageBoxIcon.Alert, MessageBoxButton.OkCancel);
		StatementWindows.show("To jest wiadomo�� w oknie z b��dem krytycznym.",
				"Okno z b�edem krytycznym", MessageBoxIcon.CriticalError, MessageBoxButton.OK);
		
	}

}