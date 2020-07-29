import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * this class represent gameSetting page's view
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class GameSettingView extends BorderPane {

            /*  Fields  */


    private TextField tankesHealthTextField;
    private TextField bulletPowerTextField;
    private TextField wallHealthTextField;


         /* Constructor */

    public GameSettingView() {


        //tank's health lable
        Label tankesHealth = new Label("The number of tank's health  :  ");
        tankesHealth.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        tankesHealth.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        tankesHealthTextField = new TextField();
        HBox tank = new HBox(tankesHealth,tankesHealthTextField);
        tank.setSpacing(5);


        //bullet's power lable
        Label bulletPower = new Label("The number of bullet's power : ");
        bulletPower.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        bulletPower.setFont(Font.font("normal" ,FontWeight.BOLD ,FontPosture.REGULAR, 15));
        bulletPowerTextField = new TextField();
        HBox bullet = new HBox(bulletPower,bulletPowerTextField);
        bullet.setSpacing(5);

        
        //wall's health lable
        Label wallHealth = new Label("The number of wall's health  :  ");
        wallHealth.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        wallHealth.setFont(Font.font("normal" ,FontWeight.BOLD ,FontPosture.REGULAR, 15));
        wallHealthTextField = new TextField();
        HBox wall = new HBox(wallHealth,wallHealthTextField);
        wall.setSpacing(5);


        //game setting text
        Text gameSettingTXT = new Text("Game Setting");
        gameSettingTXT.setFill(Color.ORANGE);
        gameSettingTXT.setStroke(Color.BLACK);
        gameSettingTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        gameSettingTXT.setStrokeWidth(2);

    }
}
