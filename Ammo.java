




/**
 * This class represent an Ammo for Tank in game
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.3.0
 */
public class Ammo extends Tile
{
            /*  Fields  */

    // damage of this Ammo
    private int damage;

    // Ammo angel - for movement direction 
    private float teta;

    // radius of Ammo
    private float ammoRadius;

    // move speed of ammo
    private float ammoMoveSpeed;









         /* Constructor */

    /**
     * Create a new Ammo with given details
     * 
     * 
     * @param imagePath : address of the image file
     * @param x : x of the Ammo when Tank fire it 
     * @param y : y of the Ammo when Tank fire it  
     * @param teta : Ammo throwing angle
     * @param ammoRadius : radius of Ammo
     */
    public Ammo(String imagePath, float x, float y, float teta, float ammoRadius)
    {
        super(x, y, 10, 10, imagePath);


        this.teta = teta;
        this.ammoRadius = ammoRadius;
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
     * @return radius of Ammo
     */
    public float getAmmoRadius() { return ammoRadius; }
    /**
     * @return damage of Ammo
     */
    public int getDamage() { return damage; }



    /**
     * This method moves the ammo on the map 
     */
    public void move()
    {
        float x_delta = -1 * (float) Math.round(moveSpeed * (Math.cos(Math.toRadians(90 - teta))));
        float y_delta =  (float) Math.round(moveSpeed * (Math.sin(Math.toRadians(90 - teta))));

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
}