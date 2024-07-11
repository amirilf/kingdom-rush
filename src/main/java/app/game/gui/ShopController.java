package app.game.gui;

import app.game.model.Database;
import app.game.model.Player;
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

    private static Player player;

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
        player = Database.getCurrentPlayer();

        loadData();
        loadSelectedSpell();
    }

    private void loadData() {
        lbl_diamond.setText(String.valueOf(player.getDiamond()));
        lbl_coin.setText(String.valueOf(player.getBackpack().getCoinSpells()));
        lbl_freeze.setText(String.valueOf(player.getBackpack().getFreezeSpells()));
        lbl_heart.setText(String.valueOf(player.getBackpack().getHealthSpells()));
        lbl_youngBoy.setText(String.valueOf(player.getBackpack().getYoungBoySpells()));

    }

    private void loadSelectedSpell() {
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
            loadSelectedSpell();
        }
    }

    @FXML
    private void handleBuyFreeze() {
        if (currentSpellIndex != 1) {
            currentSpellIndex = 1;
            loadSelectedSpell();
        }
    }

    @FXML
    private void handleBuyYoungBoy() {
        if (currentSpellIndex != 3) {
            currentSpellIndex = 3;
            loadSelectedSpell();
        }
    }

    @FXML
    private void handleBuyHeart() {
        if (currentSpellIndex != 2) {
            currentSpellIndex = 2;
            loadSelectedSpell();
        }
    }

    @FXML
    private void handleBuyButton() {
        System.out.println("trying to buy the spell:" + currentSpell[currentSpellIndex].getName());

        if (currentSpell[currentSpellIndex].getPrice() <= player.getDiamond()) {
            player.getBackpack().addSpells(currentSpell[currentSpellIndex]);
            player.setDiamond(player.getDiamond() - currentSpell[currentSpellIndex].getPrice());
            loadData();
        } else {
            System.out.println("Not enough money!");
        }
    }
}
