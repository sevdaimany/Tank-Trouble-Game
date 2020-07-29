
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import java.io.FileInputStream;
/**
 * this class represent setting page's view
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class SettingView extends TabPane {

            /*  Fields  */

    //loginController object
    private LoginController loginController;

    //GameSettingController object
    private GameSettingController gameSettingController;


         /* Constructor */

    /**
     * create setting view page
     */
    public SettingView() {

        //create user tab
        Tab userSettingTab = new Tab("User");
        userSettingTab.setContent(register());

        //create game tab
        Tab gameSettingTab = new Tab("Game");
        gameSettingTab.setContent(gameSetting());

        //add tabs to tabpane
        this.getTabs().add(userSettingTab);
        this.getTabs().add(gameSettingTab);


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

        this.setBackground(new Background(backgroundimage));

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);


    }


          /*  Methods  */

    /**
     * @return loginView 
     */
    public BorderPane register(){
        loginController = new LoginController();
        return loginController.getLoginView();
    }

    /**
     * @return gameSetting view
     */
    public BorderPane gameSetting(){
        gameSettingController =new GameSettingController();
        return gameSettingController.getGameSettingView();
    }

}