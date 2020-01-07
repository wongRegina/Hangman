import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    private final String[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
    private FlowPane alpha = new FlowPane(2, 2);
    private ArrayList<Button> listOfButtons = new ArrayList<>();

    public Alphabet() {
        alpha.setMaxWidth(900);
        for (String letter : alphabet) {
            Button button = new Button(letter);
            button.setStyle(("-fx-background-color: #b19cd9; -fx-font-size: 24; -fx-text-fill: black; -fx-opacity: 1"));
            button.setMinWidth(70);
            button.setMinHeight(70);
            button.setDisable(true);
            alpha.getChildren().add(button);
            listOfButtons.add(button);
        }
    }

    public Alphabet(String alphabe) {
        String a[] = alphabe.split("");
        List<String> alp = (Arrays.asList(a));
        alpha.setMaxWidth(900);
        for (String letter : alphabet) {
            Button button = new Button(letter);
            if (alp.contains(letter))
                button.setStyle(("-fx-background-color: #756d96; -fx-font-size: 24; -fx-text-fill: black; -fx-opacity: 0.5"));
            else
                button.setStyle(("-fx-background-color: #b19cd9; -fx-font-size: 24; -fx-text-fill: black; -fx-opacity: 1"));
            button.setMinWidth(70);
            button.setMinHeight(70);
            button.setDisable(true);
            alpha.getChildren().add(button);
            listOfButtons.add(button);
        }
    }

    public ArrayList<Button> getListOfButtons() {
        return listOfButtons;
    }

    public FlowPane getAlpha() {
        return alpha;
    }
}
