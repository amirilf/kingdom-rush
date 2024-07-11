package app.game.model.spell;

public abstract class Spell implements SpellInterface {

    private String name;
    private String detail;
    private int price;

    Spell(int price, String name, String detail) {
        this.price = price;
        this.name = name;
        this.detail = detail;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
