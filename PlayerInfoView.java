import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * This class represent a player's info vbox during the game
 *  it holds player's username , tank's image and tank's health
 * 
 * 
 * @author Sevda Imany
 * 
 * @version 0.0.0
 */
public class PlayerInfoView extends VBox {

    // tank's health progressBar
    private ProgressBar pbHealth;

    
    public PlayerInfoView(Player player) {

        ImageView imageView = new ImageView(player.getPlayerTank().getImage());
        pbHealth = new ProgressBar(1);
        Label username = new Label(player.getUsername());
        Label healthLabel = new Label("Health: ");

        username.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
        healthLabel.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12));

        HBox healthHB = new HBox(healthLabel, pbHealth);
        healthHB.setSpacing(5);
        healthHB.setAlignment(Pos.CENTER);
        this.getChildren().addAll(username, imageView, healthHB, new Label("        "));
        this.setAlignment(Pos.CENTER);
        healthLabel.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(5);
        this.setPadding(new Insets(0, 30, 0, 30));

        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    /* Methods */

    /***
     * @return tank's health progressBar
     */
    public ProgressBar getPbHealth() {
        return pbHealth;
    }
}
