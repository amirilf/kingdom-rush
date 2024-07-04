module app.game {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens app.game to javafx.fxml;
    opens app.game.model to javafx.fxml;
    opens app.game.gui.map to javafx.fxml;

    exports app.game;
    exports app.game.model;
    exports app.game.gui.map;

}