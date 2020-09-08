
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


    /**
     * this method check which player won the game
     * @return winnerPlayer
     */
    private Player winner(){
        int winnerPoint = -1;
        for(Tank tank : GameState.getTanks()){
            if(tank.getHealth() > winnerPoint){
                winnerPoint = tank.getHealth();
            }

        }
        for(Player player : GameState.getPlayers()){
            if(player.getPlayerTank().getHealth() == winnerPoint){
                return  player;
            }
        }
        return  null;
    }

}





