package app.game.model.tower;

import app.game.model.Point;

public class WizardTower extends Tower {

    WizardTower(int destruction, int construction, Point point) {
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
