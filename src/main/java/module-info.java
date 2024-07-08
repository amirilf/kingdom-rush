module app.game {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens app.game to javafx.fxml;

    exports app.game;

    opens app.game.model to javafx.fxml;

    exports app.game.model;

    opens app.game.gui to javafx.fxml;

    exports app.game.gui;

    opens app.game.model.spell to javafx.fxml;

    exports app.game.model.spell;

}