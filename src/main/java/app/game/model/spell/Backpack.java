package app.game.model.spell;

public class Backpack {

    private static int coinSpells;
    private static int freezeSpells;
    private static int healthSpells;
    private static int youngBoySpells;

    public Backpack() {
        coinSpells = 0;
        freezeSpells = 0;
        healthSpells = 0;
        youngBoySpells = 0;
    }

    // GETTERS
    public static int getCoinSpells() {
        return coinSpells;
    }

    public static int getFreezeSpells() {
        return freezeSpells;
    }

    public static int getHealthSpells() {
        return healthSpells;
    }

    public static int getYoungBoySpells() {
        return youngBoySpells;
    }

    // ADD
    public static void addCoinSpells(int n) {
        Backpack.coinSpells += n;
    }

    public static void addFreezeSpells(int n) {
        Backpack.coinSpells += n;
    }

    public static void addHealthSpells(int n) {
        Backpack.coinSpells += n;
    }

    public static void addYoungBoySpells(int n) {
        Backpack.coinSpells += n;
    }

}
