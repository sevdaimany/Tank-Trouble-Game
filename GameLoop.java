
import javafx.animation.AnimationTimer;

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
            }
        };
        timer.start();
    }
}





