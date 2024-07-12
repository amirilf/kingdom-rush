package app.game.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Pair;
import app.game.model.Database;
import app.game.model.Point;
import app.game.model.map.Map;
import app.game.model.tower.ArcherTower;
import app.game.model.tower.ArtilleryTower;
import app.game.model.tower.Tower;
import app.game.model.tower.TowerEnum;
import app.game.model.tower.WizardTower;

public class MapController {

    public static int mapIndex;
    public static Map currentMap;

    private static ContextMenu contextMenu;
    private static ContextMenu towerContextMenu;
    private static Point lastClickedPoint;

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

        currentMap = Database.getMaps().get(mapIndex);
        bgImage.setImage(currentMap.getBg());

        lbl_coin.setText(String.valueOf(currentMap.getCoins()));
        lbl_health.setText(String.valueOf(currentMap.getHealth()));
        lbl_wave.setText(currentMap.getWaveTxt());

        // set ellipses in map
        setupEllipses();

        // load contexts once
        createContextMenu();
        createTowerContextMenu();
    }

    private void setupEllipses() {
        for (Pair<Point, TowerEnum> pair : Database.getMaps().get(mapIndex).getTowers()) {
            Point point = pair.getKey();
            Ellipse ellipse = new Ellipse(point.getX(), point.getY(), 32, 15);
            ellipse.getStyleClass().add("ellipse");
            root.getChildren().add(ellipse);

            ellipse.setOnMouseClicked(event -> {
                if (contextMenu != null && contextMenu.isShowing()) {
                    contextMenu.hide();
                }
                lastClickedPoint = point; // save the last clicked point
                showContextMenu(root, ellipse, event.getScreenX(), event.getScreenY());
            });
        }
    }

    private void createContextMenu() {

        contextMenu = new ContextMenu();
        contextMenu.getStyleClass().add("context-menu");

        MenuItem archerTower = new MenuItem("Archer Tower");
        MenuItem wizardTower = new MenuItem("Wizard Tower");
        MenuItem artilleryTower = new MenuItem("Artillery Tower");

        // store needed coins to build each tower to check it when player wants
        // to create one them and should be less or equal to the player coin
        archerTower.setUserData(TowerEnum.ARCHER.getConstruction());
        wizardTower.setUserData(TowerEnum.WIZARD.getConstruction());
        artilleryTower.setUserData(TowerEnum.ARTILLERY.getConstruction());

        archerTower.getStyleClass().add("menu-item");
        wizardTower.getStyleClass().add("menu-item");
        artilleryTower.getStyleClass().add("menu-item");

        archerTower.setOnAction(event -> placeTower(TowerEnum.ARCHER));
        wizardTower.setOnAction(event -> placeTower(TowerEnum.WIZARD));
        artilleryTower.setOnAction(event -> placeTower(TowerEnum.ARTILLERY));

        contextMenu.getItems().addAll(archerTower, wizardTower, artilleryTower);
    }

    private void createTowerContextMenu() {

        towerContextMenu = new ContextMenu();
        towerContextMenu.getStyleClass().add("context-menu");

        MenuItem sellTower = new MenuItem("Sell");
        MenuItem upgradeTower = new MenuItem("Upgrade");

        sellTower.getStyleClass().add("menu-item");
        upgradeTower.getStyleClass().add("menu-item");

        sellTower.setOnAction(event -> handleSellTower((ImageView) towerContextMenu.getUserData()));
        upgradeTower.setOnAction(event -> handleUpgradeTower((ImageView) towerContextMenu.getUserData()));

        towerContextMenu.getItems().addAll(sellTower, upgradeTower);
    }

    private void showContextMenu(Pane root, Ellipse ellipse, double screenX, double screenY) {

        // disable items that player can't build according to his coins in the game
        for (MenuItem menuItem : contextMenu.getItems()) {
            if ((int) menuItem.getUserData() > currentMap.getCoins()) {
                menuItem.setDisable(true);
            }
        }

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

    private void showTowerContextMenu(ImageView towerImageView, double screenX, double screenY) {

        // save imageView in userdata to user in its items action methods
        towerContextMenu.setUserData(towerImageView);

        // disable upgrade item if there is not enough coin to upgrade the tower
        // or level is 3 and there is no more levels to upgrade to 0-0
        TowerEnum tower = (TowerEnum) towerImageView.getUserData();
        if (currentMap.getCoins() < tower.getNextLevelConstruction() && tower.getLvl() < 3) {
            towerContextMenu.getItems().getLast().setDisable(true);
        }

        towerContextMenu.show(root, screenX, screenY);

        // hiding context menu when clicking outside
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (towerContextMenu != null && towerContextMenu.isShowing() &&
                    (event.getScreenX() < screenX || event.getScreenX() > screenX + towerContextMenu.getWidth() ||
                            event.getScreenY() < screenY
                            || event.getScreenY() > screenY + towerContextMenu.getHeight())) {
                towerContextMenu.hide();
            }
        });
    }

    private void handleSellTower(ImageView towerImageView) {

        TowerEnum tower = (TowerEnum) towerImageView.getUserData();

        System.out.println("SELLING => NAME: " + tower.getName() + "  LVL: " + tower.getLvl());

        for (Pair<Point, TowerEnum> pair : currentMap.getTowers()) {
            System.out.println(pair.toString());
            if (pair.getValue() != null && pair.getValue().equals(tower)) {
                currentMap.getTowers().remove(pair);
                break;
            }
        }

        // remove tower from Map
        root.getChildren().remove(towerImageView);

        // update coin
        currentMap.setCoins(currentMap.getCoins() + tower.getSellPrice());
        lbl_coin.setText(String.valueOf(currentMap.getCoins()));
    }

    private void handleUpgradeTower(ImageView towerImageView) {

        TowerEnum tower = (TowerEnum) towerImageView.getUserData();

        System.out.println("UPGRADING => NAME: " + tower.getName() + "  LVL: " + tower.getLvl());

        // update tower image
        towerImageView.setImage(tower.getImg());

        // update coins
        currentMap.setCoins(currentMap.getCoins() - tower.getNextLevelConstruction());
        lbl_coin.setText(String.valueOf(currentMap.getCoins()));

        // increase tower lvl
        tower.setLvl(tower.getLvl() + 1); // (lvl & coin conditions should be checked in context menu)
    }

    private void placeTower(TowerEnum towerType) {
        if (lastClickedPoint != null) {

            Tower tower;

            switch (towerType) {
                case ARCHER:
                    tower = new ArcherTower();
                    break;
                case WIZARD:
                    tower = new WizardTower();
                    break;
                case ARTILLERY:
                    tower = new ArtilleryTower();
                    break;
                default:
                    tower = null;
            }

            if (tower != null) {

                // create image of tower
                ImageView towerImage = new ImageView(tower.obj().getImg());
                towerImage.setLayoutX(lastClickedPoint.getX() - tower.obj().getDiffX());
                towerImage.setLayoutY(lastClickedPoint.getY() - tower.obj().getDiffY());
                towerImage.getStyleClass().add("img-tower");
                towerImage.setUserData(tower.obj()); // save tower into the imageView
                root.getChildren().add(towerImage);

                // update coins
                currentMap.setCoins(currentMap.getCoins() - tower.obj().getConstruction());
                lbl_coin.setText(String.valueOf(currentMap.getCoins()));

                towerImage.setOnMouseClicked(event -> {
                    showTowerContextMenu(towerImage, event.getScreenX(), event.getScreenY());
                });

                // update pair
                for (int i = 0; i < currentMap.getTowers().size(); i++) {
                    Pair<Point, TowerEnum> pair = currentMap.getTowers().get(i);
                    if (pair.getKey().equals(lastClickedPoint)) {
                        currentMap.getTowers().set(i, new Pair<>(lastClickedPoint, tower.obj()));
                        break;
                    }
                }

            } else {
                System.out.println("tower is null");
            }
        } else {
            System.out.println("point is null");
        }
    }

    @FXML
    private void handlePauseButton() {
        // TODO: reset map values (like coin,health,wave or ...)
        Utility.changeSceneofStage((Stage) root.getScene().getWindow(), "/app/game/fxml/Home.fxml");
    }
}
