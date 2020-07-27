
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private Menuview menuview;
    private Stage stage;

    public MenuController(Stage stage){
        try {
            menuview = new Menuview();
        }catch (Exception e){}

        registerBTNAction();

        this.stage = stage;
    }

    public void registerBTNAction(){
        RegisterController registerController = new RegisterController();
        menuview.getRegisterBTN().setOnAction(event -> {
            stage.setScene(new Scene(registerController.getRegisterView()));
            stage.setTitle("Register");
        });
    }

    public Menuview getMenuview() {
        return menuview;
    }
}
