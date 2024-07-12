package app.game.model.tower;

import java.util.ArrayList;

import javafx.scene.image.Image;

public enum TowerEnum {

    ARCHER("Archer", new int[] { 20, 30, 40 }, new int[] { 100, 150, 200 }, "/app/game/media/towers/archer/"),
    WIZARD("Wizard", new int[] { 50, 60, 90 }, new int[] { 200, 250, 300 }, "/app/game/media/towers/wizard/"),
    ARTILLERY("Artillery", new int[] { 40, 70, 100 }, new int[] { 200, 250, 300 }, "/app/game/media/towers/artillery/");

    private String name;

    private int[] destruction = new int[3];
    private int[] construction = new int[3];
    private ArrayList<Image> images = new ArrayList<>(3);

    private int lvl; // 1,2,3! (and not 0,1,2)

    private double diffX;
    private double diffY;

    TowerEnum(String name, int[] destruction, int[] construction, String path) {

        this.name = name;
        this.destruction = destruction;
        this.construction = construction;
        this.lvl = 1;

        for (int i = 1; i <= 3; i++) {
            this.images.add(i - 1, new Image(getClass().getResource(path + i + ".png").toString()));
        }

        diffX = images.get(0).getWidth() / 2;
        diffY = (images.get(0).getHeight() / 2) + 12;

    }

    public int getConstruction() {
        return construction[lvl - 1];
    }

    public int getNextLevelConstruction() {
        return construction[lvl];
    }

    public int getDestruction() {
        return destruction[lvl - 1];
    }

    public Image getImg() {
        return images.get(lvl - 1);
    }

    public double getDiffX() {
        return diffX;
    }

    public double getDiffY() {
        return diffY;
    }

    public int getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    // SETTERS
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getSellPrice() {
        int res = 0;
        for (int i = 0; i < lvl; i++)
            res += construction[i];
        return res / 2;
    }

    @Override
    public String toString() {
        return "[name:" + name + ", lvl: " + lvl + "]";
    }
}
