package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeController {

    @FXML
    private Text txt_diamonds;

    @FXML
    private Text txt_stars;

    @FXML
    private void initialize() {
        System.out.println("HELLO PAGE");
    }

    @FXML
    private void handleSettingButton() {
        System.out.println("Setting page button!");
    }
}
