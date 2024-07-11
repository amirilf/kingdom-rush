package app.game.model.spell;

public class HealthSpell extends Spell {

    private static int price = 350;
    private static String name = "Health";
    private static String detail = "This spell helps you to protect your defending system and increases your team health by 200 for each.";

    public HealthSpell() {
        super(price, name, detail);
    }

    @Override
    public void drop() {
        System.out.println("DROP HEALTH");
    }

}
