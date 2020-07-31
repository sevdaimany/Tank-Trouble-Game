import javafx.stage.Stage;




/**
 * This class gameSetting page's controller
 * 
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class GameSettingController {

            /*  Fields  */

    private GameSettingView gameSettingView;
    private Stage stage;







         /* Constructor */


    public GameSettingController() 
    {
        this.stage =Main.getStage();
        gameSettingView =new GameSettingView();
    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return gameSetting's view
     */
    public GameSettingView getGameSettingView() { return gameSettingView; }
}
