import java.util.ArrayList;




/**
 * This class holds and update the state of the game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.3
 */
public class GameState 
{
            /*  Fields  */

    // players of the game
    private static ArrayList<Player> players;

    // tank of players
    private static ArrayList<Tank> tanks;

    // fired ammos from tanks
    private static ArrayList<Ammo> firedAmmos;

    // walls of the map
    private static ArrayList<Wall> walls;








            /*  Methods  */

    /**
     * This method is a kind of constructor for this class
     */
    public static void init()
    {
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        firedAmmos = new ArrayList<>();
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
}