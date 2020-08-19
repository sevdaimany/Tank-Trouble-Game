




/**
 * This class represent an Ammo for Tank in game
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.6.0
 */
public class Ammo extends Tile
{
            /*  Fields  */

    // damage of this Ammo
    private int damage;

    // Ammo angel - for movement direction 
    private float teta;

    // move speed of ammo
    private float ammoMoveSpeed;









         /* Constructor */

    /**
     * Create a new Ammo with given details
     * 
     * 
     * @param imagePath : address of the image file
     * @param tankX : x of the Ammo when Tank fire it 
     * @param tankY : y of the Ammo when Tank fire it  
     * @param tankTeta : Ammo throwing angle
     * @param height : height of the ammo image
     * @param width : width of the ammo image
     */
    public Ammo(String imagePath, float tankX, float tankY, float tankTeta, int height, int width)
    {
        super(tankX, tankY, width, height, imagePath);


        this.teta = teta;
        this.ammoMoveSpeed = 10;

        this.damage = 50;
    }








            /*  Methods  */


    // * getter methods *

    /**
     * @return degree of Ammo
     */
    public float getTeta() { return teta; }
    /**
     * @return damage of Ammo
     */
    public int getDamage() { return damage; }



    /**
     * This method moves the ammo on the map 
     */
    public void move()
    {
        float x_delta = -1 * (float) Math.round(ammoMoveSpeed * (Math.cos(Math.toRadians(90 - teta))));
        float y_delta =  (float) Math.round(ammoMoveSpeed * (Math.sin(Math.toRadians(90 - teta))));

        setX(getX() + x_delta);
        setY(getY() + y_delta);
    }


    /**
     * This method changes the route of the ammo
     * 
     * 
     * @param wall : which wall this ammo hit
     */
    public void hit(Wall wall)
    {
        if (Math.abs(this.getX() - wall.getX()) == Math.abs(this.getY() - wall.getY()))
        {
            this.teta += 180;
            return;
        }


        char status = (Math.abs(this.getX() - wall.getX()) > Math.abs(this.getY() - wall.getY())) ? 'v': 'h';

        if (status == 'v')
            ammoMoveSpeed *= -1;
    }




    

    // this method calculate the x of the ammo
    private float calculateX(float tankX, float tankTeta)
    {
        float x_delta = -1 * (float) Math.round(ammoMoveSpeed * (Math.cos(Math.toRadians(90 - tankTeta))));
        x_delta += 47 * Math.signum(-1 * (float) Math.round(ammoMoveSpeed * (Math.cos(Math.toRadians(90 - tankTeta)))));
        
        return tankX + x_delta;
    }


    // this method calculate the y of the ammo
    private float calculateY(float tankY, float tankTeta)
    {
        float y_delta = (float) Math.round(ammoMoveSpeed * (Math.sin(Math.toRadians(90 - teta))));
        y_delta += 47 * Math.signum((float) Math.round(ammoMoveSpeed * (Math.sin(Math.toRadians(90 - teta)))));
        
        return tankY + y_delta;
    }
}