import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;




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
    private static ArrayList<Ammo> firedAmmos;

    // walls of the map
    private static ArrayList<Wall> walls = new ArrayList<>();

    // playing controllers
    private static ArrayList<PlayingController> playingControllers;

    //width of game's playground    
    private static double widthPLayGround;

    //height of game's playground
    private static double heightPLayGround;










            /* Methods */

    /**
     * This method is a kind of constructor for this class
     */
    public static void init() 
    {
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        firedAmmos = new ArrayList<>();
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
        for (Ammo ammo: firedAmmos)
            ammo.move();
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

    public static ArrayList<Ammo> getFiredAmmos() {
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
            if (intersect(tankRectangle , wall.getRectangle())) {
                return true;
            }

        }

        return false;
    }
}