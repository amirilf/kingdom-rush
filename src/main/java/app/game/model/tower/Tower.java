package app.game.model.tower;

public abstract class Tower implements TowerInterface {

    private TowerEnum towerObj;

    Tower(TowerEnum towerObj) {
        this.towerObj = towerObj;
    }

    // GETTERS
    public TowerEnum obj() {
        return towerObj;
    }
}
