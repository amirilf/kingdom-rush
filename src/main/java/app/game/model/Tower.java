package app.game.model;

public abstract class Tower {

    private int destruction;
    private int construction;
    private Point position;

    Tower(int destruction, int construction, Point point) {
        this.destruction = destruction;
        this.construction = construction;
        this.position = point;
    }

    // GETTERS
    public int getDestruction() {
        return destruction;
    }

    public int getConstruction() {
        return construction;
    }

    public Point getPosition() {
        return position;
    }

    // SETTERS
    public void setDestruction(int destruction) {
        this.destruction = destruction;
    }

    public void setConstruction(int construction) {
        this.construction = construction;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
