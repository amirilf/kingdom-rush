package app.game.gui;

import app.game.model.Database;
import app.game.model.Player;
import app.game.model.Song;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingController {

    private boolean isMute = true;

    // sample data
    private Player player;

    @FXML
    private Text msg;

    @FXML
    private TextField fld_name;

    @FXML
    private TextField fld_username;

    @FXML
    private TextField fld_password;

    @FXML
    private ImageView img_volume;

    @FXML
    private AnchorPane root;

    @FXML
    private void initialize() {

        player = Database.getCurrentPlayer();

        isMute = Song.isMute();

        if (isMute)
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-off.png").toString()));

        msg.setVisible(false);

        // get player data to fill inputs
        fld_name.setText(player.getName());
        fld_username.setText(player.getUsername());
        fld_password.setText(player.getPassword());

        Platform.runLater(() -> root.requestFocus());

    }

    @FXML
    private void handleVolumeClicked() {

        if (isMute)
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-on.png").toString()));
        else
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-off.png").toString()));

        isMute = !isMute;
        Song.setMute(isMute);
    }

    @FXML
    private void handleSubmitButton() {
        System.out.println("Submit!");

        String name = fld_name.getText();
        String username = fld_username.getText();
        String password = fld_password.getText();

        boolean changed = false;

        if (!name.equals(player.getName())) {
            player.setName(name);
            changed = true;
        }

        if (!username.equals(player.getUsername())) {
            player.setUsername(username);
            changed = true;
        }

        if (!password.equals(player.getPassword())) {
            player.setPassword(password);
            changed = true;
        }

        if (changed) {
            msg.setText("Successfully updated !");
            msg.setFill(Paint.valueOf("#1fc233"));
        } else {
            msg.setText("Nothing is changed !");
            msg.setFill(Paint.valueOf("#c31e1e"));
        }

        msg.setVisible(true);
    }

    @FXML
    private void handleBackButton() {
        Utility.changeSceneofStage((Stage) img_volume.getScene().getWindow(), "/app/game/fxml/Home.fxml");
    }
}
