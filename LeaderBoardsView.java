import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LeaderBoardsView extends BorderPane {

    public LeaderBoardsView(){

        VBox username = new VBox();

        try {
            Player[] players = DataBase.getLeaderBoards();
            for (int i =0 ; i < players.length ; i++) {
                Label playerInfo = new Label(players[i].getUsername() + " :            "  );
                playerInfo.setAlignment(Pos.BASELINE_LEFT);
                playerInfo.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                username.getChildren().add(new Label("  "));
                username.getChildren().add(playerInfo);

              

             
            }
        }catch (Exception  e ){e.printStackTrace();}




    }
}