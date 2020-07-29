import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Pos;


/**
 * this class represent login page
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class LoginView extends BorderPane {

            /*  Fields  */


    //player's username
    private TextField username;

    //player's password
    private TextField password;

    //login button
    private Button loginBTN;

            /*  Constructor  */


    public LoginView() {

        //create username field
        username = new TextField();
        username.setPromptText("username");
        username.setAlignment(Pos.CENTER);

        //create password field
        password = new TextField();
        password.setPromptText("password");
        password.setAlignment(Pos.CENTER);

        //create login button
        loginBTN = new Button("Login");
        loginBTN.setAlignment(Pos.CENTER);
        loginBTN.setMinWidth(70);

      
    }


            /*  Methods  */

    // * getter methods *



    /**
     * @return player's username
     */
    public TextField getUsername() {
        return username;
    }


    /** 
     * @return player's password
     */
    public TextField getPassword() {
        return password;
    }



    /**
     * @return login button
     */
    public Button getLoginBTN() {
        return loginBTN;
    }
}
