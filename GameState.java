import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;




/**
 * This class holds and update the state of the game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @author Sevda Imany
 * 
 * @version 0.6.0
 */
public class GameState 
{
            /* Fields */

    // players of the game
    private static ArrayList<Player> players;

    // tank of players
    private static ArrayList<Tank> tanks;

    // fired ammos from tanks
    private static LinkedList<Ammo> firedAmmos;

    // walls of the map
    private static ArrayList<Wall> walls = new ArrayList<>();

    // playing controllers
    private static ArrayList<PlayingController> playingControllers;

    //width of game's playground    
    private static double widthPLayGround;

    //height of game's playground
    private static double heightPLayGround;

    //explosion imageView's array
   private static ImageView[] slides;











            /* Methods */

    /**
     * This method is a kind of constructor for this class
     */
    public static void init() 
    {
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        firedAmmos = new LinkedList<>();
        playingControllers = new ArrayList<>();
        Tank tank = new Tank(0,0,"./.TANK_TROUBLE_DATA_BASE/PHOTOS/TANKS/blackTank_kind1.png");
        PlayingController playingController = new PlayingController(tank, KeyCode.UP, KeyCode.DOWN, KeyCode.RIGHT, KeyCode.LEFT,KeyCode.M);
        tanks.add(tank);
        playingControllers.add(playingController);
        keyholder();
    }


    /**
     * This method updates the state of the game
     */
    public static void updateStates()
    {
        updateTankState();
        updateFiredAmmosState();
    }


    /**
     * This method add a new player to game
     * 
     * @param player : new player to add
     */
    public static void addPlayer(Player player) 
    {
        players.add(player);
        tanks.add(player.getPlayerTank());
    }


    /**
     * This method add the given ammo to the fired ammo list
     * 
     * @param ammo : ammo to add
     */
    public static void addFiredAmmo(Ammo ammo)
    {
        firedAmmos.add(ammo);
    }


    /**
     * The method which updates the tanks state.
     */
    public static void updateTankState() 
    {
        for (PlayingController controller : playingControllers)
            controller.updateTankState();
    }


    /**
     * This method updates fired ammos state
     */
    public static void updateFiredAmmosState()
    {
        for (Ammo ammo: firedAmmos){ 
            ammo.move();
            if(ammo_WoodWall_intersect(ammo)) {
                firedAmmos.remove(ammo);
                Main.getRootPlayGround().getChildren().remove(ammo.getImageView());

            }
        }
    }


    /**
     * The keyboard handler.
     */
    public static void keyholder() 
    {
        Main.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (PlayingController controller : playingControllers) {
                    controller.keyPressEvent(event.getCode());
                }
            }
        });

        Main.getStage().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (PlayingController controller : playingControllers) {
                    controller.keyReleasedEvent(event.getCode());
                }
            }
        });
    }


    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Tank> getTanks() {
        return tanks;
    }

    public static LinkedList<Ammo> getFiredAmmos() {
        return firedAmmos;
    }

    public static ArrayList<PlayingController> getPlayingControllers() {
        return playingControllers;
    }

    public static ArrayList<Wall> getWalls() {
        return walls;
    }

    public static double getWidthPLayGround() {
        return widthPLayGround;
    }

   
    public static double getHeightPLayGround() {
        return heightPLayGround;
    }

    public static void setHeightPLayGround(double heightPLayGround) {
        GameState.heightPLayGround = heightPLayGround;
    }


    public static void setWidthPLayGround(double widthPLayGround) {
        GameState.widthPLayGround = widthPLayGround;
    }



    public static Boolean intersect(Rectangle tile , Rectangle tile2) {
        if (tile.getBoundsInParent().intersects(tile2.getBoundsInParent()))
            return true;
        return false;
    }


    public static boolean tank_Wall_intersect(Rectangle tankRectangle){

        for (Wall wall : GameState.getWalls()) {
            if (intersect(tankRectangle , wall)) {
                return true;
            }

        }

        return false;
    }

    public static boolean ammo_WoodWall_intersect(Rectangle ammoRectangle){

        for (Wall wall : GameState.getWalls()) {
            if (wall instanceof WoodWall) {
                WoodWall woodWall = (WoodWall) wall;
                if (intersect(ammoRectangle, woodWall)) {
                        TileGrid.setTile(woodWall.getxCoordinate() , woodWall.getyCoordinate());
                        walls.remove(woodWall);
                        return true;

                }

            }

        }
        return false;

    }


    public static void simpleSlideShow(double x, double y) {
        slides = new ImageView[10];
        String[] smoke = DataBase.getFireExplosion("smoke");
        String[] fire = DataBase.getFireExplosion("fire");

        int j =0 ;
        for(int i = 0 ; i < 5 ; i++){
            FileInputStream input = null;

            try { input = new FileInputStream(smoke[i]); }
            catch (FileNotFoundException e) { e.printStackTrace(); }


            Image image = new Image(input , 90,90,false,false);


            FileInputStream input2= null;

            try { input2 = new FileInputStream(fire[i]); }
            catch (FileNotFoundException e) { e.printStackTrace(); }


            Image image2 = new Image(input2 , 90,90,false,false);

            slides[j] = new ImageView(image2);
            slides[j].relocate(x,y);

            j++;

            slides[j] = new ImageView(image);
            slides[j].relocate(x,y);

            j++;

        }
    }


    public static FadeTransition getFadeTransition(ImageView imageView, double fromValue, double toValue, int durationInMilliseconds) {

        FadeTransition ft = new FadeTransition(Duration.millis(durationInMilliseconds), imageView);
        ft.setFromValue(fromValue);
        ft.setToValue(toValue);

        return ft;

    }

    public static void explosion(double x ,double y) {

        simpleSlideShow(x, y);

        SequentialTransition slideshow = new SequentialTransition();

        for (ImageView slide : slides) {

            SequentialTransition sequentialTransition = new SequentialTransition();

            FadeTransition fadeIn = getFadeTransition(slide, 0.0, 1.0, 10);
            PauseTransition stayOn = new PauseTransition(Duration.millis(50));
            FadeTransition fadeOut = getFadeTransition(slide, 1.0, 0.0, 10);

            sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);
            slide.setOpacity(0);
            Main.getRootPlayGround().getChildren().add(slide);
            slideshow.getChildren().add(sequentialTransition);

        }
        slideshow.play();
    }




}