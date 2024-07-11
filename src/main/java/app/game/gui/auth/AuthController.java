package app.game.gui.auth;

import app.game.gui.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AuthController {

    @FXML
    private Label lbl_login; // only for getting stage

    @FXML
    private void handleLoginButton() {
        Utility.changeSceneofStage((Stage) lbl_login.getScene().getWindow(),
                "/app/game/fxml/auth/Login.fxml");
    }

    @FXML
    private void handleRegisterButton() {
        Utility.changeSceneofStage((Stage) lbl_login.getScene().getWindow(), "/app/game/fxml/auth/Register.fxml");
    }
}
