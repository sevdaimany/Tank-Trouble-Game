
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private Menuview menuview;
    private Stage stage;

    public MenuController(Stage stage){
        try {
            menuview = new Menuview();
        }catch (Exception e){}
        this.stage = stage;
    }

   

    public Menuview getMenuview() {
        return menuview;
    }
}
