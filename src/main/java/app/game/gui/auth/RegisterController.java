package app.game.gui.auth;

import app.game.gui.Utility;
import app.game.model.Database;
import app.game.model.Song;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField fld_name;

    @FXML
    private TextField fld_username;

    @FXML
    private TextField fld_password;

    @FXML
    private void handleRegisterButton() {

        String name = fld_name.getText();
        String username = fld_username.getText();
        String password = fld_password.getText();

        boolean res = Database.signup(name, username, password);

        if (res) {
            Utility.changeSceneofStage((Stage) fld_username.getScene().getWindow(), "/app/game/fxml/Home.fxml");
            Song.setMute(false);
        } else
            System.out.println("Smth is wrong.");

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
