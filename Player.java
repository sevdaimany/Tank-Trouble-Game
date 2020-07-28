



/**
 * This class represent a Player in game
 * A player has a {@link Tank} and a {@link Controller}
 * 
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Player extends Identity
{
            /*  Fields  */

    // score of the player
    private int score;

    // player's tank
    private Tank playerTank;

    // player's controller
    private Controller playerController;





         /* Constructor */

    /**
     * Create new Player with his/her identity
     * 
     * 
     * @param name : name of the player
     * @param lastName : last name of the player
     * @param username : a username for player
     * @param password : a password for player
     */
    public Player(String name, 
                  String lastName, 
                  String username, 
                  String password)
    {
        super(name, lastName, username, password);

        score = 0;
        playerTank = null;
        playerController = null;
    }
}