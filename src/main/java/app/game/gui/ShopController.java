package app.game.gui;

import app.game.model.spell.CoinSpell;
import app.game.model.spell.FreezeSpell;
import app.game.model.spell.HealthSpell;
import app.game.model.spell.Spell;
import app.game.model.spell.YoungBoySpell;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopController {

    // ========== DATA
    private static Spell[] currentSpell = new Spell[] {
            new CoinSpell(),
            new FreezeSpell(),
            new HealthSpell(),
            new YoungBoySpell()
    };
    private static int currentSpellIndex = 0;

    // ========== ELEMENTS
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

    // ========== METHODS

    // TODO : wtf is wrong with health and heart?
    @FXML
    private void initialize() {

        // sample data
        int coins = 23;
        int hearts = 234;
        int freezes = 64;
        int youngBoys = 2;
        int diamonds = 76543;
        lbl_diamond.setText(String.valueOf(diamonds));
        lbl_coin.setText(String.valueOf(coins));
        lbl_freeze.setText(String.valueOf(freezes));
        lbl_heart.setText(String.valueOf(hearts));
        lbl_youngBoy.setText(String.valueOf(youngBoys));

        setCurrentSpellData();

    }

    private void setCurrentSpellData() {
        lbl_title.setText(currentSpell[currentSpellIndex].getName());
        lbl_price.setText((String.valueOf(currentSpell[currentSpellIndex].getPrice())));
        txt_detail.setText(currentSpell[currentSpellIndex].getDetail());
    }

    @FXML
    private void handleBackButton() {
        Utility.changeSceneofStage((Stage) root.getScene().getWindow(), "/app/game/fxml/Home.fxml");
    }

    @FXML
    private void handleBuyCoin() {
        if (currentSpellIndex != 0) {
            currentSpellIndex = 0;
            setCurrentSpellData();
        }
    }

    @FXML
    private void handleBuyFreeze() {
        if (currentSpellIndex != 1) {
            currentSpellIndex = 1;
            setCurrentSpellData();
        }
    }

    @FXML
    private void handleBuyYoungBoy() {
        if (currentSpellIndex != 3) {
            currentSpellIndex = 3;
            setCurrentSpellData();
        }
    }

    @FXML
    private void handleBuyHeart() {
        if (currentSpellIndex != 2) {
            currentSpellIndex = 2;
            setCurrentSpellData();
        }
    }

    @FXML
    private void handleBuyButton() {
        System.out.println("Buying the spell:" + currentSpell[currentSpellIndex].getName());
    }
}
