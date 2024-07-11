package app.game.model.tower;

import app.game.model.Point;

public class ArcherTower extends Tower {

    ArcherTower(int destruction, int construction, Point point) {
        super(destruction, construction, point);
    }

    @Override
    public void defend() {
    }

    @Override
    public void upgrade() {
    }

    @Override
    public void destroyed() {
    }

}
