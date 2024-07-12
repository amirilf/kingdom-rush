package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Pair;
import app.game.model.Database;
import app.game.model.Point;
import app.game.model.map.Map;
import app.game.model.tower.Tower;

public class MapController {

    public static int mapIndex;
    private ContextMenu contextMenu;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView bgImage;

    @FXML
    private Label lbl_wave;

    @FXML
    private Label lbl_coin;

    @FXML
    private Label lbl_health;

    @FXML
    public void initialize() {
        Map map1 = Database.getMaps().get(mapIndex);
        bgImage.setImage(map1.getBg());

        setupEllipses();
    }

    private void setupEllipses() {
        for (Pair<Point, Tower> pair : Database.getMaps().get(mapIndex).getTowers()) {
            Point point = pair.getKey();
            Ellipse ellipse = new Ellipse(point.getX(), point.getY(), 45, 20);
            ellipse.setFill(Color.TRANSPARENT);
            ellipse.setStroke(Color.BLACK);
            ellipse.getStyleClass().add("ellipse");
            root.getChildren().add(ellipse);

            ellipse.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (contextMenu != null && contextMenu.isShowing()) {
                        contextMenu.hide();
                    }
                    showContextMenu(root, ellipse, event.getScreenX(), event.getScreenY());
                }
            });
        }
    }

    private void showContextMenu(Pane root, Ellipse ellipse, double screenX, double screenY) {
        contextMenu = new ContextMenu();
        contextMenu.getStyleClass().add("context-menu");

        MenuItem archerTower = new MenuItem("Archer Tower");
        MenuItem wizardTower = new MenuItem("Wizard Tower");
        MenuItem bombTower = new MenuItem("Bomb Tower");

        archerTower.getStyleClass().add("menu-item");
        wizardTower.getStyleClass().add("menu-item");
        bombTower.getStyleClass().add("menu-item");

        archerTower.setOnAction(event -> placeTower("Archer Tower", screenX, screenY));
        wizardTower.setOnAction(event -> placeTower("Wizard Tower", screenX, screenY));
        bombTower.setOnAction(event -> placeTower("Bomb Tower", screenX, screenY));

        contextMenu.getItems().addAll(archerTower, wizardTower, bombTower);

        contextMenu.show(root, screenX, screenY);

        // hiding context menu when clicking outside
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (contextMenu != null && contextMenu.isShowing() &&
                    (event.getScreenX() < screenX || event.getScreenX() > screenX + contextMenu.getWidth() ||
                            event.getScreenY() < screenY || event.getScreenY() > screenY + contextMenu.getHeight())) {
                contextMenu.hide();
            }
        });
    }

    private void placeTower(String towerType, double x, double y) {
        System.out.println(towerType + " placed at (" + x + ", " + y + ")");
        // TODO: place towers
    }

    @FXML
    private void handlePauseButton() {
        Utility.changeSceneofStage((Stage) root.getScene().getWindow(), "/app/game/fxml/Home.fxml");
    }
}
