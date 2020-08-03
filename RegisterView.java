
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

/**
 * This class represent register page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class RegisterView extends BorderPane{

    /* Fields */

    // username's text field
    private TextField username;

    // password's text field
    private PasswordField password;

    // repeat password's text field
    private PasswordField repeatPassword;

    // firstname's text field
    private TextField firstname;

    // lastname's text field
    private TextField lastname;

    // register's button
    private Button registerBTN;

    // error label
    private Label errorLable;

     //menu button
     private Button menu;


    /* Constructor */

    /**
     * create register page's view
     */
    public RegisterView() {

        // create username text field
        username = new TextField();
        username.setPromptText("username");
        username.setAlignment(Pos.CENTER);

        // create password text field
        password = new PasswordField();
        password.setPromptText("password");
        password.setAlignment(Pos.CENTER);

        // create repeat password text field
        repeatPassword = new PasswordField();
        repeatPassword.setPromptText("password confirmation");
        repeatPassword.setAlignment(Pos.CENTER);

        // create firstname text field
        firstname = new TextField();
        firstname.setPromptText("firstname");
        firstname.setAlignment(Pos.CENTER);

        // create lastname text field
        lastname = new TextField();
        lastname.setPromptText("lastname");
        lastname.setAlignment(Pos.CENTER);

        // create register button
        registerBTN = new Button("Register");
        registerBTN.setAlignment(Pos.CENTER);

        // create error button
        errorLable = new Label();
        errorLable.setTextFill(Color.RED);
        errorLable.setFont(Font.font(15));
        errorLable.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        // create register text
        Text registerTXT = new Text("REGISTER");
        registerTXT.setFill(Color.ORANGE);
        registerTXT.setStroke(Color.BLACK);
        registerTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        registerTXT.setStrokeWidth(2);

        // set first and last name in hbox
        HBox fullnameHBox = new HBox(firstname, lastname);

        // set fields in vbox
        VBox registerVBox = new VBox(registerTXT, new Label(" "), errorLable, fullnameHBox, username, password,
                repeatPassword, registerBTN);
        registerVBox.setSpacing(5);
        registerVBox.setAlignment(Pos.CENTER);
        registerVBox.setMaxWidth(300);

        //set menu button
        FileInputStream input1 = null;
        try {
            input1 = new FileInputStream(".//icons//go_back.png");
        }
        catch (IOException e){}
            Image icon1 = new Image(input1);
            ImageView imageView1 = new ImageView(icon1);
             menu = new Button("Menu" , imageView1);



        // background picture
        FileInputStream input = null;

        try {
            input = new FileInputStream(".//icons//pic.jpg");
        } catch (Exception e) {
        }

        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        // arranging register vbox in borderpane
        this.setCenter(registerVBox);

        this.setLeft(menu);
        this.setPadding(new Insets(5, 5, 5, 5));


        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight() - 60);

        // set background picture
        this.setBackground(new Background(backgroundimage));
    }

    /**
     * @return username TextField
     */
    public TextField getUsername() {
        return username;
    }

    /**
     * @return password PasswordField
     */
    public PasswordField getPassword() {
        return password;
    }

    /**
     * @return password confirmation
     */
    public PasswordField getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * @return firstname textField
     */
    public TextField getFirstname() {
        return firstname;
    }


    /**
     * @return lastname TextField
     */
    public TextField getLastname() {
        return lastname;
    }

    /**
     * @return register Button
     */
    public Button getRegisterBTN() {
        return registerBTN;
    }


    /**
     * @return error Label
     */
    public Label getErrorLable() {
        return errorLable;
    }


    /**
     * @return menu button
     */
    public Button getMenu() {
        return menu;
    }
}
