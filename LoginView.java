import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.geometry.Rectangle2D;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;








/**
 * This class represent login page
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class LoginView extends BorderPane 
{

            /*  Fields  */


    //player's username
    private TextField username;

    //player's password
    private TextField password;

    //login button
    private Button loginBTN;

     //menu button
     private Button menu;

     // error label
    private Label errorLable;


    //choose tank's color
    private static ChoiceBox<String> choiceBox;
    private static RadioButton radioButton1;
    private static RadioButton radioButton2;
    private static RadioButton radioButton3;











         /* Constructor */

    public LoginView() 
    {
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


        // create error button
        errorLable = new Label();
        errorLable.setTextFill(Color.RED);
        errorLable.setFont(Font.font(15));
        errorLable.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //set nodes
        VBox login = new VBox(loginTXT,new Label(" "), errorLable ,username,password,loginBTN);
        login.setAlignment(Pos.CENTER);
        login.setMaxWidth(320);
        login.setSpacing(5);

          //set menu button
          FileInputStream input1 = null;

          try { input1 = new FileInputStream(DataBase.getGoBackIcon()); }
          catch (IOException e){}
  
          Image icon1 = new Image(input1);
          ImageView imageView1 = new ImageView(icon1);
          menu = new Button("Menu" , imageView1);
  


        //background
        FileInputStream input = null;
        try 
        {
            input = new FileInputStream(DataBase.getBackgroundIconPath());
        }catch (Exception e){}

        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        //set login vbox in borderpane
        this.setCenter(login);
        this.setLeft(menu);
        this.setRight(new Label("                               "));
        this.setPadding(new Insets(5, 5, 5, 5));

        this.setBackground(new Background(backgroundimage));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);      
    }







            /*  Methods  */


     public static void firstCall(){
        //create a choicebox
        choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll("Red","Blue","Green","Sand","Purple","Pink","Yellow","Orange","White","Black","Gray");


        // create radio buttons
        radioButton1 = new RadioButton("WASD");
        radioButton2 = new RadioButton("UP DOWN");
        radioButton3 = new RadioButton("MOUSE");

    }



    // * getter methods *

    /**
     * @return player's username
     */
    public TextField getUsername() { return username; }
    /** 
     * @return player's password
     */
    public TextField getPassword() { return password; }
    /**
     * @return login button
     */
    public Button getLoginBTN() { return loginBTN; }
     /**
     * @return menu button
     */
    public Button getMenu() { return menu; }
      /**
     * @return error Label
     */
    public Label getErrorLable() { return errorLable; }



       /**
     * @return choicebox
     */
    public static  ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    /**
     * @return radiobutton1
     */
    public static RadioButton getRadioButton1() {
        return radioButton1;
    }

    /**
     * @return radiobutton2
     */
    public  static  RadioButton getRadioButton2() {
        return radioButton2;
    }

    /**
     * @return radiobutton3
     */
    public static RadioButton getRadioButton3() {
        return radioButton3;
    }





    /**
     * this inner class represent a tank and controller chooser page in game after player login
     */
    class TankControllerChooser extends BorderPane{

        //start game button
        private Button button;
        //menu button
        private Button menu;
        // error label
        private Label errorLable;





        public TankControllerChooser(){


            // create radio buttons
            radioButton1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            radioButton2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            radioButton3.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));



            FileInputStream input = null;
            try {
                input = new FileInputStream(DataBase.getQButtonImage());
            }catch(IOException e){}
            Image imageQ = new Image(input);
            ImageView imageViewQ = new ImageView(imageQ);
            imageViewQ.setBlendMode(BlendMode.DARKEN);

            FileInputStream input1 = null;
            try {
                input1 = new FileInputStream(DataBase.getWsadKeysImage());
            }catch(IOException e){}
            Image imageWASD = new Image(input1);
            ImageView imageViewWASD = new ImageView(imageWASD);
            imageViewWASD.setBlendMode(BlendMode.DARKEN);

            HBox hBoxWSDF = new HBox(imageViewQ,imageViewWASD);



            FileInputStream input2 = null;
            try {
                input2 = new FileInputStream(DataBase.getMButtonImage());
            }catch(IOException e){}
            Image imageM = new Image(input2);
            ImageView imageViewM = new ImageView(imageM);
            imageViewM.setBlendMode(BlendMode.DARKEN);


            FileInputStream input3 = null;
            try {
                input3 = new FileInputStream(DataBase.getUpdownKeysImage());
            }catch(IOException e){}
            Image imageUPDOWN = new Image(input3);
            ImageView imageViewUPDOWN = new ImageView(imageUPDOWN);
            imageViewUPDOWN.setBlendMode(BlendMode.DARKEN);

            HBox hBoxUPDOWN = new HBox(imageViewM,imageViewUPDOWN);

            FileInputStream input4 = null;
            try {
                input4 = new FileInputStream(DataBase.getMouseImage());
            }catch(IOException e){}
            Image imageMOUSE = new Image(input4);
            ImageView imageViewMOUSE = new ImageView(imageMOUSE);
            imageViewMOUSE.setBlendMode(BlendMode.DARKEN);


           // create error label
            errorLable = new Label();
            errorLable.setTextFill(Color.RED);
            errorLable.setFont(Font.font(15));
            errorLable.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


            //create a choicebox
            Label label = new Label("Choose your tank's color");
            label.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            HBox hBox = new HBox(label,choiceBox);
            hBox.setSpacing(10);



            //create top page's text
             Text chooseTXT = new Text("               PLEASE CHOOSE");
             chooseTXT.setFill(Color.ORANGE);
             chooseTXT.setStroke(Color.BLACK);
             chooseTXT.setStrokeWidth(4);
             chooseTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 70));

             //create start game's button
             button = new Button("START GAME");
             button.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
             button.setTextFill(Color.DARKORANGE);
             button.setAlignment(Pos.CENTER);
             button.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY) ));

            //arranging nodes in gridpane
            GridPane gridPane = new GridPane();
            gridPane.add(hBoxWSDF , 0,0);
            gridPane.add(hBoxUPDOWN,1,0);
            gridPane.add(imageViewMOUSE,2,0);
            gridPane.add(radioButton1,0,1);
            gridPane.add(radioButton2,1,1);
            gridPane.add(radioButton3,2,1);
            gridPane.add(hBox,0,3);
            gridPane.add(errorLable,0,4);
            gridPane.add(button,0,5);
            gridPane.setHgap(20);
            gridPane.setVgap(30);
            gridPane.setAlignment(Pos.CENTER);



            
            
            //set menu button
            FileInputStream input6 = null;

            try { input6 = new FileInputStream(DataBase.getGoBackIcon()); }
            catch (IOException e){}

            Image icon1 = new Image(input6);
            ImageView imageView1 = new ImageView(icon1);
            menu = new Button("Menu" , imageView1);


            //background
            FileInputStream input5 = null;
            try
            {
                input5 = new FileInputStream(DataBase.getBackgroundIconPath());
            }catch (Exception e){}

            Image image = new Image(input5);
            BackgroundImage backgroundimage = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            this.setBackground(new Background(backgroundimage));

            HBox hboxTop = new HBox(menu,chooseTXT);
            this.setCenter(gridPane);
            this.setTop(hboxTop);

            this.setPadding(new Insets(5, 5, 5, 5));

            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);

        }


      
        /**
         * @return start game's button
         */
        public Button getButton() {
            return button;
        }
         /**
         * @return menu button
         */
        public Button getMenu() { return menu; }

         /**
         * @return error Label
         */
        public Label getErrorLable() { return errorLable; }



        
 

    }

}
