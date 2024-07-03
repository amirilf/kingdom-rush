module app.game {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens app.game to javafx.fxml;

    exports app.game;

}