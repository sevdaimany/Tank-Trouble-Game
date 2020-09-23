import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * this class represent the Leaderboards view of the game
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class LeaderBoardsView extends BorderPane {

    public LeaderBoardsView(){

        VBox username = new VBox();

        VBox numbers = new VBox();

        VBox scores = new VBox();



        try {
            Player[] players = DataBase.getLeaderBoards();
            for (int i =0 ; i < players.length ; i++) {
                Label playerInfo = new Label(players[i].getUsername() + " :            "  );
                playerInfo.setAlignment(Pos.BASELINE_LEFT);
                playerInfo.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                username.getChildren().add(new Label("  "));
                username.getChildren().add(playerInfo);

                Label number = new Label((i+1) + ")           " );
                number.setAlignment(Pos.BASELINE_LEFT);
                number.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                numbers.getChildren().addAll(new Label("  ") , number );


                Label score = new Label( players[i].getScore() +" wins            ");
                score.setAlignment(Pos.BASELINE_LEFT);
                score.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                scores.getChildren().addAll(new Label("  ") , score );



              

             
            }
        }catch (Exception  e ){e.printStackTrace();}




    }
}