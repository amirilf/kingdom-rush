package app.game.gui;

import app.game.model.Player;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {

    private Player player = new Player(1, "Amir", null, null, 0, 0);

    @FXML
    private Text title_name;

    @FXML
    private Text txt_diamonds;

    @FXML
    private Text txt_stars;

    @FXML
    private void initialize() {
        title_name.setText(player.getName());

    }

    @FXML
    private void handleSettingButton() {
        Utility.changeSceneofStage((Stage) txt_diamonds.getScene().getWindow(), "/app/game/fxml/Setting.fxml");
    }

    @FXML
    private void handleShopButton() {
        Utility.changeSceneofStage((Stage) txt_diamonds.getScene().getWindow(), "/app/game/fxml/Shop.fxml");
    }
}
