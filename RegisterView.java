
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * this class represent register page's view
 * @author Sevda Imany
 * @version 0.0.0
 */
public class RegisterView extends GridPane {

    /* Fields */
    
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
    public RegisterView() {

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


        //arranging  register vbox in gridpane
        this.add(registerVBox,0,0);
        this.setMinSize(1480,800);
        this.setAlignment(Pos.CENTER);




    }

}