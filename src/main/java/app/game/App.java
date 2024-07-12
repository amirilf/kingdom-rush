package app.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.game.model.Database;
import app.game.model.Player;
import app.game.model.Point;
import app.game.model.Wave;
import app.game.model.map.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Pair;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // LOAD DATA
        loadData();

        // START APPLICATION
        try {

            Player player = new Player("Amir", "amirilf", "1234");
            player.setDiamond(player.getDiamond() + 5000);
            Database.login("amirilf", "1234");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/game/fxml/Map.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Kingdom rush");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void loadData() {
        loadMaps();
        loadPaths();
        loadTowerPositions();
    }

    private void loadTowerPositions() {

        // lvl1 tower places
        Point p11 = new Point(587, 302);
        Point p12 = new Point(960, 494);
        Point p13 = new Point(864, 224);
        Point p14 = new Point(591, 495);
        Point p15 = new Point(546, 667);
        Point p16 = new Point(326, 213);

        Map map1 = Database.getMaps().get(0);

        map1.getTowers().clear();

        map1.getTowers().addAll(List.of(
                new Pair<>(p11, null),
                new Pair<>(p12, null),
                new Pair<>(p13, null),
                new Pair<>(p14, null),
                new Pair<>(p15, null),
                new Pair<>(p16, null)));
    }

    private void loadPaths() {

        Path path11 = new Path();
        path11.setLayoutX(-11.0);
        path11.setLayoutY(-4.0);
        path11.setStroke(Color.BLACK);
        path11.getElements().add(new MoveTo(280.0, -10.0));
        path11.getElements().add(new VLineTo(190.0));
        path11.getElements().add(new LineTo(250.0, 200.0));
        path11.getElements().add(new LineTo(150.0, 250.0));
        path11.getElements().add(new LineTo(110.0, 300.0));
        path11.getElements().add(new LineTo(110.0, 350.0));
        path11.getElements().add(new LineTo(160.0, 410.0));
        path11.getElements().add(new LineTo(250.0, 425.0));
        path11.getElements().add(new LineTo(355.0, 410.0));
        path11.getElements().add(new LineTo(450.0, 440.0));
        path11.getElements().add(new LineTo(480.0, 440.0));
        path11.getElements().add(new LineTo(580.0, 350.0));
        path11.getElements().add(new LineTo(880.0, 350.0));

        Path path22 = new Path();
        path22.setLayoutX(-1.0);
        path22.setLayoutY(6.0);
        path22.setStroke(Color.BLACK);
        path22.getElements().add(new MoveTo(290.0, -10.0));
        path22.getElements().add(new VLineTo(190.0));
        path22.getElements().add(new LineTo(150.0, 250.0));
        path22.getElements().add(new LineTo(120.0, 300.0));
        path22.getElements().add(new LineTo(120.0, 350.0));
        path22.getElements().add(new LineTo(180.0, 400.0));
        path22.getElements().add(new LineTo(350.0, 380.0));
        path22.getElements().add(new LineTo(450.0, 410.0));
        path22.getElements().add(new LineTo(550.0, 320.0));
        path22.getElements().add(new LineTo(860.0, 320.0));

        Database.getMaps().get(0).getPaths().add(path11);
        Database.getMaps().get(0).getPaths().add(path22);

    }

    private void loadMaps() {

        Image bg1 = new Image(getClass().getResource("/app/game/media/map/map1.png").toString());
        Image bg2 = new Image(getClass().getResource("/app/game/media/map/map2.png").toString());
        Image bg3 = new Image(getClass().getResource("/app/game/media/map/map3.png").toString());
        Image bg4 = new Image(getClass().getResource("/app/game/media/map/map4.png").toString());

        Map map1 = new Map(new ArrayList<Wave>(3), 400, bg1);
        Map map2 = new Map(new ArrayList<Wave>(5), 600, bg2);
        Map map3 = new Map(new ArrayList<Wave>(7), 800, bg3);
        Map map4 = new Map(new ArrayList<Wave>(9), 1000, bg4);

        Database.getMaps().add(map1);
        Database.getMaps().add(map2);
        Database.getMaps().add(map3);
        Database.getMaps().add(map4);

    }
}