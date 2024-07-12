package app.game.model.map;

import java.util.ArrayList;
import app.game.model.Point;
import app.game.model.Wave;
import app.game.model.tower.TowerEnum;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;
import javafx.util.Pair;

public class Map {

    private ArrayList<Pair<Point, TowerEnum>> towers = new ArrayList<>();
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Wave> waves = new ArrayList<>();
    private final IntegerProperty currentWave = new SimpleIntegerProperty();
    private final IntegerProperty health = new SimpleIntegerProperty();
    private final IntegerProperty coins = new SimpleIntegerProperty();
    private final StringProperty waveTxt = new SimpleStringProperty();
    private Image bg;

    public Map(ArrayList<Wave> waves, int coins, Image bg) {
        this.currentWave.set(0);
        this.waves = waves;
        this.coins.set(coins);
        this.bg = bg;
        this.health.set(100); // default health
        updateWaveTxt();
    }

    // GETTERS

    public ArrayList<Pair<Point, TowerEnum>> getTowers() {
        return towers;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getCurrentWave() {
        return currentWave.get();
    }

    public ArrayList<Wave> getWaves() {
        return waves;
    }

    public int getCoins() {
        return coins.get();
    }

    public Image getBg() {
        return bg;
    }

    public int getHealth() {
        return health.get();
    }

    public String getWaveTxt() {
        return waveTxt.get();
    }

    // Properties
    public IntegerProperty currentWaveProperty() {
        return currentWave;
    }

    public IntegerProperty coinsProperty() {
        return coins;
    }

    public IntegerProperty healthProperty() {
        return health;
    }

    public StringProperty waveTxtProperty() {
        return waveTxt;
    }

    // SETTERS
    public void setCoins(int coins) {
        this.coins.set(coins);
    }

    public void setHealth(int health) {
        this.health.set(health);
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave.set(currentWave);
        updateWaveTxt();
    }

    private void updateWaveTxt() {
        waveTxt.set(currentWave.get() + " / " + waves.size());
    }
}
