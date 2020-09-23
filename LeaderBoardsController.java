import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class represent a leaderBoards controller 
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class LeaderBoardsController {

    private LeaderBoardsView leaderBoardsView ;
    private Stage stage;


    public LeaderBoardsController(){

        leaderBoardsView = new LeaderBoardsView();
        stage = Main.getStage();
    }


    public LeaderBoardsView getLeaderBoardsView() {
        return leaderBoardsView;
    }

   
}
