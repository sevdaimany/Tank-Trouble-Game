import javafx.scene.Scene;
import javafx.stage.Stage;





/**
 * This class represent game login page's controller
 *
 *
 * @author Sevda Imany
 * @version 0.0.5
 */
public class LoginGameController
{

    /*  Fields  */

    private Stage stage;
    private LoginView loginView ;
    private LoginView.TankControllerChooser tankControllerChooser;







    /* Constructor */

    public  LoginGameController()
    {
        this.stage =Main.getStage();
        loginView = new LoginView();
        tankControllerChooser = loginView.new TankControllerChooser();
        loginAction();
        startGameAction();
        menuAction();
    }

    /*  Methods  */



    /**
     * this method add login button's actionlistener
     */
    public void loginAction(){
        loginView.getLoginBTN().setOnAction(event -> {
            stage.setScene(new Scene(this.getTankControllerChooser()));
            stage.setTitle("Choose");
        });

    }



    public void startGameAction(){
        GameView gameView = new GameView();

        tankControllerChooser.getButton().setOnAction(event -> {
            Scene scene = new Scene(gameView);
            stage.setScene(scene);
            GameLoop game = new GameLoop();
            game.init(gameView);
            stage.setTitle("Tank Trouble");
            gameView.addPlayersInfo();

        });
    }

     /**
     * This method set menu button's action listener
     */
    public void menuAction()
    {
        loginView.getMenu().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });

        tankControllerChooser.getMenu().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });


    }




    // * getter methods *

    /**
     * @return login's view
     */
    public LoginView getLoginView() { return loginView; }


    /**
     * @return tankControllerChooser page's view
     */
    public LoginView.TankControllerChooser getTankControllerChooser() {
        return tankControllerChooser;
    }
}