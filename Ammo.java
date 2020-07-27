import java.io.File;




/**
 * This class represent an Ammo for Tank in game
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.1
 */
public class Ammo 
{
            /*  Fields  */

    // the image of Ammo that shown in GUI
    private File image;

    // damage of this Ammo
    private int damage;

    // Ammo cordite
    private int x, y;

    // Ammo angel - for movement direction 
    private float teta;

    // radius of Ammo
    private float ammoRadius;









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
    public Ammo(String imagePath, int x, int y, float teta, float ammoRadius)
    {
        this.image = new File(imagePath);

        this.x = x;
        this.y = y;
        this.teta = teta;
        this.ammoRadius = ammoRadius;

        this.damage = 50;
    }








            /*  Methods  */


    // * getter methods *

    /**
     * @return image {@code File} of Ammo 
     */
    public File getImage() { return image; }
    /**
     * @return x of Ammo
     */
    public int getX() { return x; }
    /**
     * @return y of Ammo
     */
    public int getY() { return y; }
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


}