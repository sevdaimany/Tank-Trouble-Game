import javafx.scene.Scene;
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
        saveAction();
    }









            /*  Methods  */


    /**
     * this method set save button's actionListener
     */
     public void saveAction(){
        gameSettingView.getSaveButton().setOnAction(event -> {
            DataBase.getSettings().tanksHealth = (int)gameSettingView.getTankesHealthSlider().getValue();
            DataBase.getSettings().ammoDamage = (int) gameSettingView.getBulletPowerSlider().getValue();
            DataBase.getSettings().ammosLifeTime = (int) gameSettingView.getAmmosLifeTimeSlider().getValue();
            DataBase.getSettings().woodWallsHealth = (int) gameSettingView.getWallHealthSlider().getValue();
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trouble");
        });
    }

    // * getter methods *

    /**
     * @return gameSetting's view
     */
    public GameSettingView getGameSettingView() { return gameSettingView; }
}
