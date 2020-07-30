import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

/**
 * this class represent a game page's view
 * 
 * @author Sevda Imany
 * @version 0.0.0 
 */
public class GameView extends BorderPane {

            /*  Fields  */

    //game's playground object
    private GamePlayGround gamePlayGround;


         /* Constructor */

    /**
     * create new game page's view
     */
    public GameView(){
        gamePlayGround = new GamePlayGround();
        this.setCenter(Main.getRootPlayGround());
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);

    }
}
