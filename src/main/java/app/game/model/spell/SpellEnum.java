package app.game.model.spell;

public enum SpellEnum {
    COIN("Coin", 500, 300,
            "This spell helps you to increase your coins to create new towers to protect your land better than before."),
    FREEZE("Freeze", 250, 3,
            "This is freeze spell which you can use to freeze all raiders for a few moment and it helps you to protect your land in tough situations."),
    HEALTH("Health", 350, 3,
            "This spell helps you to protect your defending system and increases your team health by 200 for each."),
    YOUNG_BOY("Young Boy", 999, 5,
            "This spell will kill all the raiders which are going to attack you. young boy is the last chance to protect yourself.");

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
