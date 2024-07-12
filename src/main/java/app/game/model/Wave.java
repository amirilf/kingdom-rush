package app.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import app.game.App;
import app.game.gui.MapController;
import app.game.model.raider.*;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;

public class Wave {

    private int wolves;
    private int thugs;
    private int immortals;
    private int queens;
    private List<Raider> raiders;
    private int raidersDoneCount = 0;

    public Wave(int wolves, int thugs, int immortals, int queens) {
        this.wolves = wolves;
        this.thugs = thugs;
        this.immortals = immortals;
        this.queens = queens;
        this.raiders = new ArrayList<>();
    }

    public void start(Pane pane, List<Path> paths) {
        raiders.clear();
        raidersDoneCount = 0;
        for (int i = 0; i < wolves; i++)
            raiders.add(new WolfRaider());
        for (int i = 0; i < queens; i++)
            raiders.add(new QueenRaider());
        for (int i = 0; i < thugs; i++)
            raiders.add(new ThugRaider());
        for (int i = 0; i < immortals; i++)
            raiders.add(new ImmortalRaider());

        Collections.shuffle(raiders);

        new Thread(() -> {
            Random random = new Random();
            for (Raider raider : raiders) {
                Path randomPath = paths.get(random.nextInt(paths.size()));
                raider.setOnRaiderDoneCallback(this::onRaiderDone);
                raider.move(pane, randomPath);
            }
        }).start();
    }

    private synchronized void onRaiderDone(Raider raider) {
        raidersDoneCount++;
        if (raidersDoneCount == raiders.size()) {
            Platform.runLater(() -> {
                System.out.println("All raiders are done.");
                App.loadWaves();
                MapController.endGame("You won the game! health: " + MapController.currentMap.getHealth() + " / 100");
            });
        }
    }
}
