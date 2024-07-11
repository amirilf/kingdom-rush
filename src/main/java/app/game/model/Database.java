package app.game.model;

import java.util.ArrayList;
import java.util.Optional;

public class Database {

    // STATIC FIELDS
    private static ArrayList<Map> maps = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();

    // CURRENT DATA
    private static Player currentPlayer;

    // GETTERS
    public static ArrayList<Map> getMaps() {
        return maps;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    // AUTH
    public static boolean login(String username, String password) {

        Optional<Player> playerOpt = players.stream()
                .filter(player -> player.getUsername().equals(username) && player.getPassword().equals(password))
                .findFirst();

        if (playerOpt.isPresent()) {
            currentPlayer = playerOpt.get();
            return true;
        }
        return false;
    }

    public static boolean signup(String name, String username, String password) {

        boolean exists = players.stream().anyMatch(player -> player.getUsername().equals(username));

        if (exists)
            return false;

        // create and login the player
        Player player = new Player(name, username, password);
        players.add(player);
        currentPlayer = player;
        return true;
    }

    public static void logout() {
        currentPlayer = null;
    }
}
