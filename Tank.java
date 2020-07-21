import java.io.File;




/**
 * This class represent a Tank in game
 * each tank has a specific image
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Tank
{
            /*  Fields  */

    // the image of tank that shown in GUI
    private File Image;

    // health of the tank - an int in range:  0 <= x <= 100
    private int health;

    // ammo kind of the tank
    private Ammo ammo;






         /* Constructor */


    /**
     * Create new Tank with the given image file
     * 
     * 
     * @param ImageFilePath : address of the image file
     */
    public Tank(String ImageFilePath)
    {
        this.Image = new File(ImageFilePath);
        health = 100;
        ammo = null;
    }
}