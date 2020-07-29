import javafx.stage.Stage;

/**
 * this class represent a setting page's view
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class SettingController {
            /*  Fields  */

    //settingView object
    private SettingView settingView;
    private Stage stage;



         /* Constructor */

    /**
     * create setting controller
     */
    public SettingController(){
        settingView = new SettingView();
        this.stage =StageConnection.getStage();
    }



       /*  Methods  */


    // * getter methods *

    /**
     * @return  Setting's view
     */
    public SettingView getSettingView() {
        return settingView;
    }
}
