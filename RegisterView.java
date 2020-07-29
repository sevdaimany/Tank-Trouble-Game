
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.FileInputStream;







/**
 * This class represent register page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class RegisterView extends GridPane 
{

            /*  Fields  */
    
    // username's text field
    private TextField username;

    // password's text field
    private TextField password;

    // repeat password's text field
    private TextField repeatPassword;

    // firstname's text field
    private TextField firstname;

    // lastname's text field
    private TextField lastname;

    // register's button
    private Button registerBTN;









         /* Constructor */


    /**
     * create register page's view
     */
    public RegisterView() 
    {

        //create username text field
        username = new TextField();
        username.setPromptText("username");
        username.setAlignment(Pos.CENTER);


        //create password text field
        password = new TextField();
        password.setPromptText("password");
        password.setAlignment(Pos.CENTER);


        //create repeat password text field
        repeatPassword = new TextField();
        repeatPassword.setPromptText("repeat password");
        repeatPassword.setAlignment(Pos.CENTER);


        //create firstname text field
        firstname = new TextField();
        firstname.setPromptText("firstname");
        firstname.setAlignment(Pos.CENTER);


        //create lastname text field
        lastname = new TextField();
        lastname.setPromptText("lastname");
        lastname.setAlignment(Pos.CENTER);


        //create register button
        registerBTN = new Button("Register");
        registerBTN.setAlignment(Pos.CENTER);


        //create register text
        Text registerTXT = new Text("REGISTER");
        registerTXT.setFill(Color.ORANGE);
        registerTXT.setStroke(Color.BLACK);
        registerTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        registerTXT.setStrokeWidth(2);


        //set first and last name in hbox
        HBox fullnameHBox = new HBox(firstname,lastname);


        //set fields in vbox
        VBox registerVBox = new VBox(registerTXT,fullnameHBox,username,password,repeatPassword,registerBTN);
        registerVBox.setSpacing(5);
        registerVBox.setAlignment(Pos.CENTER);


        //background picture
        FileInputStream input = null;

        try 
        {
            input = new FileInputStream(".//icons//pic.jpg");
        }catch (Exception e){}

        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);



        //arranging  register vbox in grid pane
        this.add(registerVBox,0,0);
        this.setMinSize(1480,800);
        this.setAlignment(Pos.CENTER);

        
        //set background picture
        this.setBackground(new Background(backgroundimage));
    }
}
