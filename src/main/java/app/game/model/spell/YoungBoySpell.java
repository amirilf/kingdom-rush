package app.game.model.spell;

public class YoungBoySpell extends Spell {

    YoungBoySpell(int price) {
        super(price);
    }

    @Override
    public void drop() {
        System.out.println("DROP YOUNGBOY");
    }

}
