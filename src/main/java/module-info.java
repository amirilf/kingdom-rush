module app.game {
    requires javafx.controls;
    requires javafx.fxml;

    opens app.game to javafx.fxml;

    exports app.game;
}