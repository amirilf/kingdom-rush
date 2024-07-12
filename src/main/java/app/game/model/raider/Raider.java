package app.game.model.raider;

import app.game.gui.MapController;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.function.Consumer;

public abstract class Raider extends Thread implements RaiderInterface {

    private RaiderEnum raiderObj;
    private PathTransition transition;
    private Pane rootPane;
    private ImageView img;
    private Consumer<Raider> onRaiderDoneCallback;
    public volatile boolean running;

    public Raider(RaiderEnum raiderObj) {
        this.raiderObj = raiderObj;
    }

    public void setOnRaiderDoneCallback(Consumer<Raider> callback) {
        this.onRaiderDoneCallback = callback;
    }

    // GETTERS
    public RaiderEnum obj() {
        return raiderObj;
    }

    public void move(Pane pane, Path path) {
        running = true;
        this.rootPane = pane;

        img = new ImageView(raiderObj.getImg());

        Platform.runLater(() -> pane.getChildren().add(img));

        transition = new PathTransition();
        transition.setPath(path);
        transition.setNode(img);
        transition.setDuration(Duration.seconds(10));

        transition.setOnFinished(event -> {
            Platform.runLater(() -> {
                pane.getChildren().remove(img);
                running = false;

                MapController.currentMap.setHealth(MapController.currentMap.getHealth() - raiderObj.getDamage());

                if (onRaiderDoneCallback != null) {
                    onRaiderDoneCallback.accept(this);
                }

                // check if game is over
                if (MapController.currentMap.getHealth() <= 0) {
                    MapController.endGame("Game Over! Your health reached 0.");
                }
            });
        });

        transition.play();
        start();
    }

    public void dead() {
        // raider is dead
        System.out.println(raiderObj + " is dead");

        // update coins (get loot)
        MapController.currentMap.setCoins(MapController.currentMap.getCoins() + raiderObj.getLoot());

        // remove raider from map
        Platform.runLater(() -> rootPane.getChildren().remove(img));

        transition.stop();

        running = false;
        if (onRaiderDoneCallback != null) {
            onRaiderDoneCallback.accept(this);
        }
    }

    @Override
    public void run() {
        System.out.println("RUNNING THREAD for " + raiderObj + "!");

        raiderObj.setHealth(300);

        while (running && raiderObj.getHealth() > 0) {
            try {
                Thread.sleep(100);
                Platform.runLater(() -> {
                    if (raiderObj.getHealth() > 0) {
                        raiderObj.setHealth(raiderObj.getHealth() - 5);
                        System.out.println("Health of " + raiderObj.getName() + ": " + raiderObj.getHealth());
                        if (raiderObj.getHealth() <= 0) {
                            dead();
                        }
                    }
                });
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt(); // preserve interruption status
            }
        }
    }
}
