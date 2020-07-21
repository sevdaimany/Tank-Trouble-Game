import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.scene.Scene;









/**
 * Gui class represent game's gui
 * 
 * @author Sevda Imany
 * @version 0.1.0
 */
public class Gui extends Application {
    
    

    public static void main(String[] args) {

        launch(args);
    }

    
    /** 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        creatMenuPage(primaryStage);
    }
 

    
    /** 
     * creat game's menu page
     * @param primaryStage
     * @throws Exception
     */
    public static void creatMenuPage(Stage primaryStage) throws Exception {

        // create 1 player button
        FileInputStream input1 = new FileInputStream(".//icons//tank_blue.png");
        Image icon1 = new Image(input1);
        ImageView imageView1 = new ImageView(icon1);
        Button button1 = new Button("   1 PLAYER   ",imageView1);


        // create 2 players button
        FileInputStream input2 = new FileInputStream(".//icons//tank_green.png");
        Image icon2 = new Image(input2);
        ImageView imageView2 = new ImageView(icon2);
        Button button2 = new Button("   2 PLAYERS  ",imageView2);

        // create 3 players button
        FileInputStream input3 = new FileInputStream(".//icons//tank_sand.png");
        Image icon3 = new Image(input3);
        ImageView imageView3 = new ImageView(icon3);
        Button button3 = new Button("   3 PLAYERS  ",imageView3);

        // create server button
        FileInputStream input4 = new FileInputStream(".//icons//tank_red.png");
        Image icon4 = new Image(input4);
        ImageView imageView4 = new ImageView(icon4);
        Button button4 = new Button("    SERVER    ",imageView4);

        // create leaboard button
        FileInputStream input5 = new FileInputStream(".//icons//star.png");
        Image icon5 = new Image(input5);
        ImageView imageView5 = new ImageView(icon5);
        Button button5 = new Button("   LEABOARDS  ",imageView5);

        // set buttons to  hbox 
        HBox hBox = new HBox(button1,button2,button3,button4,button5);
        //Setting the hbox alignment 
        hBox.setAlignment(Pos.CENTER);
        //setting the spacing
        hBox.setSpacing(10);


        //creating 'tank trouble' text
        Text gameTXT = new Text("TANK TROUBLE");
        gameTXT.setFill(Color.ORANGE);
        gameTXT.setStroke(Color.BLACK);
        gameTXT.setStrokeWidth(4);
        gameTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));

        FadeTransition textTransition = new FadeTransition(Duration.seconds(0.3), gameTXT);
        textTransition.setAutoReverse(true);
        textTransition.setFromValue(0);
        textTransition.setToValue(1);
        textTransition.setCycleCount(Transition.INDEFINITE);
        textTransition.play();

        // set hBox and gameTXT to VBox
        VBox vBox = new VBox(gameTXT,hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(173);

        //creating register button
        FileInputStream inputRegister = new FileInputStream(".//icons//shotOrange.png");
        Image iconRegister = new Image(inputRegister);
        ImageView imageViewRegister = new ImageView(iconRegister);
        Button registerBTN = new Button("   REGISTER   ",imageViewRegister);

        //creating info button
        FileInputStream inputInfo = new FileInputStream(".//icons//info.png");
        Image iconInfo = new Image(inputInfo);
        ImageView imageViewInfo = new ImageView(iconInfo);
        Button infoBTN = new Button("     INFO     ",imageViewInfo);

        //creating setting button
        FileInputStream inputSetting = new FileInputStream(".//icons//setting.png");
        Image iconSetting = new Image(inputSetting);
        ImageView imageViewSetting = new ImageView(iconSetting);
        Button settingBTN = new Button("  SETTING  ",imageViewSetting);


        //set info and setting button in VBox
        VBox vBoxTopRight = new VBox(infoBTN,settingBTN);
        vBoxTopRight.setAlignment(Pos.BASELINE_RIGHT);
        vBoxTopRight.setSpacing(5);


        //creating a borderpane object
        BorderPane borderPane = new BorderPane();
        //Arranging all the nodes in the borderpane
        borderPane.setCenter(vBox);
        borderPane.setRight(vBoxTopRight);
        borderPane.setLeft(registerBTN);
        //setting the padding
         borderPane.setPadding(new Insets(5,5,5,5));
       //Creating a scene object 
        Scene scene = new Scene(borderPane);
        //Adding scene to the stage 
        primaryStage.setScene(scene);
        //setting stage's min size
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(700);
        //Setting title to the Stage 
        primaryStage.setTitle("Tank Trouble"); 
        //Displaying the contents of the stage 
        primaryStage.show();

    }
}