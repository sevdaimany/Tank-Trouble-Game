import java.util.ArrayList;




/**
 * This class holds and update the state of the game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
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
}