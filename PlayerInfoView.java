import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PlayerInfoView extends VBox {

    private  ImageView imageView ;
    private ProgressBar pbHealth;
    private Label username;


    public PlayerInfoView(Player player){
        
    }

    public ProgressBar getPbHealth() {
        return pbHealth;
    }
}
