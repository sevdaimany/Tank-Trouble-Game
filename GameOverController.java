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
     * @return gameover view
     */
    public GameOverView getGameOverView() {
        return gameOverView;
    }
}
