import javafx.stage.Stage;

/**
 * this class gameSetting page's controller
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class GameSettingController {

            /*  Fields  */

    private GameSettingView gameSettingView;
    private Stage stage;


         /* Constructor */


    public GameSettingController() {
        this.stage =StageConnection.getStage();
        gameSettingView =new GameSettingView();
    }


    /*  Methods  */


    // * getter methods *

    /**
     * @return gameSetting's view
     */
    public GameSettingView getGameSettingView() {
        return gameSettingView;
    }
}
