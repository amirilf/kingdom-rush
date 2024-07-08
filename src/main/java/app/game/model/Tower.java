package app.game.model;

public abstract class Tower {

    private int destruction;
    private int construction;

    Tower(int destruction, int construction) {
        this.destruction = destruction;
        this.construction = construction;
    }

    // GETTERS
    public int getDestruction() {
        return destruction;
    }

    public int getConstruction() {
        return construction;
    }

    // SETTERS
    public void setDestruction(int destruction) {
        this.destruction = destruction;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
    }
}
