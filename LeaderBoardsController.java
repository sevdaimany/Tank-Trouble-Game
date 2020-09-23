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
        menuAction();

    }


      /**
     * This method set menu button's action listener
     */
    public void menuAction()
    {
        leaderBoardsView.getMenu().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });
    }


    public LeaderBoardsView getLeaderBoardsView() {
        return leaderBoardsView;
    }

   
}
