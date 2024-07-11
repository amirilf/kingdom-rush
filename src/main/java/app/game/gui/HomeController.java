package app.game.gui;

import app.game.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {

    private Player player = new Player(1, "Amir", null, null, 0, 0);

    @FXML
    private Text title_name;

    @FXML
    private Label lbl_diamonds;

    @FXML
    private Label lbl_stars;

    @FXML
    private void initialize() {
        title_name.setText(player.getName());

    }

    @FXML
    private void handleSettingButton() {
        Utility.changeSceneofStage((Stage) lbl_diamonds.getScene().getWindow(), "/app/game/fxml/Setting.fxml");
    }

    @FXML
    private void handleShopButton() {
        Utility.changeSceneofStage((Stage) lbl_diamonds.getScene().getWindow(), "/app/game/fxml/Shop.fxml");
    }
}
