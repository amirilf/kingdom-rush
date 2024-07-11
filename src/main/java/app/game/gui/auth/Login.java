package app.game.gui.auth;

import app.game.gui.Utility;
import app.game.model.Database;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    @FXML
    private TextField fld_username;

    @FXML
    private PasswordField fld_password;

    @FXML
    private void handleLoginButton() {

        String username = fld_username.getText();
        String password = fld_password.getText();

        boolean res = Database.login(username, password);

        if (res) {
            Utility.changeSceneofStage((Stage) fld_username.getScene().getWindow(), "/app/game/fxml/Home.fxml");
        } else
            System.out.println("The username or password is incorrect");
    }

    @FXML
    private void handleRegisterPageButton() {
        Utility.changeSceneofStage((Stage) fld_username.getScene().getWindow(), "/app/game/fxml/auth/Register.fxml");
    }

    @FXML
    private void handleAuthPageButton() {
        Utility.changeSceneofStage((Stage) fld_password.getScene().getWindow(), "/app/game/fxml/auth/Auth.fxml");
    }
}
