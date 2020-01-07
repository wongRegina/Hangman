import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Buttons {
    private BorderPane gameLayout;
    private HBox topButtons, botButtons;
    private Button newButton, startPlayingButton, exitButton;
    private Stage stage;
    private Center centerPane;

    public Buttons(Center centerPane, Stage stage) {
        this.centerPane = centerPane;
        this.stage = stage;
        gameLayout = new BorderPane();
        topButtons = new HBox();
        botButtons = new HBox();
        makeButtons();
        setButtonActions();
        gameLayout.setTop(topButtons);
        gameLayout.setBottom(botButtons);
    }

    private void setButtonActions() {
        newButtonAction();
        exitButtonAction();
        startPlayingButtonAction();
    }

    private void makeButtons() {
        try {
            newButton = new Button("New Game", new ImageView(new Image(new FileInputStream("New.png"))));
            exitButton = new Button("Exit", new ImageView(new Image(new FileInputStream("Exit.png"))));
        } catch (FileNotFoundException e) {
            return;
        }
        topButtons.getChildren().addAll(newButton, exitButton);
        topButtons.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        topButtons.setAlignment(Pos.CENTER);
        startPlayingButton = new Button("Start Playing");
        startPlayingButton.setVisible(false);
        botButtons.getChildren().add(startPlayingButton);
        botButtons.setAlignment(Pos.CENTER);
        botButtons.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void newButtonAction() {
        newButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (startPlayingButton.isDisable()) {
                    Hangman newGame = new Hangman();
                    try {
                        newGame.start(stage);
                    } catch (Exception ex) {
                        System.out.println("Fail");
                    }
                } else {
                    startPlayingButton.setVisible(true);
                }
            }
        });
    }

    private void exitButtonAction() {
        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
            }
        });
    }

    private void startPlayingButtonAction() {
        startPlayingButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startPlayingButton.setDisable(true);
                centerPane.getCenter().setVisible(true);
                centerPane.getData().getKeyPress().setGameOver(false);
            }
        });
    }

    public BorderPane getGameLayout() {
        return gameLayout;
    }
}
