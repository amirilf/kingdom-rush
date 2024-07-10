package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lbl_coin;

    @FXML
    private Label lbl_heart;

    @FXML
    private Label lbl_youngBoy;

    @FXML
    private Label lbl_freeze;

    @FXML
    private Label lbl_diamond;

    @FXML
    private Label lbl_price;

    @FXML
    private Label lbl_title;

    @FXML
    private Text txt_detail;

    @FXML
    private void handleBackButton() {
        Utility.changeSceneofStage((Stage) root.getScene().getWindow(), "/app/game/fxml/Home.fxml");
    }

    @FXML
    private void handleBuyFreeze() {

    }

    @FXML
    private void handleBuyCoin() {

    }

    @FXML
    private void handleBuyYoungBoy() {

    }

    @FXML
    private void handleBuyHeart() {

    }

    @FXML
    private void handleBuyButton() {

    }
}
