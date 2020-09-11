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
    }

    /**
     * @return gameover view
     */
    public GameOverView getGameOverView() {
        return gameOverView;
    }
}
