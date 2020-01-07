import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Man {
    private StackPane picOfMan = new StackPane();
    private int scene = 0;
    private String png = ".png";

    public Man() {
        picOfMan.setPrefWidth(550);
        picOfMan.setPrefHeight(600);
        ImageView pic = new ImageView();
        try {
            pic = new ImageView(new Image(new FileInputStream(scene + png)));
            picOfMan.getChildren().add(pic);
        } catch (FileNotFoundException e) {

        }
        BorderPane.setAlignment(pic, Pos.CENTER);
        picOfMan.setBackground(new Background(new BackgroundFill(Color.web("#ffd1dc"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void updateMan(boolean change) {
        if (change) {
            scene++;
            picOfMan.getChildren().clear();
            try {
                picOfMan.getChildren().add(new ImageView(new Image(new FileInputStream(scene + png))));
            } catch (FileNotFoundException e) {

            }
        }
    }

    public StackPane getPicOfMan() {
        return picOfMan;
    }
}
