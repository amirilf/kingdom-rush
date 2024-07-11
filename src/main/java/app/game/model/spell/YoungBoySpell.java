package app.game.model.spell;

public class YoungBoySpell extends Spell {

    private static int price = 999;
    private static String name = "Young Boy";
    private static String detail = "This spell will kill all the raiders which are going to attack you. young boy is the last chance to protect yourself.";

    public YoungBoySpell() {
        super(price, name, detail);
    }

    @Override
    public void drop() {
        System.out.println("DROP YOUNGBOY");
    }

}
