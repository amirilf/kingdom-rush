package app.game.model.spell;

public abstract class Spell implements SpellInterface {

    private SpellEnum spellObj;

    Spell(SpellEnum spellEnum) {
        this.spellObj = spellEnum;
    }

    @Override
    public int getPrice() {
        return spellObj.getPrice();
    }

    public String getName() {
        return spellObj.getName();
    }

    public String getDetail() {
        return spellObj.getDetail();
    }

    public int getQuantity() {
        return spellObj.getQuantity();
    }

}
