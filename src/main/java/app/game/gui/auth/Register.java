package app.game.gui.auth;

import app.game.gui.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register {

    @FXML
    private TextField fld_name;

    @FXML
    private TextField fld_username;

    @FXML
    private TextField fld_password;

    @FXML
    private void handleRegisterButton() {
        System.out.println("Register button clicked!");
    }

    @FXML
    private void handleLoginPageButton() {
        Utility.changeSceneofStage((Stage) fld_name.getScene().getWindow(), "/app/game/fxml/auth/Login.fxml");
    }

    @FXML
    private void handleAuthPageButton() {
        Utility.changeSceneofStage((Stage) fld_name.getScene().getWindow(), "/app/game/fxml/auth/Auth.fxml");
    }

}
