
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;





/**
 * Main class represent  tank trouble game
 *
 * @author Sevda Imany
 * @version 0.0.2
 */
public class Main extends Application 
{

    public static void main(String[] args) 
    {

        launch(args);
    }





            /*  Methods  */

     /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        StageConnection stageConnection = new StageConnection(primaryStage);
        
        MenuController menuController = new MenuController();


        //Creating a scene object
        Scene scene = new Scene(menuController.getMenuview());

        //Adding scene to the stage
        primaryStage.setScene(scene);

        //setting stage's min size
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(1480);

        //Setting title to the Stage
        primaryStage.setTitle("Tank Trouble");

        //Displaying the contents of the stage
        primaryStage.show();
    }
}