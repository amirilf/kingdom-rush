package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Setting {

    private boolean isMute = true; // TODO: get from the audio module which handles sound

    @FXML
    private ImageView img_volume;

    @FXML
    private void initialize() {
        if (isMute)
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-off.png").toString()));
    }

    @FXML
    private void handleVolumeClicked() {

        if (isMute)
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-on.png").toString()));
        else
            img_volume.setImage(new Image(getClass().getResource("/app/game/media/icons/volume-off.png").toString()));

        isMute = !isMute;

        System.out.println("Music status: " + (isMute ? "OFF" : "ON"));

    }
}
