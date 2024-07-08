package app.game.model.spell;

public abstract class Spell implements SpellInterface {

    private int price;

    Spell(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
