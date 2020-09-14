import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;



/**
 * This class represent gameSetting page's view
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class GameSettingView extends BorderPane {

           /*  Fields  */

           private Slider tankesHealthSlider;
           private Slider bulletPowerSlider;
           private Slider wallHealthSlider;
           private Slider ammosLifeTimeSlider;
           private Button saveButton;
       
       
       
       
       
       
       
                /* Constructor */
       
           public GameSettingView() {
       
       
       
               //tank's health lable
               Label tankesHealth = new Label("Tank's health  :  ");
               tankesHealth.setFont(Font.font("normal" , FontWeight.BOLD , FontPosture.REGULAR, 15));
       
               tankesHealthSlider = new Slider(0,200,DataBase.getSettings().tanksHealth);
               tankesHealthSlider.setShowTickLabels(true);
               tankesHealthSlider.setMajorTickUnit(10f);
               tankesHealthSlider.setMinSize(600,10);
       
       
               HBox tank = new HBox(tankesHealth, tankesHealthSlider);
               tank.setAlignment(Pos.CENTER);
               tank.setSpacing(5);
       
       
       
               //bullet's power lable
               Label bulletPower = new Label("Ammo's power : ");
               bulletPower.setFont(Font.font("normal" ,FontWeight.BOLD ,FontPosture.REGULAR, 15));
               bulletPowerSlider = new Slider(0,200,DataBase.getSettings().ammoDamage);
       
               bulletPowerSlider.setShowTickLabels(true);
               bulletPowerSlider.setMajorTickUnit(10f);
               bulletPowerSlider.setMinSize(600,10);
       
               HBox bullet = new HBox(bulletPower, bulletPowerSlider);
               bullet.setAlignment(Pos.CENTER);
               bullet.setSpacing(5);
       
       
               
               //wall's health lable
               Label wallHealth = new Label("Wall's health  :  ");
               wallHealth.setFont(Font.font("normal" ,FontWeight.BOLD ,FontPosture.REGULAR, 15));
               wallHealthSlider = new Slider(0,200,DataBase.getSettings().woodWallsHealth);
       
               wallHealthSlider.setShowTickLabels(true);
               wallHealthSlider.setMajorTickUnit(10f);
               wallHealthSlider.setMinSize(600,10);
       
               HBox wall = new HBox(wallHealth, wallHealthSlider);
               wall.setAlignment(Pos.CENTER);
               wall.setSpacing(5);
       
               //ammo's life time
               Label ammosLifeTime = new Label("Ammo's life time :  ");
       
               ammosLifeTime.setFont(Font.font("normal" ,FontWeight.BOLD ,FontPosture.REGULAR, 15));
               ammosLifeTimeSlider = new Slider(0,200,DataBase.getSettings().woodWallsHealth);
       
               ammosLifeTimeSlider.setShowTickLabels(true);
               ammosLifeTimeSlider.setMajorTickUnit(10f);
               ammosLifeTimeSlider.setMinSize(600,10);
       
               HBox ammoLife = new HBox(ammosLifeTime, ammosLifeTimeSlider);
               ammoLife.setAlignment(Pos.CENTER);
               ammoLife.setSpacing(5);
       
       
               saveButton = new Button("Save");
               saveButton.setPrefSize(150,40);
               saveButton.setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
       
       
       
               //background
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
       
       
               VBox vBox = new VBox(tank,bullet,wall,ammoLife,saveButton);
               vBox.setPadding(new Insets(30,30,30,30));
               vBox.setSpacing(10);
               vBox.setAlignment(Pos.CENTER);
               vBox.setBackground(new Background(backgroundimage));
       
       
       
               //game setting text
               Text gameSettingTXT = new Text("Game Setting");
               gameSettingTXT.setFill(Color.ORANGE);
               gameSettingTXT.setStroke(Color.BLACK);
               gameSettingTXT.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 70));
               gameSettingTXT.setStrokeWidth(2);
       
       
       
               VBox gameSetting = new VBox(gameSettingTXT,new Label(" "),new Label(" "),new Label(" "),vBox);
               gameSetting.setAlignment(Pos.CENTER);
               gameSetting.setMaxWidth(820);
               gameSetting.setSpacing(5);
               this.setCenter(gameSetting);
           }


        /**
         * @return tank health's slider
         */
        public Slider getTankesHealthSlider() {
            return tankesHealthSlider;
        }
    
        /**
         * @return bullet power's slider
         */
        public Slider getBulletPowerSlider() {
            return bulletPowerSlider;
        }
    
        /**
         * @return wall health slider
         */
        public Slider getWallHealthSlider() {
            return wallHealthSlider;
        }
    
        /**
         * @return ammo lifeTime's slider
         */
        public Slider getAmmosLifeTimeSlider() {
            return ammosLifeTimeSlider;
        }

        /** 
         * @return save button
         */
        public Button getSaveButton() {
            return saveButton;
        }
        }
