package app.game.model;

import java.util.ArrayList;

public class Database {

    // STATIC FIELDS
    private static ArrayList<Map> maps = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();

    // GETTERS
    public static ArrayList<Map> getMaps() {
        return maps;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
