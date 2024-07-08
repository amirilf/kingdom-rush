package app.game.model.spell;

public class FreezeSpell extends Spell {

    FreezeSpell(int price) {
        super(price);
    }

    @Override
    public void drop() {
        System.out.println("DROP FREEZE");
    }

}
