import java.io.Serializable;




/**
 * This class represent a Tank in game
 * each tank has a specific image
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.4.5
 */
public class Tank implements Serializable
{
            /*  Fields  */

    // the image of tank that shown in GUI
    private String imagePath;

    // health of the tank - an int in range:  0 <= x <= 100
    private int health;

    // ammo kind of the tank
    private Ammo ammo;

    // tank cordite
    private int x, y;

    // tank angel 
    private float teta;

    // radius of tank body
    private float tankRadius;



    private static final long serialVersionUID = 8365500129362383843L;







         /* Constructor */


    /**
     * Create new Tank with the given image file
     * 
     * 
     * @param ImageFilePath : address of the image file
     */
    public Tank(String imageFilePath)
    {
        this.imagePath = imageFilePath;
        health = 100;
        ammo = null;
    }









            /*  Methods */
            

    // * setter methods *

    /**
     * @param x : new x of this tank to set
     */
    public void setX(int x) { this.x = x; }
    /**
     * @param y : new y of this tank to set
     */
    public void setY(int y) { this.y = y; }
    /**
     * @param teta : new teta of this tank to set
     */
    public void setTeta(float teta) { this.teta = teta; }


    // * getter methods *
    
    /**
     * @return path of the image file of Tank 
     */
    public String getImage() { return imagePath; }
    /**
     * @return x of Tank
     */
    public int getX() { return x; }
    /**
     * @return y of Tank
     */
    public int getY() { return y; }
    /**
     * @return degree of Tank
     */
    public float getTeta() { return teta; }



    /**
     * This method change the x of the tank by given delta(amount of changes)
     * 
     * @param x_delta : amount of changes of x
     */
    public void xDelta(int x_delta)
    {
        this.x += x_delta;
    }


    /**
     * This method change the y of the tank by given delta(amount of changes)
     * 
     * @param y_delta : amount of changes of y
     */
    public void yDelta(int y_delta)
    {
        this.y += y_delta;
    }


    /**
     * This method change the angle of the tank by given delta(amount of changes)
     * 
     * @param teta_delta : amount of changes of teta(in degree)
     */
    public void tetaDelta(int teta_delta)
    {
        this.teta += teta_delta;
    }    
    
    
    /**
     * This method checks that the given ammo has hit the tank or not
     * If the given ammo has hit the tank the health of will be reduced
     * 
     * 
     * @param ammo : ammo to check
     * @return {@code true} if the given ammo has hit the tank 
     */
    public boolean isHit(Ammo ammo)
    {
        double d = distance(this.x, this.y, ammo.getX(), ammo.getY());

        boolean hit = (d <= this.tankRadius + ammo.getAmmoRadius() + 2.5);


        if (hit)
            this.health -= ammo.getDamage();


        return hit;
    }





    // this method return the distance between two object in game ground
    private double distance(int x1, int y1, int x2, int y2)
    {
        return Math.abs(Math.sqrt((x1-x2)*(x1-x2) - (y1-y2)*(y1-y2)));
    }
}