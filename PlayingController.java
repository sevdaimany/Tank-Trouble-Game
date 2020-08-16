import java.io.Serializable;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;




/**
 * This class represent a controller for a {@code Player}
 * This class actually handles the key events for a {@code Tank}
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.6.6
 */
public class PlayingController implements Serializable
{
            /*  Fields  */

    // Tank that this controller will control that
    private Tank tank;

    // control keys code
    private KeyCode moveAheadKey, moveBackwardsKey, turnRightKey, turnLeftKey;

    // this booleans save the keys status
    private boolean isMoveAheadPressed, isMoveBackwardsPressed, isTurnRightPressed, isTurnLeftPressed;

    // move speed of the tank (pixel/second)
    private float moveSpeed;

    // rotation speed of the tank (degree/second)
    private float rotationSpeed;

    //tank's hidden rectangle
    private Rectangle hiddenTank;

    
    private static final long serialVersionUID = 585728211822624899L;








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
     */
    public PlayingController(Tank playerTank, KeyCode moveAheadKey, KeyCode moveBackwardsKey, KeyCode turnRightKey, KeyCode turnLeftKey) 
    {
        this.tank = playerTank;

        this.moveAheadKey = moveAheadKey;
        this.moveBackwardsKey = moveBackwardsKey;
        this.turnRightKey = turnRightKey;
        this.turnLeftKey = turnLeftKey;


        isMoveAheadPressed = isMoveBackwardsPressed = isTurnRightPressed = isTurnLeftPressed = false;

        moveSpeed = 2;
        rotationSpeed = 5;
    }
    








    
            /*  Methods  */

    /**
     * This method handle the key press event
     * If the pressed key doesn't belong to the tank of this controller, the call will ignored
     * 
     * @param keyCode : code of the key that pressed
     */
    public void keyPressEvent(KeyCode keyCode)
    {
        if (keyCode == moveAheadKey)
            isMoveAheadPressed = true;

        if (keyCode == moveBackwardsKey)
            isMoveBackwardsPressed = true;

        if (keyCode == turnRightKey)
            isTurnRightPressed = true;

        if (keyCode == turnLeftKey)
            isTurnLeftPressed = true;
    }


    /**
     * This method handle the key release event
     * If the released key doesn't belong to the tank of this controller, the call will ignored
     * 
     * @param keyCode : code of the key that released
     */
    public void keyReleasedEvent(KeyCode keyCode)
    {
        if (keyCode == moveAheadKey)
            isMoveAheadPressed = false;

        if (keyCode == moveBackwardsKey)
            isMoveBackwardsPressed = false;

        if (keyCode == turnRightKey)
            isTurnRightPressed = false;

        if (keyCode == turnLeftKey)
            isTurnLeftPressed = false;
    }


    /**
     * This method updates the state of the tank according to player pressed keys
     * Call this method in each game loop
     */
    public void updateTankState()
    {
        if (isMoveAheadPressed)
            moveTank(true);

        if (isMoveBackwardsPressed)
            moveTank(false);

        if (isTurnRightPressed)
            turnRight();

        if (isTurnLeftPressed)
            turnLeft();
    }

    






    // this method moves the tank
    // param ahead : set this true to go ahead. if you set it false, tanks will go backwards
    private void moveTank(boolean ahead)
    {

        hiddenTank = new Rectangle(this.tank.getX(), this.tank.getY(),42,46);
        hiddenTank.setRotate(tank.getTeta());


        float teta = this.tank.getTeta();

        int x_delta = -1 * (int) Math.round(moveSpeed * (Math.cos(Math.toRadians(90 -teta))));
        int y_delta =  (int) Math.round(moveSpeed * (Math.sin(Math.toRadians(90 -teta))));



        if (ahead)
        {
            hiddenTank.setX(hiddenTank.getX() + x_delta);
            hiddenTank.setY(hiddenTank.getY() + y_delta);
        }
        else
        {
            hiddenTank.setX(hiddenTank.getX() - x_delta);
            hiddenTank.setY(hiddenTank.getY() - y_delta);

        }

        if(!GameState.intersect(hiddenTank)){
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


    // this method turns tank to the right
    private void turnRight()
    {
        this.tank.tetaDelta(Math.round(rotationSpeed));
    }


    // this method turns tank to the left
    private void turnLeft()
    {
        this.tank.tetaDelta(-Math.round(rotationSpeed));
    }
}