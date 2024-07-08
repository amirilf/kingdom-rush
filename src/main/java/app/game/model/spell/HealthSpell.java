package app.game.model.spell;

public class HealthSpell extends Spell {

    HealthSpell(int price) {
        super(price);
    }

    @Override
    public void drop() {
        System.out.println("DROP HEALTH");
    }

}
