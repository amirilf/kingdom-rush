package app.game.model.spell;

public enum SpellEnum {
    COIN("Coin", 500, 300,
            "You get 300 coins, this will help you to build new towers to protect your land better than before."),
    FREEZE("Freeze", 250, 3,
            "You get 3 freeze spells, you can use to freeze all raiders for a few moments, helping you protect your land in tough situations."),
    HEALTH("Health", 350, 3,
            "You get 3 hearts, this will protect your defense system and increase your team's health by 200 for each one."),
    YOUNG_BOY("Young Boy", 999, 3,
            "You get 3 young boys, this will kill all raiders who try to attack you. The young boy is the last chance to protect your land!");

    private String name;
    private String detail;
    private int price;
    private int quantity;

    SpellEnum(String name, int price, int quantity, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
