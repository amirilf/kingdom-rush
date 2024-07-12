package app.game.model.map;

import java.util.ArrayList;

import app.game.model.Point;
import app.game.model.Wave;
import app.game.model.tower.TowerEnum;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;
import javafx.util.Pair;

public class Map {

    private ArrayList<Pair<Point, TowerEnum>> towers = new ArrayList<>();
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Wave> waves = new ArrayList<>();
    private int currentWave;
    private int health;
    private int coins;
    private Image bg;

    public Map(ArrayList<Wave> waves, int coins, Image bg) {
        this.currentWave = 0;
        this.waves = waves;
        this.coins = coins;
        this.bg = bg;
        this.health = 100; // default health
    }

    // GETTERS

    public ArrayList<Pair<Point, TowerEnum>> getTowers() {
        return towers;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public ArrayList<Wave> getWaves() {
        return waves;
    }

    public int getCoins() {
        return coins;
    }

    public Image getBg() {
        return bg;
    }

    public int getHealth() {
        return health;
    }

    // SETTERS
    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    // OTHERS
    public String getWaveTxt() {
        return currentWave + " / " + waves.size();
    }
}
