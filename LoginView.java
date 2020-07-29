import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


import java.io.FileInputStream;

public class LoginView extends BorderPane {
    private TextField username;
    private TextField password;
    private Button loginBTN;

    public LoginView() {
      
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getPassword() {
        return password;
    }

    public Button getLoginBTN() {
        return loginBTN;
    }
}
