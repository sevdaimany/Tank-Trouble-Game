import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;






/**
 * this class represent  menu page's controller
 * 
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class MenuController 
{

            /*  Fields  */

    // menu page's view
    private MenuView menuview;

    // game 's stage'
    private Stage stage;









         /* Constructor */

    /**
     * create menu controller
     */
    public MenuController()
    {
        try
        {
            menuview = new MenuView();
        }
        catch (Exception e){}
        
        this.stage = Main.getStage();

        settingBTNActon();
        registerBTNAction();
        twoPlayerAction();
        infoAction();
        soundAction();
        leaderboardAction();



    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return menu page's view
     */
    public MenuView getMenuview() { return menuview; }



    /**
     * set setting button's action
     */
    public void settingBTNActon(){
        SettingController settingController = new SettingController();
        menuview.getSettingBTN().setOnAction(event -> {
            Scene scene = new Scene(settingController.getSettingView());
            stage.setScene(scene);
            stage.setTitle("Setting");
        });
    }



    /**
     * This method add register button's action listener
     */
    public void registerBTNAction()
    {
        RegisterController registerController = new RegisterController();

        menuview.getRegisterBTN().setOnAction(event -> 
        {
            stage.setScene(new Scene(registerController.getRegisterView()));
            stage.setTitle("Register");
        });
    }  
    
    
    /**
     * this method add 1player button's actionlistener
     */
    public void twoPlayerAction(){
        menuview.getButton2().setOnAction(event -> {
            GameState.newFields();
            LoginView.firstCall();
            LoginGameController loginGameController = new LoginGameController();
            loginGameController.getTankControllerChooser().getButton().setText("Next Player");
            stage.setScene(new Scene(loginGameController.getLoginView()));
            stage.setTitle("login");
        });
    }


    /**
     * this method add info button's actionListener
     */
    public void infoAction(){
        menuview.getInfoBTN().setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("TankTrouble is a fun-filled game in which you battle tanks with bouncing bullets and other cool weapons in 2-dimensional mazes!\nTank Trouble started as our university project in 2020.\nContributions, issues and feature requests are welcome!\nEmails:\nm.mahdi.m79@gmail.com\nimanysevda@gmail.com.\n\n\n");
            alert.showAndWait();
        });
    }

    /**
     * this method add sound's checkbox actionlistener 
     */
    public void soundAction(){
        menuview.getSound().setOnAction(event -> {
            if(menuview.getSound().isSelected()){
                AudioPlayer.unMute();
            }
            else {
                AudioPlayer.mute();
            }
        });
    }

    
    /**
     * this method add leaderboards button actionlistener 
     */
    public void leaderboardAction(){
        menuview.getButton5().setOnAction(event -> {
            LeaderBoardsController leaderBoardsController = new LeaderBoardsController();
            stage.setScene(new Scene(leaderBoardsController.getLeaderBoardsView()));
            stage.setTitle("LeaderBoard");

        });
    }
    

}
