
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;





/**
 * Main class represent  tank trouble game
 *
 * @author Sevda Imany
 * @version 0.0.2
 */
public class Main extends Application 
{

    private static Stage stage;

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
        stage = primaryStage;
        
        MenuController menuController = new MenuController();


        //Creating a scene object
        Scene scene = new Scene(menuController.getMenuview());

        //Adding scene to the stage
        primaryStage.setScene(scene);

        //setting stage's min size
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            primaryStage.setMinHeight(screenBounds.getHeight()-60);
            primaryStage.setMinWidth(screenBounds.getWidth());

        //Setting title to the Stage
        primaryStage.setTitle("Tank Trouble");

        //Displaying the contents of the stage
        primaryStage.show();
    }
}