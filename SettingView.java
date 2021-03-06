
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import java.io.FileInputStream;





/**
 * This class represent setting page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class SettingView extends TabPane 
{
            /*  Fields  */

    // loginController object
    private LoginController loginController;

    // GameSettingController object
    private GameSettingController gameSettingController;







         /* Constructor */

    /**
     * Create setting view page
     */
    public SettingView() 
    {

        //create user tab
        Tab userSettingTab = new Tab("User");
        userSettingTab.setContent(register());
        userSettingTab.setClosable(false);


        //create game tab
        Tab gameSettingTab = new Tab("Game");
        gameSettingTab.setContent(gameSetting());
        gameSettingTab.setClosable(false);


        //add tabs to tabpane
        this.getTabs().add(userSettingTab);
        this.getTabs().add(gameSettingTab);


        //background
        FileInputStream input = null;

        try { input = new FileInputStream(DataBase.getBackgroundIconPath()); }
        catch (Exception e){}

        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        this.setBackground(new Background(backgroundimage));

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);
    }








            /*  Methods  */

    /**
     * @return loginView 
     */
    public BorderPane register()
    {
        loginController = new LoginController();
        return loginController.getLoginView();
    }


    /**
     * @return gameSetting view
     */
    public BorderPane gameSetting()
    {
        gameSettingController =new GameSettingController();
        return gameSettingController.getGameSettingView();
    }
}