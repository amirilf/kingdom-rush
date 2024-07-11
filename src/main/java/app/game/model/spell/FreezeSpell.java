package app.game.model.spell;

public class FreezeSpell extends Spell {

    public FreezeSpell() {
        super(SpellEnum.FREEZE);
    }

    @Override
    public void drop() {
        System.out.println("DROP FREEZE");
    }

}
