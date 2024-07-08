package app.game;

import java.io.IOException;

import app.game.model.DB;
import app.game.model.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // LOAD DATA
        loadData();

        // START APPLICATION
        try {
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

        DB.getMaps().get(0).getPaths().add(path11);
        DB.getMaps().get(0).getPaths().add(path22);

    }

    private void loadMaps() {

        ImageView imageView1 = new ImageView(
                new Image(getClass().getResource("/app/game/media/map/map1.png").toString()));
        ImageView imageView2 = new ImageView(
                new Image(getClass().getResource("/app/game/media/map/map2.png").toString()));
        ImageView imageView3 = new ImageView(
                new Image(getClass().getResource("/app/game/media/map/map3.png").toString()));
        ImageView imageView4 = new ImageView(
                new Image(getClass().getResource("/app/game/media/map/map4.png").toString()));

        Map map1 = new Map(0, 0, imageView1);
        Map map2 = new Map(0, 0, imageView2);
        Map map3 = new Map(0, 0, imageView3);
        Map map4 = new Map(0, 0, imageView4);

        DB.getMaps().add(map1);
        DB.getMaps().add(map2);
        DB.getMaps().add(map3);
        DB.getMaps().add(map4);

    }
}