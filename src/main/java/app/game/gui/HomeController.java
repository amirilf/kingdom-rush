package app.game.gui;

import app.game.model.Database;
import app.game.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {

    private static Player player;

    @FXML
    private Text txt_name;

    @FXML
    private Label lbl_diamonds;

    @FXML
    private Label lbl_stars;

    @FXML
    private HBox HBoxLvl1;

    @FXML
    private HBox HBoxLvl2;

    @FXML
    private HBox HBoxLvl3;

    @FXML
    private HBox HBoxLvl4;

    private static final Image FILL_STAR_IMAGE = new Image(
            HomeController.class.getResourceAsStream("/app/game/media/icons/fill-star.png"));
    private static final Image UNFILL_STAR_IMAGE = new Image(
            HomeController.class.getResourceAsStream("/app/game/media/icons/unfill-star.png"));

    @FXML
    private void initialize() {

        player = Database.getCurrentPlayer();

        txt_name.setText(player.getName());
        lbl_diamonds.setText(String.valueOf(player.getDiamond()));
        lbl_stars.setText(String.valueOf(player.getStars()));

        // fill level stars
        HBox[] hBoxs = { HBoxLvl1, HBoxLvl2, HBoxLvl3, HBoxLvl4 };
        int levels[] = player.getLevel();

        for (int i = 0; i < levels.length; i++) {

            hBoxs[i].getChildren().clear();

            for (int j = 0; j < levels[i]; j++)
                hBoxs[i].getChildren().add(new ImageView(FILL_STAR_IMAGE));

            for (int j = 0; j < (3 - levels[i]); j++)
                hBoxs[i].getChildren().add(new ImageView(UNFILL_STAR_IMAGE));
        }
    }

    @FXML
    private void handleSettingButton() {
        Utility.changeSceneofStage((Stage) lbl_diamonds.getScene().getWindow(), "/app/game/fxml/Setting.fxml");
    }

    @FXML
    private void handleShopButton() {
        Utility.changeSceneofStage((Stage) lbl_diamonds.getScene().getWindow(), "/app/game/fxml/Shop.fxml");
    }

    @FXML
    private void handleBuyDiamondButton() {
        player.setDiamond(player.getDiamond() + 100);
        lbl_diamonds.setText(String.valueOf(player.getDiamond()));
    }

    @FXML
    private void handleLogoutButton() {
        Database.logout();
        Utility.changeSceneofStage((Stage) lbl_diamonds.getScene().getWindow(), "/app/game/fxml/auth/Auth.fxml");
    }

    @FXML
    private void handleLvl1Button() {
        System.out.println("LVL 1");
        MapController.mapIndex = 0;
        Utility.changeSceneofStage((Stage) txt_name.getScene().getWindow(), "/app/game/fxml/Map.fxml");
    }

    @FXML
    private void handleLvl2Button() {
        System.out.println("LVL 2");
        MapController.mapIndex = 1;
        Utility.changeSceneofStage((Stage) txt_name.getScene().getWindow(), "/app/game/fxml/Map.fxml");
    }

    @FXML
    private void handleLvl3Button() {
        System.out.println("LVL 3");
        MapController.mapIndex = 2;
        Utility.changeSceneofStage((Stage) txt_name.getScene().getWindow(), "/app/game/fxml/Map.fxml");
    }

    @FXML
    private void handleLvl4Button() {
        System.out.println("LVL 4");
        MapController.mapIndex = 3;
        Utility.changeSceneofStage((Stage) txt_name.getScene().getWindow(), "/app/game/fxml/Map.fxml");
    }
}
