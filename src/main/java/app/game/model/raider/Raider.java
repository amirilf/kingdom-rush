
package app.game.model.raider;

public abstract class Raider extends Thread implements RaiderInterface {

    private RaiderEnum raiderObj;

    Raider(RaiderEnum raiderObj) {
        this.raiderObj = raiderObj;
    }

    // GETTERS
    public RaiderEnum obj() {
        return raiderObj;
    }
}
