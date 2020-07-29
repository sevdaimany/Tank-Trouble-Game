



/**
 * This class represent a Player in game
 * A player has a {@link Tank} and a {@link Controller}
 * 
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.5
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

        playerController = new Controller(playerTank, 
                                            moveAheadKey, moveBackwardsKey, 
                                            turnRightKey, turnLeftKey);
    }
}