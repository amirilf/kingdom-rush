package app.game.model.spell;

public class FreezeSpell extends Spell {

    private static int price = 250;
    private static String name = "Freeze";
    private static String detail = "This is freeze spell which you can use to freeze all raiders for a few moment and it helps you to protect your land in tough situations.";

    public FreezeSpell() {
        super(price, name, detail);
    }

    @Override
    public void drop() {
        System.out.println("DROP FREEZE");
    }

}
