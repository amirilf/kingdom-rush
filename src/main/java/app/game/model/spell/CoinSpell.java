package app.game.model.spell;

public class CoinSpell extends Spell {

    private static int price = 500;
    private static String name = "Coin";
    private static String detail = "This spell helps you to increase your coins to create new towers to protect your land better than before.";

    public CoinSpell() {
        super(price, name, detail);
    }

    @Override
    public void drop() {
        System.out.println("DROP COIN");
    }

}
