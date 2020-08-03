import javafx.stage.Stage;





/**
 * This class represent a setting page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class SettingController 
{
            /*  Fields  */

    // settingView object
    private SettingView settingView;
    private Stage stage;







         /* Constructor */

    /**
     * Create setting controller
     */
    public SettingController()
    {
        settingView = new SettingView();
        this.stage =Main.getStage();
    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return  Setting's view
     */
    public SettingView getSettingView() { return settingView; }
}
