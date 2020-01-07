import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.Serializable;

public class Center implements Serializable {
    private HBox center = new HBox();
    private Data data;
    private Man man = new Man();

    public Center() {
        data = new Data(man, null, null);
        Text title = new Text("Hangman");
        title.setFont(Font.font("Verdana", 40));
        BorderPane.setAlignment(title, Pos.CENTER);
        center.getChildren().addAll(man.getPicOfMan(), data.getRightSide());
    }

    public HBox getCenter() {
        return center;
    }

    public Data getData() {
        return data;
    }


}