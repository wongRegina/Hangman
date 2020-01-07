import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Guesses {
    private int remainingGuesses = 10;
    private Pane guesses = new Pane();

    public Guesses() {
        Text title = new Text("Remaining Guesses : " + remainingGuesses);
        title.setFont(Font.font("Verdana", 20));
        guesses.getChildren().add(title);
    }

    public int updateRemainingGuesses() {
        guesses.getChildren().clear();
        remainingGuesses--;
        Text title = new Text("Remaining Guesses : " + remainingGuesses);
        title.setFont(Font.font("Verdana", 20));
        guesses.getChildren().add(title);
        return remainingGuesses;
    }

    public Pane getGuesses() {
        return guesses;
    }

}