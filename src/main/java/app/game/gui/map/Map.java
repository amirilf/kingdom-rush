package app.game.gui.map;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;

import java.util.Random;

import app.game.model.Raider;;

public class Map {

    @FXML
    private AnchorPane root;

    @FXML
    private Path path1;

    @FXML
    private Path path2;

    @FXML
    public void initialize() {

        Image raiderImage = new Image(getClass().getResourceAsStream("/app/game/media/test/walk.png"));

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {

                    int delay = new Random().nextInt(2000) + 1000;
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
