package inu.git;

import com.sun.glass.events.MouseEvent;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatementWindows extends Stage {
	public enum MessageBoxIcon {
		Information, Warning, Alert, CriticalError;
	}

	public enum MessageBoxButton {
		AbortRetryIgnore, OK, OkCancel, RetryCancel, YesNo, YesNoCancel;
	}

	public enum MessageBoxResult {
		Abort, Retry, Ignore, OK, Cancel, Yes, No;
	}

	private static MessageBoxIcon icon;
	private static MessageBoxButton buttons;
	private static MessageBoxResult result = null;
	private static ImageView imageView = null;
	private static Image image;
	private static HBox buttonsHBox;
	private static Button abort;
	private static Button ignore;
	private static Button cancel;
	private static Button no;
	private static Button retry;
	private static Button ok;
	private static Button yes;
	private static Label lblMsg;
	static HBox hBox;
	static VBox vBox;

	public static MessageBoxResult show(String aMessage, String aTitle, MessageBoxIcon aPriority,
			MessageBoxButton aButonSet) {
		
		Stage primaryStage = new Stage();
		Image image1 = new Image(ClassLoader.getSystemResourceAsStream("StatusNo_32xLG.png"));
		ImageView imageViewNo = new ImageView(image1);
		Image image2 = new Image(ClassLoader.getSystemResourceAsStream("StatusOK_32x.png"));
		ImageView imageViewYes = new ImageView(image2);
		
		icon = aPriority;
		buttons = aButonSet;
		lblMsg = new Label();
		abort = new Button("Abort");
		ignore = new Button("Ignore");
		cancel = new Button("Cancel", imageViewNo);
		no = new Button("No", imageViewNo);
		retry = new Button("Retry");
		ok = new Button("Ok", imageViewYes);
		yes = new Button("Yes", imageViewYes);

		yes.setGraphicTextGap(10);
		yes.setFont(Font.font(lblMsg.getFont().getName(), FontWeight.BOLD, lblMsg.getFont().getSize()));
		ok.setGraphicTextGap(10);
		ok.setFont(yes.getFont());
		abort.setGraphicTextGap(10);
		abort.setFont(yes.getFont());
		ignore.setGraphicTextGap(10);
		ignore.setFont(yes.getFont());
		cancel.setGraphicTextGap(10);
		cancel.setFont(yes.getFont());
		no.setGraphicTextGap(10);
		no.setFont(yes.getFont());
		lblMsg.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		lblMsg.setText(aMessage);
		lblMsg.setWrapText(true);

		setMessageIcon(icon);
		setButtons(buttons);
		
		primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
			if (KeyCode.ESCAPE == event.getCode()) {
				primaryStage.close();
			}
		});
		abort.setOnAction(e -> button_Click(e));
		retry.setOnAction(e -> button_Click(e));
		ignore.setOnAction(e -> button_Click(e));
		ok.setOnAction(e -> button_Click(e));
		cancel.setOnAction(e -> button_Click(e));
		yes.setOnAction(e -> button_Click(e));
		no.setOnAction(e -> button_Click(e));

		buttonsHBox.setAlignment(Pos.CENTER);
		hBox = new HBox(30, imageView, lblMsg);
		hBox.setAlignment(Pos.CENTER);
		vBox = new VBox(30, hBox, buttonsHBox);
		vBox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vBox, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle(aTitle);
		primaryStage.show();
		return result;
	}

	private static void setButtons(MessageBoxButton buttons) {
		buttonsHBox = new HBox();
		buttonsHBox.setSpacing(30);
		switch (buttons) {
		case AbortRetryIgnore:
			buttonsHBox.getChildren().add(abort);
			buttonsHBox.getChildren().add(retry);
			buttonsHBox.getChildren().add(ignore);
			break;
		case OK:
			buttonsHBox.getChildren().add(ok);
			break;
		case OkCancel:
			buttonsHBox.getChildren().add(ok);
			buttonsHBox.getChildren().add(cancel);
			break;
		case RetryCancel:
			buttonsHBox.getChildren().add(retry);
			buttonsHBox.getChildren().add(cancel);
			break;
		case YesNo:
			buttonsHBox.getChildren().add(yes);
			buttonsHBox.getChildren().add(no);
			break;
		case YesNoCancel:
			buttonsHBox.getChildren().add(yes);
			buttonsHBox.getChildren().add(no);
			buttonsHBox.getChildren().add(cancel);
			break;
		default:
			break;
		}
	}

	private static void setMessageIcon(MessageBoxIcon i) {
		switch (i) {
		case Information:
			image = new Image(ClassLoader.getSystemResourceAsStream("StatusInformation_64x.png"));
			imageView = new ImageView(image);
			break;
		case Alert:
			image = new Image(ClassLoader.getSystemResourceAsStream("StatusAlert_64x.png"));
			imageView = new ImageView(image);
			break;
		case CriticalError:
			image = new Image(ClassLoader.getSystemResourceAsStream("StatusCriticalError_64x.png"));
			imageView = new ImageView(image);
			break;
		case Warning:
			image = new Image(ClassLoader.getSystemResourceAsStream("StatusWarning_64x.png"));
			imageView = new ImageView(image);
			break;
		default:
			break;
		}
	}

	private static void button_Click(ActionEvent e) {
		Button clicked = (Button) e.getSource();
		String buttonName = clicked.getText();
		switch (buttonName) {
		case "Abort":
			result = MessageBoxResult.Abort;
			break;
		case "Retry":
			result = MessageBoxResult.Retry;
			break;
		case "Ignore":
			result = MessageBoxResult.Ignore;
			break;
		case "Ok":
			result = MessageBoxResult.OK;
			break;
		case "Cancel":
			result = MessageBoxResult.Cancel;
			break;
		case "Yes":
			result = MessageBoxResult.Yes;
			break;
		case "No":
			result = MessageBoxResult.No;
			break;
		default:
			break;
		}
		System.out.println("U¿ytkownik wybra³: " + result);
		Stage stage = (Stage) clicked.getScene().getWindow();
		stage.close();

	}

}
