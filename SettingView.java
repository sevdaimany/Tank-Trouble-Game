
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