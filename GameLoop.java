
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

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



    /**
     * @return scores Vbox
     */
    private VBox scores(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Label gameOverLabel = new Label("GAME OVER");
        gameOverLabel.setAlignment(Pos.CENTER);
        gameOverLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        gameOverLabel.setTextFill(Color.DARKORANGE);



        Label winnerLable = new Label("WINNER : " +winner().getUsername());
        winnerLable.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40));


        Label scoreLabel = new Label("SCORES");
        scoreLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40));

        vBox.getChildren().add(gameOverLabel);
        vBox.getChildren().add(new Label("          "));
        vBox.getChildren().add(winnerLable);
        vBox.getChildren().add(new Label("          "));
        vBox.getChildren().add(scoreLabel);


        for (Player player : GameState.getPlayers()){

            Label username = new Label(player.getUsername()+" : ");
            username.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));

            Label score = new Label(String.valueOf(player.getPlayerTank().getHealth()));
            score.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));

            HBox hBox = new HBox(username , score);
            hBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hBox);
            vBox.setOpacity(1);


        }
        return vBox;
    }

}





