package app.game.model;

public class Player {

    // ID generator
    private static int IDGenerator = 1;
    private static int defaultDiamond = 100;

    private int id;
    private String username;
    private String password;
    private int level;
    private int diamond;
    private int backpack; // TODO: int?

    Player(int id, String username, String password, int diamond, int backpack) {
        this.id = IDGenerator++;
        this.username = username;
        this.password = password;
        this.level = 1; // starting level
        this.diamond = defaultDiamond; // starting diamond
        this.backpack = backpack; // TODO : ?
    }

    // GETTERS
    public int getId() {
        return id;
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

    public int getBackpack() {
        return backpack;
    }

    // SETTERS
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

    public void setBackpack(int backpack) {
        this.backpack = backpack;
    }

}
