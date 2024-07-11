package app.game.model.spell;

public class YoungBoySpell extends Spell {

    public YoungBoySpell() {
        super(SpellEnum.YOUNG_BOY);
    }

    @Override
    public void drop() {
        System.out.println("DROP YOUNGBOY");
    }

}
