import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;

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

        HBox topHBox = new HBox(menu,leaderBoardTXT);
        topHBox.setPadding(new Insets(5,5,5,5));


        HBox hBox = new HBox(numbers,username , scores , medals);
        hBox.setMaxWidth(600);
        hBox.setPadding(new Insets(20,0,20,20));
        hBox.setStyle(
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: darkgoldenrod;");


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxWidth(600);
        scrollPane.setMaxHeight(500);
        scrollPane.setContent(hBox);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.pannableProperty().set(true);

         //hbox background
         FileInputStream input = null;
         try
         {
             input = new FileInputStream(DataBase.getBackground2Icon());
         }catch (Exception e){}
 
         Image image = new Image(input);
         BackgroundImage backgroundimage = new BackgroundImage(image,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundPosition.DEFAULT,
                 BackgroundSize.DEFAULT);
 
         hBox.setBackground(new Background(backgroundimage));
 


         this.setCenter(scrollPane);
         this.setTop(new VBox( topHBox ,new Label( "   ") ));
 
         Rectangle2D screenBounds = Screen.getPrimary().getBounds();
         this.setPrefSize(screenBounds.getWidth(),screenBounds.getHeight() -60);
 


          //background
        FileInputStream input2 = null;

        try { input2 = new FileInputStream(DataBase.getBackgroundIconPath()); }
        catch (Exception e){}

        Image image2 = new Image(input2);
        BackgroundImage backgroundimage2 = new BackgroundImage(image2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        this.setBackground(new Background(backgroundimage2));


    }

    /**
     * @return menu button
     */
    public Button getMenu() { return menu; }

}