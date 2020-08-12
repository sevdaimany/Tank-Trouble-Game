import java.io.Serializable;

/**
 * This class represent a Player in game
 * A player has a {@link Tank} and a {@link Controller}
 * 
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.2.0
 */
public class Player extends Identity implements Serializable
{
            /*  Fields  */

    // score of the player
    private int score;

    // player's tank
    private Tank playerTank;

    // player's controller
    private PlayingController playerController;


    private static final long serialVersionUID = 615788720176053870L;







         /* Constructor */

    /**
     * Create new Player with his/her identity
     * After constructor you should call {@link Player#createPlayerTank(String)}.
     * And then call {@link Player#createPlayerController(int, int, int, int)}
     * 
     * 
     * @param name : name of the player
     * @param lastName : last name of the player
     * @param username : a username for player
     * @param password : a password for player
     * 
     * @see Player#createPlayerTank(String)
     * @see Player#createPlayerController(int, int, int, int)
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









            /*  Methods  */

    /**
     * This method create player's tank.
     * This method should be call after {@link Player#Player(String, String, String, String)}
     * 
     * 
     * @param imageFilePath : address of the tank image file
     */
    public void createPlayerTank(String imageFilePath)
    {
        playerTank = new Tank(imageFilePath);
    }


    /**
     * This method create player's controller
     * This method should be call after {@link Player#createPlayerTank(String)}
     * 
     *  
     * @param playerTank : player's {@code Tank}
     * @param moveAheadKey : code of the key that moves tank ahead
     * @param moveBackwardsKey : code of the key that moves tank backwards
     * @param turnRightKey : code of the key that turns tank to the right
     * @param turnLeftKey : code of the key that turns tank to the left
     * 
     * @throws NullPointerException if player's tank not created. before this method, you should call {@link Player#createPlayerTank(String)}
     */
    public void createPlayerController(int moveAheadKey, int moveBackwardsKey, 
                                       int turnRightKey, int turnLeftKey) throws NullPointerException 
    {
        if (playerTank == null)
            throw new NullPointerException("player's tank not created");

        playerController = new PlayingController(playerTank, 
                                            moveAheadKey, moveBackwardsKey, 
                                            turnRightKey, turnLeftKey);
    }


    // * getter methods *

    /**
     * @return tank of the player
     */
    public Tank getPlayerTank() { return playerTank; }
}