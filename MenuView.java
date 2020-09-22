
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;











/**
 * This class represent menu's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class MenuView extends BorderPane 
{

            /*  Fields  */

    
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

    //sound's checkbox
    private CheckBox sound;


    







         /* Constructor */

    /**
     * create  menu's view
     * 
     * 
     * @throws Exception
     */      
    public MenuView() throws  Exception
    {
       

        // create 2 players button
        FileInputStream input2 = new FileInputStream(DataBase.getTwoPLAyersIconPath());
        Image icon2 = new Image(input2);
        ImageView imageView2 = new ImageView(icon2);
        button2 = new Button("   2 PLAYERS  ", imageView2);


        // create 3 players button
        FileInputStream input3 = new FileInputStream(DataBase.getThreePlayersIconPath());
        Image icon3 = new Image(input3);
        ImageView imageView3 = new ImageView(icon3);
        button3 = new Button("   3 PLAYERS  ", imageView3);


        // create server button
        FileInputStream input4 = new FileInputStream(DataBase.getServerModeIconPath());
        Image icon4 = new Image(input4);
        ImageView imageView4 = new ImageView(icon4);
        button4 = new Button("    SERVER    ", imageView4);


        // create leaboard button
        FileInputStream input5 = new FileInputStream(DataBase.getLeaderboardsIconPath());
        Image icon5 = new Image(input5);
        ImageView imageView5 = new ImageView(icon5);
        button5 = new Button("   LEABOARDS  ", imageView5);


        // set buttons to  hbox
        HBox hBox = new HBox(button2, button3, button4, button5);
        //Setting the hbox alignment
        hBox.setAlignment(Pos.CENTER);
        //setting the spacing
        hBox.setSpacing(10);


        //creating 'tank trouble' text
        // Text gameTXT = new Text("TANK TROUBLE");
        // gameTXT.setFill(Color.ORANGE);
        // gameTXT.setStroke(Color.BLACK);
        // gameTXT.setStrokeWidth(4);
        // gameTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));


        // FadeTransition textTransition = new FadeTransition(Duration.seconds(0.3), gameTXT);
        // textTransition.setAutoReverse(true);
        // textTransition.setFromValue(0);
        // textTransition.setToValue(1);
        // textTransition.setCycleCount(Transition.INDEFINITE);
        // textTransition.play();


        FileInputStream inputLogo = new FileInputStream(DataBase.getLogoImage());
        Image imageLogo = new Image(inputLogo);
        ImageView imageViewLogo = new ImageView(imageLogo);
        imageViewLogo.setBlendMode(BlendMode.DARKEN);

        // set hBox and gameTXT to VBox
        VBox vBox = new VBox(imageViewLogo, hBox);
        vBox.setAlignment(Pos.CENTER);
        // vBox.setSpacing(173);


        //creating register button
        FileInputStream inputRegister = new FileInputStream(DataBase.getRegisterIconPath());
        Image iconRegister = new Image(inputRegister);
        ImageView imageViewRegister = new ImageView(iconRegister);
        registerBTN = new Button("   REGISTER   ", imageViewRegister);

        VBox vboxRegister = new VBox(registerBTN);
        vboxRegister.setAlignment(Pos.BASELINE_RIGHT);
        vboxRegister.setSpacing(5);



        //creating info button
        FileInputStream inputInfo = new FileInputStream(DataBase.getInfoIconPath());
        Image iconInfo = new Image(inputInfo);
        ImageView imageViewInfo = new ImageView(iconInfo);
        infoBTN = new Button("     INFO     ", imageViewInfo);


        //creating setting button
        FileInputStream inputSetting = new FileInputStream(DataBase.getSettingIconPath());
        Image iconSetting = new Image(inputSetting);
        ImageView imageViewSetting = new ImageView(iconSetting);
        settingBTN = new Button("  SETTING  ", imageViewSetting);



        //creating sound checkbox
        sound = new CheckBox("SoundOn");
        sound.setSelected(true);
        sound.setAlignment(Pos.CENTER);

        //set info and setting button in VBox
        VBox vBoxTopRight = new VBox(infoBTN, settingBTN ,new Label("  "), sound);
        vBoxTopRight.setAlignment(Pos.BASELINE_CENTER);
        vBoxTopRight.setSpacing(5);


        //background picture
        FileInputStream input = new FileInputStream(DataBase.getBackgroundIconPath());
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));


        //Arranging all the nodes in the border pane
        this.setCenter(vBox);
        this.setRight(vBoxTopRight);
        this.setLeft(vboxRegister);

        //setting the padding
        this.setPadding(new Insets(5, 5, 5, 5));

        //setting background
        this.setBackground(new Background(backgroundimage));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);

    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return 2player's button
     */
    public Button getButton2() { return button2; }
    /**
     * @return 3player's button
     */
    public Button getButton3() { return button3; }
    /**
     * @return server's button
     */
    public Button getButton4() { return button4; }
    /**
     * @return leaderboard's button
     */
    public Button getButton5() { return button5; }
    /**
     * @return info's button
     */
    public Button getInfoBTN() { return infoBTN; }
    /**
     * @return register's button
     */
    public Button getRegisterBTN() { return registerBTN; }
    /**
     * @return setting's button
     */
    public Button getSettingBTN() { return settingBTN; }

    /**
     * @return sound's checkbox
     */
    public CheckBox getSound() {  return sound; }
}
