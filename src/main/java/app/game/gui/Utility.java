package app.game.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utility {

    public static void changeSceneofStage(Stage stage, String path) {

        // change the scene of the given stage using FXML file path.

        try {
            FXMLLoader loader = new FXMLLoader(Utility.class.getResource(path));
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
