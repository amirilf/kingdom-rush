package app.game.model;

import app.game.model.spell.Backpack;

public class Player {

    // ID generator
    private static int IDGenerator = 1;
    private static int defaultDiamond = 1500;

    private int id;
    private String name;
    private String username;
    private String password;
    private int level;
    private int diamond;
    private Backpack backpack;

    public Player(String name, String username, String password) {
        this.id = IDGenerator++;
        this.name = name;
        this.username = username;
        this.password = password;
        this.level = 1; // starting level
        this.diamond = defaultDiamond; // starting diamond
        this.backpack = new Backpack();

    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getDiamond() {
        return diamond;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
}
