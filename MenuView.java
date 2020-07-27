import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.FileInputStream;

/**
 * this class represent menu's view
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class MenuView extends BorderPane {

    /* Fields */

    // 1player's button
    private Button button1;

    // 2player's button
    private Button button2;

    // 3player's button
    private Button button3;

    // server button
    private Button button4;

    // leaboard's button
    private Button button5;

    // info's button
    private Button infoBTN;

    // register's button
    private Button registerBTN;

    // setting's button
    private Button settingBTN;

    

    /* Constructor */

/**
* creat  menu's view
* 
* @throws Exception
*/      
public Menuview() throws  Exception{

FileInputStream input1 = new FileInputStream(".//icons//tank_blue.png");
Image icon1 = new Image(input1);
ImageView imageView1 = new ImageView(icon1);
button1 = new Button("   1 PLAYER   ", imageView1);


// create 2 players button
FileInputStream input2 = new FileInputStream(".//icons//tank_green.png");
Image icon2 = new Image(input2);
ImageView imageView2 = new ImageView(icon2);
 button2 = new Button("   2 PLAYERS  ", imageView2);

// create 3 players button
FileInputStream input3 = new FileInputStream(".//icons//tank_sand.png");
Image icon3 = new Image(input3);
ImageView imageView3 = new ImageView(icon3);
button3 = new Button("   3 PLAYERS  ", imageView3);

// create server button
FileInputStream input4 = new FileInputStream(".//icons//tank_red.png");
Image icon4 = new Image(input4);
ImageView imageView4 = new ImageView(icon4);
button4 = new Button("    SERVER    ", imageView4);

// create leaboard button
FileInputStream input5 = new FileInputStream(".//icons//star.png");
Image icon5 = new Image(input5);
ImageView imageView5 = new ImageView(icon5);
button5 = new Button("   LEABOARDS  ", imageView5);

// set buttons to  hbox
HBox hBox = new HBox(button1, button2, button3, button4, button5);
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
VBox vBox = new VBox(gameTXT, hBox);
vBox.setAlignment(Pos.CENTER);
vBox.setSpacing(173);

//creating register button
FileInputStream inputRegister = new FileInputStream(".//icons//shotOrange.png");
Image iconRegister = new Image(inputRegister);
ImageView imageViewRegister = new ImageView(iconRegister);
registerBTN = new Button("   REGISTER   ", imageViewRegister);

//creating info button
FileInputStream inputInfo = new FileInputStream(".//icons//info.png");
Image iconInfo = new Image(inputInfo);
ImageView imageViewInfo = new ImageView(iconInfo);
infoBTN = new Button("     INFO     ", imageViewInfo);

//creating setting button
FileInputStream inputSetting = new FileInputStream(".//icons//setting.png");
Image iconSetting = new Image(inputSetting);
ImageView imageViewSetting = new ImageView(iconSetting);
settingBTN = new Button("  SETTING  ", imageViewSetting);


//set info and setting button in VBox
VBox vBoxTopRight = new VBox(infoBTN, settingBTN);
vBoxTopRight.setAlignment(Pos.BASELINE_RIGHT);
vBoxTopRight.setSpacing(5);


//background picture
FileInputStream input = new FileInputStream(".//icons//pic.jpg");
Image image = new Image(input);
BackgroundImage backgroundimage = new BackgroundImage(image,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);


//Arranging all the nodes in the borderpane
this.setCenter(vBox);
this.setRight(vBoxTopRight);
this.setLeft(registerBTN);
//setting the padding
this.setPadding(new Insets(5, 5, 5, 5));
//setting background
this.setBackground(new Background(backgroundimage));
}

    /* Methods */

    // * getter methods *

    /**
     * @return 1player's button
     */
    public Button getButton1() {
        return button1;
    }

    /**
     * @return 2player's button
     */
    public Button getButton2() {
        return button2;
    }

    /**
     * @return 3player's button
     */
    public Button getButton3() {
        return button3;
    }

    /**
     * @return server's button
     */
    public Button getButton4() {
        return button4;
    }

    /**
     * @return leaboard's button
     */
    public Button getButton5() {
        return button5;
    }

    /**
     * @return info's button
     */
    public Button getInfoBTN() {
        return infoBTN;
    }

    /**
     * @return register's button
     */
    public Button getRegisterBTN() {
        return registerBTN;
    }

    /**
     * @return setting's button
     */
    public Button getSettingBTN() {
        return settingBTN;
    }

}
