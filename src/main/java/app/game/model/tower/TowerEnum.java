package app.game.model.tower;

import javafx.scene.image.Image;

public enum TowerEnum {

    ARCHER(100, 100, "/app/game/media/towers/archer"),
    WIZARD(150, 200, "/app/game/media/towers/wizard"),
    ARTILLERY(200, 200, "/app/game/media/towers/artillery");

    private int destruction;
    private int construction;
    private Image img;

    TowerEnum(int destruction, int construction, String path) {
        this.destruction = destruction;
        this.construction = construction;
        this.img = new Image(getClass().getResourceAsStream(path));
    }

    public int getConstruction() {
        return construction;
    }

    public int getDestruction() {
        return destruction;
    }

    public Image getImg() {
        return img;
    }
}
