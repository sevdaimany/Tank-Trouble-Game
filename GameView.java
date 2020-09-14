import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

     // award label
     private  static Label awardLable;









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

         //background picture
         FileInputStream input = null;
         try {
              input = new FileInputStream(DataBase.getBackground2Icon());
         }catch (Exception e){e.printStackTrace();}
         Image image = new Image(input);
         BackgroundImage backgroundimage = new BackgroundImage(image,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundPosition.DEFAULT,
                 BackgroundSize.DEFAULT);
 
         this.setBackground(new Background(backgroundimage));
     
    
    }



             /*  Methods  */


    /**
     * this method add player's information hbox at the bottom of gameView
     */
    public void addPlayersInfo(){

        hBoxInfo = new HBox();

        awardLable = new Label();
        awardLable.setTextFill(Color.RED);
        awardLable.setFont(Font.font(15));

        VBox vBox = new VBox(awardLable , hBoxInfo);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);



        for (Player player : GameState.getPlayers()){
            PlayerInfoView playerInfoView = new PlayerInfoView(player);
            hBoxInfo.getChildren().add(playerInfoView);
            GameState.getTankProgressBar().put(player.getPlayerTank(),playerInfoView.getPbHealth());

        }

        hBoxInfo.setAlignment(Pos.CENTER);
        hBoxInfo.setSpacing(60);
        this.setBottom(vBox);


    }

        // * getter methods *


    /**
     * @return game's Playground
     */    
    public GamePlayGround getGamePlayGround() {
        return gamePlayGround;
    }

    /**
     * @return award Label
     */
    public static Label getAwardLable() {
        return awardLable;
    }

    
}
