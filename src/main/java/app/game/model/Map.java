package app.game.model;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class Map {

    private ArrayList<Tower> towers;
    private ArrayList<Path> paths;
    private int waves;
    private int coins;
    private ImageView bg;

    Map(ArrayList<Tower> towers, ArrayList<Path> paths, int waves, int coins, ImageView bg) {
        this.towers = towers;
        this.paths = paths;
        this.waves = waves;
        this.coins = coins;
        this.bg = bg;
    }

    // GETTERS
    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getWaves() {
        return waves;
    }

    public int getCoins() {
        return coins;
    }

    public ImageView getBg() {
        return bg;
    }

    // No need for setters
}
