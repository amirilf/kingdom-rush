package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        Utility.changeSceneofStage((Stage) txt_diamonds.getScene().getWindow(), "/app/game/fxml/Setting.fxml");
    }
}
