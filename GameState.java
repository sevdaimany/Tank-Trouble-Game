import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;




/**
 * This class holds and update the state of the game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @author Sevda Imany
 * 
 * @version 0.3.0
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
    private static ArrayList<Wall> walls;

    // playing controllers
    private static ArrayList<PlayingController> playingControllers;








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
        Tank tank = new Tank("tank_blue.png");
        PlayingController playingController = new PlayingController(tank, KeyCode.RIGHT, KeyCode.LEFT, KeyCode.UP, KeyCode.DOWN);
        tanks.add(tank);
        playingControllers.add(playingController);
        keyholder();
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
     * The method which updates the tanks state.
     */
    public static void updateTankState() 
    {
        for (PlayingController controller : playingControllers)
            controller.updateTankState();
    }


    /**
     * The keyboard handler.
     */
    public static void keyholder() 
    {
        Main.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("keypress");
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

}