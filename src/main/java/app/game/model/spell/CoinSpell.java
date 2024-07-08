package app.game.model.spell;

public class CoinSpell extends Spell {

    CoinSpell(int price) {
        super(price);
    }

    @Override
    public void drop() {
        System.out.println("DROP COIN");
    }

}
