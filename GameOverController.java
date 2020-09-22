import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class represent  gameOver page's controller
 *
 *
 *
 * @author Sevda Imany
 * @version 0.0.0
 */
public class GameOverController {

    //gameOver view
    private  GameOverView gameOverView;

    // game 's stage'
    private Stage stage;


    /**
     * create gameOver controller
     */
    public GameOverController() {
        this.gameOverView = new GameOverView();
        this.stage = Main.getStage();
        menuAction();
        playAgainAction();

    }


    /**
     * this method add menu button's action listener
     */
    public void menuAction(){
        gameOverView.getMenuBTN().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });

    }

    /**
     * this method add play again button's action listener
     */
    public void playAgainAction(){
        
        gameOverView.getPlayAgainBTN().setOnAction(event -> {

            GameView gameView = new GameView();
            Scene scene = new Scene(gameView);
            stage.setScene(scene);
            GameLoop game = new GameLoop();
            game.init(gameView);
            gameView.addPlayersInfo();
            stage.setTitle("Tank Trouble");

            for(Tank tank :GameState.getTanks()){
                tank.healthDelta(DataBase.getSettings().tanksHealth - tank.getHealth());
                tank.addToGameRoot();
                int[] tankXandY = GameState.randomXandY();
                int x = tankXandY[0];
                int y = tankXandY[1];
                int teta = tankXandY[2];
                tank.setX(x);
                tank.setY(y);
                tank.setTeta(teta);
                tank.draw();
            }

        });
    }


    /**
     * @return gameover view
     */
    public GameOverView getGameOverView() {
        return gameOverView;
    }
}
