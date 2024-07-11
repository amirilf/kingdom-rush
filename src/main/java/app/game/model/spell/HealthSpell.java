package app.game.model.spell;

public class HealthSpell extends Spell {

    public HealthSpell() {
        super(SpellEnum.HEALTH);
    }

    @Override
    public void drop() {
        System.out.println("DROP HEALTH");
    }

}
