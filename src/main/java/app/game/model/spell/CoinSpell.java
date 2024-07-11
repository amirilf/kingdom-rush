package app.game.model.spell;

public class CoinSpell extends Spell {

    public CoinSpell() {
        super(SpellEnum.COIN);
    }

    @Override
    public void drop() {
        System.out.println("DROP COIN");
    }

}
