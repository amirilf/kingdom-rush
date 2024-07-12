package app.game.model.map;

import java.util.ArrayList;

import app.game.model.Point;
import app.game.model.tower.Tower;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;
import javafx.util.Pair;

public class Map {

    private ArrayList<Pair<Point, Tower>> towers = new ArrayList<>();
    private ArrayList<Path> paths = new ArrayList<>();
    private int waves;
    private int coins;
    private Image bg;

    public Map(int waves, int coins, Image bg) {
        this.waves = waves;
        this.coins = coins;
        this.bg = bg;
    }

    // GETTERS
    public ArrayList<Pair<Point, Tower>> getTowers() {
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

    public Image getBg() {
        return bg;
    }

    // No need for setters
}
