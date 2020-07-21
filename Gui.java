import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.*;






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

    }
}