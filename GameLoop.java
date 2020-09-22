
import java.util.Random;

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

    private long time;


    
    public void init(GameView gameView) {
        this.gameView = gameView;
        GameState.init();
        run();

    }


    public void run() {

        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if(System.currentTimeMillis() - time > 10000){
                    time = System.currentTimeMillis();
                    Random random = new Random();
                    int rnd = random.nextInt(3);
                    if(rnd == 0){
                        HealthAward healthAward = new HealthAward();
                        GameState.getAwards().add(healthAward);

                    }
                    else if(rnd == 1){
                        ProtecterAward protecterAward = new ProtecterAward();
                        GameState.getAwards().add(protecterAward);
                    }
                    else if(rnd == 2){
                        DamageAward damageAward = new DamageAward();
                        GameState.getAwards().add(damageAward);
                    }
                }
               
                for(DamageAward damageAward : GameState.getPoweredAmmoAward()){
                    if(System.currentTimeMillis() - damageAward.getCreateTimeApply() > damageAward.getLifeTimeApply() *1000){
                        damageAward.removeAward();
                        GameState.getPoweredAmmoAward().remove(damageAward);
                    }
                }
 
                for(ProtecterAward protecterAward : GameState.getProtectedAward()){
                    if(System.currentTimeMillis() - protecterAward.getCreateTimeApply() > protecterAward.getLifeTimeApply() *1000){
                        protecterAward.removeAward();
                        GameState.getProtectedAward().remove(protecterAward);
                    }
 
                    }
                
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





