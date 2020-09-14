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
            boolean isPasswordCorrect = false;
            try {
                isRegistered = DataBase.isRegistered(loginView.getUsername().getText());
                if(isRegistered) {
                    isPasswordCorrect = DataBase.isPasswordCorrect(loginView.getUsername().getText(), loginView.getPassword().getText());
                }
                else {
                    loginView.getErrorLable().setText("  Please login first.  ");
                    return;
                }
            }catch (IOException e){e.printStackTrace();}


            for(Player player : GameState.getPlayers()){
                if(player.getUsername().equals(loginView.getUsername().getText())){
                    loginView.getErrorLable().setText("  " + player.getUsername() + " has been login the game.  ");
                    return;
                }
            }
            if(isPasswordCorrect) {
                stage.setScene(new Scene(this.getTankControllerChooser()));
                stage.setTitle("Choose");
            }
            else{
                loginView.getErrorLable().setText("  Password is not correct.  ");
            }
        });

    }



    
     /**
     * This method set start button's action listener
     */
    public void startGameAction(){


        tankControllerChooser.getButton().setOnAction(event -> {
            if(GameState.getPlayers().size() < 2) {

                boolean selectRadioButton1 = LoginView.getRadioButton1().isSelected();
                boolean selectRadioButton2 = LoginView.getRadioButton2().isSelected();
                boolean selectRadioButton3 = LoginView.getRadioButton3().isSelected();
                String tankColor = LoginView.getChoiceBox().getValue();

                if ((!selectRadioButton1 && !selectRadioButton2 && !selectRadioButton3 ) || tankColor == null) {
                    tankControllerChooser.getErrorLable().setText("  Please choose first.  ");
                    return;
                }



                Player player = null;
                try {
                    player = DataBase.getPlayer(loginView.getUsername().getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Tank tank = new Tank(0, 0, DataBase.getTankImage(tankColor));
                player.setPlayerTank(tank);
                LoginView.getChoiceBox().getItems().remove(tankColor);
                LoginView.getChoiceBox().setValue(null);



                PlayingController playingController = null;

                if (selectRadioButton1) {
                    playingController = new PlayingController(tank, KeyCode.W, KeyCode.S, KeyCode.D, KeyCode.A, KeyCode.Q);
                    LoginView.getRadioButton1().setSelected(false);
                    LoginView.getRadioButton1().setDisable(true);
                } 
                else if (selectRadioButton2) {
                    playingController = new PlayingController(tank, KeyCode.UP, KeyCode.DOWN, KeyCode.RIGHT, KeyCode.LEFT, KeyCode.M);
                    LoginView.getRadioButton2().setSelected(false);
                    LoginView.getRadioButton2().setDisable(true);
                }

                GameState.getTanks().add(tank);
                GameState.getPlayers().add(player);
                GameState.getPlayingControllers().add(playingController);



                if(GameState.getPlayers().size() == 2){

                    GameView gameView = new GameView();

                    Scene scene = new Scene(gameView);
                    stage.setScene(scene);
                    GameLoop game = new GameLoop();
                    game.init(gameView);
                    stage.setTitle("Tank Trouble");

                    for(Tank tank2 : GameState.getTanks()){
                        int[] tankXandY = GameState.randomXandY();
                        int x = tankXandY[0];
                        int y = tankXandY[1];
                        int teta = tankXandY[2];

                        tank2.setX(x);
                        tank2.setY(y);
                        tank.setTeta(teta);

                        tank2.draw();
                        tank2.addToGameRoot();

                    }

                    gameView.addPlayersInfo();


                }

                else {

                    LoginGameController loginGameController = new LoginGameController();
                    stage.setScene(new Scene(loginGameController.getLoginView()));
                    stage.setTitle("login");
                }


            }

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