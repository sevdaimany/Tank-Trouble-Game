import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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

            if(loginView.getUsername().getText().equals("") || loginView.getPassword().getText().equals("")){
                loginView.getErrorLable().setText("  Please fill out fields.  ");
                return;
            }
            boolean isRegistered = false;
            try {
           isRegistered = DataBase.isPasswordCorrect(loginView.getUsername().getText() ,loginView.getPassword().getText());
            }catch (IOException e){e.printStackTrace();}

            if(isRegistered) {
                stage.setScene(new Scene(this.getTankControllerChooser()));
                stage.setTitle("Choose");
            }
            else{
                loginView.getErrorLable().setText("  Please login first.  ");
            }
        });

    }



    
     /**
     * This method set start button's action listener
     */
    public void startGameAction(){

        GameView gameView = new GameView();

        tankControllerChooser.getButton().setOnAction(event -> {

            boolean selectRadioButton1 = tankControllerChooser.getRadioButton1().isSelected();
            boolean selectRadioButton2 = tankControllerChooser.getRadioButton2().isSelected();
            boolean selectRadioButton3 = tankControllerChooser.getRadioButton3().isSelected();
            String tankColor = tankControllerChooser.getChoiceBox().getValue();

            if(!selectRadioButton1 && !selectRadioButton2 && !selectRadioButton3 &&  tankColor == null){
                tankControllerChooser.getErrorLable().setText("  Please choose first.  ");
                return;
            }


            Scene scene = new Scene(gameView);
            stage.setScene(scene);
            GameLoop game = new GameLoop();
            game.init(gameView);
            stage.setTitle("Tank Trouble");


            Player player = null;
            try {
                player = DataBase.getPlayer(loginView.getUsername().getText());
            }catch (IOException e){e.printStackTrace();}


            int[] tankXandY = GameState.randomXandY();
            int x = tankXandY[0];
            int y = tankXandY[1];
            Tank tank = new Tank(x,y,DataBase.getTankImage(tankColor));
            player.setPlayerTank(tank);


            PlayingController playingController = null;

            if(selectRadioButton1){
                playingController = new PlayingController(tank, KeyCode.W, KeyCode.S, KeyCode.D, KeyCode.A,KeyCode.Q);
            } else if (selectRadioButton2) {
                playingController = new PlayingController(tank, KeyCode.UP, KeyCode.DOWN, KeyCode.RIGHT, KeyCode.LEFT,KeyCode.M);

            }

            GameState.getTanks().add(tank);
            GameState.getPlayers().add(player);
            GameState.getPlayingControllers().add(playingController);

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