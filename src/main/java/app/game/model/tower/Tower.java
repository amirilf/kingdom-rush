package app.game.model.tower;

import javafx.scene.image.Image;

public abstract class Tower implements TowerInterface {

    private TowerEnum towerObj;

    Tower(TowerEnum towerObj) {
        this.towerObj = towerObj;
    }

    // GETTERS
    public int getDestruction() {
        return towerObj.getDestruction();
    }

    public int getConstruction() {
        return towerObj.getConstruction();
    }

    public Image getImg() {
        return towerObj.getImg();
    }
}
