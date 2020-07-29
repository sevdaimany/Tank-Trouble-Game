import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import java.io.FileInputStream;

/**
 * this class represent usersetting page's view
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */

public class UserSettingView extends BorderPane{

            /*  Fields  */

    
    private Label answerHourLable;
    private Label answerNameLable;
    private Label answerNumWinComputer;
    private Label answerNumFailureComputer;
    private Label answerNumWinServer;
    private Label answerNumFailureServer;
    private Button tankButton;


    public UserSettingView(){

        //create name lable
        Label nameLabel = new Label("username :");
        nameLabel.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerNameLable = new Label();
        HBox name = new HBox(nameLabel, answerNameLable);
        name.setAlignment(Pos.CENTER);
        

        //create playing hours lable
        Label hourLable = new Label("How many hour user play game : ");
        hourLable.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerHourLable = new Label();
        HBox hour = new HBox(hourLable, answerHourLable);
        hour.setAlignment(Pos.CENTER);


        //create play with computer lable
        Label computerLabel = new Label("Play with computer : ");
        computerLabel.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));


        //create num wins with computer lable
        Label numWinComputer = new Label("Number of wins :");
        numWinComputer.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerNumWinComputer = new Label();
        HBox winComputer = new HBox(numWinComputer, answerNumWinComputer);
        winComputer.setAlignment(Pos.CENTER);


        //create num failure with computer lable
        Label numFailureComputer = new Label("Number of failures :");
        numFailureComputer.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerNumFailureComputer = new Label();
        HBox failureComputer = new HBox(numFailureComputer, answerNumFailureComputer);
        failureComputer.setAlignment(Pos.CENTER);

        //create play in server lable
        Label serverLable = new Label("Play in Server");
        serverLable.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));


        //create num wins in server lable
        Label numWinServer = new Label("Number of wins :");
        numWinServer.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerNumWinServer = new Label();
        HBox winServer = new HBox(numWinServer, answerNumWinServer);
        winServer.setAlignment(Pos.CENTER);

        //create num failure in server lable
        Label numFailureServer = new Label("Number of failures :");
        numFailureServer.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        answerNumFailureServer = new Label();
        HBox failureServer = new HBox(numFailureServer, answerNumFailureServer);
        failureServer.setAlignment(Pos.CENTER);

        //create user's tank lable
        Label tankLabel = new Label("User's tank :");
        tankLabel.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
        tankButton = new Button();
        HBox tank = new HBox(tankLabel, tankButton);
        tank.setAlignment(Pos.CENTER);


        //create user setting text
        Text userSettingTXT = new Text("User Setting");
        userSettingTXT.setFill(Color.ORANGE);
        userSettingTXT.setStroke(Color.BLACK);
        userSettingTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        userSettingTXT.setStrokeWidth(2);



        //set nodes in tilepane
        TilePane tilePane =new TilePane(Orientation.VERTICAL);
        tilePane.getChildren().addAll(userSettingTXT,name, hour, computerLabel, winComputer, failureComputer, serverLable, winServer, failureServer, tank);
        tilePane.setAlignment(Pos.CENTER);


        //background pic
       FileInputStream input = null;
       try {
           input = new FileInputStream(".//icons//pic.jpg");
       }catch (Exception e){}
       Image image = new Image(input);
       BackgroundImage backgroundimage = new BackgroundImage(image,
               BackgroundRepeat.NO_REPEAT,
               BackgroundRepeat.NO_REPEAT,
               BackgroundPosition.DEFAULT,
               BackgroundSize.DEFAULT);


       Rectangle2D screenBounds = Screen.getPrimary().getBounds();
       this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);

       this.setBackground(new Background(backgroundimage));

       this.setCenter(tilePane);

      
    }
}
