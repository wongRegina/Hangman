import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Hangman extends Application {

    private BorderPane borderPane = new BorderPane();
    private Center centerPane;
    private Buttons buttons;

    @Override
    public void start(Stage primaryStage) throws Exception {
        centerPane = new Center();
        buttons = new Buttons(centerPane, primaryStage);
        borderPane = buttons.getGameLayout();
        borderPane.setCenter(centerPane.getCenter());
        borderPane.getCenter().setVisible(false);

        Scene scene = new Scene(borderPane, 1400, 700);
        centerPane.getData().getKeyPress().setScene(scene);
        centerPane.getData().getKeyPress().keyPress();
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(new FileInputStream(".png")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
