import javafx.stage.Stage;

/**
 * this class represent userSetting page's controller
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class UserSettingController {

            /*  Fields  */

    private  UserSettingView userSettingView;
    private Stage stage;


         /* Constructor */

    public UserSettingController() {
        userSettingView = new UserSettingView();
        this.stage =Main.getStage();
    }


          /*  Methods  */


    // * getter methods *

    /**
     * @return userSetting's view
     */
    public UserSettingView getUserSettingView() {
        return userSettingView;
    }
}
