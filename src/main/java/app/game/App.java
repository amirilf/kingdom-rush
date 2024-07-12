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
import javafx.scene.shape.StrokeType;
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
            Database.signup(player.getName(), player.getUsername(), player.getPassword());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/game/fxml/auth/Auth.fxml"));
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
        loadWaves();
    }

    public static void loadWaves() {

        Database.getMaps().forEach(map -> map.getWaves().clear());

        Wave wave11 = new Wave(4, 0, 0, 0);
        Wave wave12 = new Wave(0, 2, 2, 2);
        Database.getMaps().get(0).getWaves().addAll(List.of(wave11, wave12));
    }

    public static void loadTowerPositions() {

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

    public static void loadPaths() {

        Path path11 = new Path();
        path11.setFill(Color.TRANSPARENT);
        path11.setLayoutX(238.0);
        path11.setLayoutY(256.0);
        path11.setStroke(Color.BLACK);
        path11.setStrokeType(StrokeType.INSIDE);
        path11.getElements().addAll(
                new MoveTo(970.0, 130.0),
                new LineTo(600.0, 130.0),
                new LineTo(600.0, 100.0),
                new LineTo(580.0, 50.0),
                new LineTo(520.0, 50.0),
                new LineTo(470.0, -30.0),
                new LineTo(220.0, -30.0),
                new LineTo(180.0, -30.0),
                new LineTo(120.0, 100.0),
                new LineTo(100.0, 120.0),
                new LineTo(-80.0, 120.0));

        Path path12 = new Path();
        path12.setFill(Color.TRANSPARENT);
        path12.setLayoutX(248.0);
        path12.setLayoutY(285.0);
        path12.setStroke(Color.BLACK);
        path12.setStrokeType(StrokeType.INSIDE);
        path12.getElements().addAll(
                new MoveTo(970.0, 130.0),
                new LineTo(600.0, 130.0),
                new LineTo(600.0, 100.0),
                new LineTo(580.0, 50.0),
                new LineTo(520.0, 50.0),
                new LineTo(470.0, -50.0),
                new LineTo(220.0, -50.0),
                new LineTo(180.0, -50.0),
                new LineTo(120.0, 100.0),
                new LineTo(100.0, 120.0),
                new LineTo(-80.0, 120.0));

        Path path13 = new Path();
        path13.setFill(Color.TRANSPARENT);
        path13.setLayoutX(242.0);
        path13.setLayoutY(453.0);
        path13.setScaleY(-1.0);
        path13.setStroke(Color.BLACK);
        path13.setStrokeType(StrokeType.INSIDE);
        path13.getElements().addAll(
                new MoveTo(970.0, 130.0),
                new LineTo(600.0, 130.0),
                new LineTo(600.0, 100.0),
                new LineTo(580.0, 50.0),
                new LineTo(520.0, 50.0),
                new LineTo(470.0, -30.0),
                new LineTo(220.0, -30.0),
                new LineTo(180.0, -30.0),
                new LineTo(120.0, 100.0),
                new LineTo(100.0, 120.0),
                new LineTo(-80.0, 120.0));

        Path path14 = new Path();
        path14.setFill(Color.TRANSPARENT);
        path14.setLayoutX(250.0);
        path14.setLayoutY(439.0);
        path14.setScaleY(-1.0);
        path14.setStroke(Color.BLACK);
        path14.setStrokeType(StrokeType.INSIDE);
        path14.getElements().addAll(
                new MoveTo(970.0, 130.0),
                new LineTo(600.0, 130.0),
                new LineTo(600.0, 100.0),
                new LineTo(580.0, 50.0),
                new LineTo(520.0, 50.0),
                new LineTo(470.0, -10.0),
                new LineTo(220.0, -20.0),
                new LineTo(180.0, -20.0),
                new LineTo(120.0, 100.0),
                new LineTo(100.0, 120.0),
                new LineTo(-80.0, 120.0));

        Database.getMaps().get(0).getPaths().addAll(List.of(path11, path12, path13, path14));

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