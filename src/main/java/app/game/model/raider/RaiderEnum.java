package app.game.model.raider;

import javafx.scene.image.Image;

public enum RaiderEnum {

    WOLF("Wolf", "/app/game/media/raiders/wolf/1.png", 50, 300, SpeedEnum.VERY_FAST, 5, 0),
    QUEEN("Queen", "/app/game/media/raiders/queen/1.png", 50, 1000, SpeedEnum.NORMAL, 102, 20),
    IMMORTAL("Immortal", "/app/game/media/raiders/immortal/1.png", 200, 1000, SpeedEnum.SLOW, 5, 0),
    THUG("Thug", "/app/game/media/raiders/thug/1.png", 100, 500, SpeedEnum.FAST, 5, 0);

    private String name;
    private Image img;
    private int loot;

    // main parameters
    private int health;
    private SpeedEnum speed;
    private int damage;
    private int altitude;

    // path
    // private Path path;
    // private PathTransition transition; // will be created in move method!

    RaiderEnum(String name, String img_path, int loot, int health, SpeedEnum speed, int damage, int altitude) {
        this.name = name;
        this.img = new Image(getClass().getResource(img_path).toString());
        this.loot = loot;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.altitude = altitude;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public Image getImg() {
        return img;
    }

    public int getLoot() {
        return loot;
    }

    public int getHealth() {
        return health;
    }

    public SpeedEnum getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getAltitude() {
        return altitude;
    }

    // SETTERS
    public void setHealth(int health) {
        this.health = health;
    }

}

enum SpeedEnum {
    VERYS_LOW(0.5), SLOW(0.8), NORMAL(1), FAST(1.3), VERY_FAST(1.8);

    private double speed;

    SpeedEnum(double n) {
        this.speed = n;
    }

    public double getSpeed() {
        return speed;
    }
}