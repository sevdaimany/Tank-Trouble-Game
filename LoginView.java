import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.scene.control.Label;
import javafx.geometry.Rectangle2D;
import java.io.FileInputStream;
import javafx.scene.image.Image;








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

        //create login text
        Text loginTXT = new Text("LOGIN");
        loginTXT.setFill(Color.ORANGE);
        loginTXT.setStroke(Color.BLACK);
        loginTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        loginTXT.setStrokeWidth(2);



        //set nodes
        VBox login = new VBox(loginTXT,new Label(" "),username,password,loginBTN);
        login.setAlignment(Pos.CENTER);
        login.setMaxWidth(320);
        login.setSpacing(5);

        //background
        FileInputStream input = null;
        try {
            input = new FileInputStream(".//icons//pic.jpg");
        }catch (Exception e){}
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //set login vbox in borderpane
        this.setCenter(login);
        this.setBackground(new Background(backgroundimage));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);



      
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
