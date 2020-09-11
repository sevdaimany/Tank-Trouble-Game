
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

/**
 * This class represent the main game loop
 * 
 * 
 * @author Sevda Imany
 * 
 * @version 0.0.0
 */
public class GameLoop 
{

    private GameView gameView;

    
    public void init(GameView gameView) {
        this.gameView = gameView;
        GameState.init();
        run();

    }


    public void run() {

        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                GameState.updateStates();
                gameView.getGamePlayGround().render();
                
                if (GameState.gameOver()) {
                    GameOverController gameOverController = new GameOverController();
                    Scene scene = new Scene(gameOverController.getGameOverView());
                    Main.getStage().setScene(scene);
                    stop();
                }
            }
        };
        timer.start();
    }

}





