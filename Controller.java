import java.awt.event.KeyEvent;




/**
 * This class represent a controller for a {@code Player}
 * This class actually handles the key events for a {@code Tank}
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.5
 */
public class Controller
{
            /*  Fields  */

    // Tank that this controller will control that
    private Tank tank;

    // control keys code
    private int moveAheadKey, moveBackwardsKey, turnRightKey, turnLeftKey;

    // this booleans save the keys status
    private boolean isUpPressed, isDownPressed, isRightPressed, isLeftPressed;

    // move speed of the tank (pixel/second)
    private float moveSpeed;

    // rotation speed of the tank (degree/second)
    private float rotationSpeed;








         /* Constructor */


    /**
     * Create a new Controller for player's tank
     * 
     * 
     * @param playerTank : player's {@code Tank}
     * @param moveAheadKey : code of the key that moves tank ahead
     * @param moveBackwardsKey : code of the key that moves tank backwards
     * @param turnRightKey : code of the key that turns tank to the right
     * @param turnLeftKey : code of the key that turns tank to the left
     * 
     * @see {@link KeyEvent} for keys code (example: KeyEvent.VK_W == code of the 'w' key)
     */
    public Controller(Tank playerTank, int moveAheadKey, int moveBackwardsKey, int turnRightKey, int turnLeftKey) 
    {
        this.tank = playerTank;

        this.moveAheadKey = moveAheadKey;
        this.moveBackwardsKey = moveBackwardsKey;
        this.turnRightKey = turnRightKey;
        this.turnLeftKey = turnLeftKey;


        isUpPressed = isDownPressed = isRightPressed = isLeftPressed = false;

        moveSpeed = 10;
        rotationSpeed = 10;
    }
    








    
            /*  Methods  */

    


    // this method moves the tank
    // param ahead : set this true to go ahead. if you set it false, tanks will go backwards
    private void moveTank(boolean ahead)
    {
        float teta = this.tank.getTeta();

        int x_delta = (int) Math.ceil(moveSpeed * (Math.cos(Math.toRadians(teta))));
        int y_delta = -1 * (int) Math.ceil(moveSpeed * (Math.sin(Math.toRadians(teta))));


        if (ahead)
        {
            this.tank.xDelta(x_delta);
            this.tank.yDelta(y_delta);
        }
        else
        {
            this.tank.xDelta(-1 * x_delta);
            this.tank.yDelta(-1 * y_delta);
        }
    }
}