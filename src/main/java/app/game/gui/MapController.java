package app.game.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;

import java.util.Random;

import app.game.model.DB;
import app.game.model.Map;
import app.game.model.Raider;;

public class MapController {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView bgImage;

    @FXML
    public void initialize() {

        Map map1 = DB.getMaps().get(0);
        bgImage.setImage(map1.getBg().getImage());
        Path path1 = map1.getPaths().get(0);
        Path path2 = map1.getPaths().get(1);

        root.getChildren().addAll(path1, path2);

        Image raiderImage = new Image(getClass().getResourceAsStream("/app/game/media/test/1.png"));

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {

                    int delay = 1000;
                    Thread.sleep(delay);

                    Path selectedPath = (new Random().nextBoolean()) ? path1 : path2;
                    Raider hero = new Raider(raiderImage, selectedPath, 100, 100, 100);

                    Platform.runLater(() -> {
                        root.getChildren().add(hero.getImageView());
                        hero.start();
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
