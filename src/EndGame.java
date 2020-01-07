import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class EndGame {
    Stage popUpWindow;
    Scene scene1;
    Button close;
    VBox fullPopup;

    public EndGame(boolean win, List<Button> word) {
        fullPopup = new VBox(10);
        popUpWindow = new Stage();
        popUpWindow.setTitle("Game Over");
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        Text text = new Text(" ");
        if (win) {
            text = new Text("You won");
        } else
            text = new Text("You lost. \nThe word was " + returnWord(word));
        close();
        fullPopup.getChildren().addAll(text, close);
        fullPopup.setAlignment(Pos.CENTER);
        scene1 = new Scene(fullPopup, 300, 100);
    }

    public void display() {
        popUpWindow.setScene(scene1);
        popUpWindow.showAndWait();
    }

    private void close() {
        close = new Button("Close");
        close.setAlignment(Pos.CENTER);
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popUpWindow.close();
            }
        });
    }

    private String returnWord(List<Button> word) {
        String words = "";
        for (Button x : word) {
            words += x.getText();
        }
        return words;
    }

}
