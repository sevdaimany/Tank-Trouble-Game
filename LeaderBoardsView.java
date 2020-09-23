import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * this class represent the Leaderboards view of the game
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class LeaderBoardsView extends BorderPane {

     //menu button
     private Button menu;



    public LeaderBoardsView(){

        VBox username = new VBox();

        VBox numbers = new VBox();

        VBox scores = new VBox();

        VBox medals = new VBox();




        try {
            Player[] players = DataBase.getLeaderBoards();
            for (int i =0 ; i < players.length ; i++) {
                Label playerInfo = new Label(players[i].getUsername() + " :            "  );
                playerInfo.setAlignment(Pos.BASELINE_LEFT);
                playerInfo.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                username.getChildren().add(new Label("  "));
                username.getChildren().add(playerInfo);

                Label number = new Label((i+1) + ")           " );
                number.setAlignment(Pos.BASELINE_LEFT);
                number.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                numbers.getChildren().addAll(new Label("  ") , number );


                Label score = new Label( players[i].getScore() +" wins            ");
                score.setAlignment(Pos.BASELINE_LEFT);
                score.setFont(Font.font("Verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                scores.getChildren().addAll(new Label("  ") , score );



                if( i == 0){
                    FileInputStream input = null;

                    try { input = new FileInputStream("icons/gold.png"); }
                    catch (FileNotFoundException e) { e.printStackTrace(); }


                    Image image = new Image(input);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(30);
                    medals.getChildren().add(imageView);

                }

                if( i == 1){
                    FileInputStream input = null;

                    try { input = new FileInputStream("icons/silver.png"); }
                    catch (FileNotFoundException e) { e.printStackTrace(); }


                    Image image = new Image(input);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(30);

                    medals.getChildren().add(imageView);

                }


                if( i == 2){
                    FileInputStream input = null;

                    try { input = new FileInputStream("icons/bronze.png"); }
                    catch (FileNotFoundException e) { e.printStackTrace(); }


                    Image image = new Image(input);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(30);

                    medals.getChildren().add(imageView);

                }             

             
            }
        }catch (Exception  e ){e.printStackTrace();}


       //leaderBoards text
       Text leaderBoardTXT = new Text("                  leaderBoard");
       leaderBoardTXT.setFill(Color.ORANGE);
       leaderBoardTXT.setStroke(Color.BLACK);
       leaderBoardTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 70));
       leaderBoardTXT.setStrokeWidth(2);

           //set menu button
        FileInputStream input3 = null;

        try { input3 = new FileInputStream(DataBase.getGoBackIcon()); }
        catch (IOException e){}

        Image icon1 = new Image(input3);
        ImageView imageView1 = new ImageView(icon1);
        menu = new Button("Menu" , imageView1);



           
   


    }
}