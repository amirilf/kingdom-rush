package app.game.model.spell;

public class Backpack {

    private int coinSpells;
    private int freezeSpells;
    private int healthSpells;
    private int youngBoySpells;

    public Backpack() {
        coinSpells = 0;
        freezeSpells = 0;
        healthSpells = 0;
        youngBoySpells = 0;
    }

    // GETTERS
    public int getCoinSpells() {
        return coinSpells;
    }

    public int getFreezeSpells() {
        return freezeSpells;
    }

    public int getHealthSpells() {
        return healthSpells;
    }

    public int getYoungBoySpells() {
        return youngBoySpells;
    }

    // ADD
    public void addCoinSpells(int n) {
        this.coinSpells += n;
    }

    public void addFreezeSpells(int n) {
        this.freezeSpells += n;
    }

    public void addHealthSpells(int n) {
        this.healthSpells += n;
    }

    public void addYoungBoySpells(int n) {
        this.youngBoySpells += n;
    }

    public void addSpells(Spell spell) {

        int quantity = spell.getQuantity();

        System.out.println("HERE!");

        if (spell instanceof CoinSpell)
            addCoinSpells(quantity);
        else if (spell instanceof FreezeSpell)
            addFreezeSpells(quantity);
        else if (spell instanceof HealthSpell)
            addHealthSpells(quantity);
        else if (spell instanceof YoungBoySpell)
            addYoungBoySpells(quantity);

    }
}
