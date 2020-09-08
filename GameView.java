import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;




/**
 * This class represent a game page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5 
 */
public class GameView extends BorderPane {

            /*  Fields  */

    //game's playground object
    private GamePlayGround gamePlayGround;

    //player's information hbox
    private  HBox hBoxInfo;








         /* Constructor */

    /**
     * create new game page's view
     */
    public GameView()
    {
        gamePlayGround = new GamePlayGround();

        this.setCenter(Main.getRootPlayGround());

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK , CornerRadii.EMPTY, Insets.EMPTY)));

    
    }



             /*  Methods  */


    /**
     * this method add player's information hbox at the bottom of gameView
     */
    public void addPlayersInfo(){

        hBoxInfo = new HBox();

        for (Player player : GameState.getPlayers()){
            PlayerInfoView playerInfoView = new PlayerInfoView(player);
            hBoxInfo.getChildren().add(playerInfoView);
        }

        hBoxInfo.setAlignment(Pos.CENTER);
        hBoxInfo.setSpacing(60);
        this.setBottom(hBoxInfo);


    }

        // * getter methods *


    /**
     * @return game's Playground
     */    
    public GamePlayGround getGamePlayGround() {
        return gamePlayGround;
    }


    
}
