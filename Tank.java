
import java.io.Serializable;
import javafx.scene.image.ImageView;





/**
 * This class represent a Tank in game
 * Each tank has a specific image
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @author Sevda Imany
 * 
 * @version 0.7.3
 */
public class Tank  extends Tile implements Serializable
{
            /*  Fields  */

    // health of the tank - an int in range:  0 <= x <= 100
    private int health;

    // ammo kind of the tank
    private transient Ammo ammo;

   
    // tank angel 
    private float teta;

    // radius of tank body
    private float tankRadius;

    //tank's width
    private static final float WIDTH = 42;

    //tank's height
    private static final float HEIGHT = 46;

    // tank's imageView
    private ImageView imageView;



    private static final long serialVersionUID = 8365500129362383843L;







         /* Constructor */


    /**
     * Create new Tank with the given image file
     * 
     * 
     * @param ImageFilePath : address of the image file
     */
    public Tank(float x ,float y ,String imageFilePath)
    {
        super(x, y ,WIDTH ,HEIGHT , imageFilePath);
        imageView = new ImageView(super.getImage());
        Main.getRootPlayGround().getChildren().add(imageView);
        health = 100;
        ammo = null;
        teta = 0;
    }









            /*  Methods */
            

    // * setter methods *

    /**
     * @param teta : new teta of this tank to set
     */
    public void setTeta(float teta) { this.teta = teta; }
    /**
     * @param ammo : new ammo to set
     */
    public void setAmmo(Ammo ammo) { this.ammo = ammo; }


    // * getter methods *
    
    /**
     * @return degree of Tank
     */
    public float getTeta() { return teta; }
    /**
     * @return tank's imageview
     */
    public ImageView getImageView() { return imageView; }
    /**
     * @return {@code true} if tank.health > 0
     */
    public boolean isAlive() { return  (this.health > 0); }
    /**
     * @return the ammo kind of this tank
     */
    public Ammo getAmmo() { return ammo; }



    /**
     * This method change the x of the tank by given delta(amount of changes)
     * 
     * @param x_delta : amount of changes of x
     */
    public void xDelta(float x_delta)
    {
        super.setX(super.getX() + x_delta);
    }


    /**
     * This method change the y of the tank by given delta(amount of changes)
     * 
     * @param y_delta : amount of changes of y
     */
    public void yDelta(float y_delta)
    {
        super.setY(super.getY() + y_delta);
    }


    /**
     * This method change the angle of the tank by given delta(amount of changes)
     * 
     * @param teta_delta : amount of changes of teta(in degree)
     */
    public void tetaDelta(float teta_delta)
    {
        this.teta += teta_delta;
    } 
    
    
    /**
     * This method set the health of the tank 
     * 
     * @param health_delta : amount of the health that this tank taken
     */
    public void healthDelta(int health_delta)
    {
        this.health += health_delta;
        this.health = Math.min(this.health, DataBase.getSettings().tanksHealth);
    }
    
    
    /**
     * This method checks that the given ammo has hit the tank or not
     * If the given ammo has hit the tank the health of will be reduced
     * 
     * 
     * @param ammo : ammo to check
     * @return {@code true} if the given ammo has hit the tank 
     */
    // public boolean isHit(Ammo ammo)
    // {
    //     double d = distance(super.getX(), super.getY(), ammo.getX(), ammo.getY());

    //     boolean hit = (d <= this.tankRadius + ammo.getAmmoRadius() + 2.5);


    //     if (hit)
    //         this.health -= ammo.getDamage();


    //     return hit;
    // }





    // this method return the distance between two object in game ground
    // private double distance(float x1, float y1,float x2,float y2)
    // {
    //     return Math.abs(Math.sqrt((x1-x2)*(x1-x2) - (y1-y2)*(y1-y2)));
    // }


    // this method draw a tank in game's playground
    public void draw()
    {
        imageView.setRotate(teta);
        imageView.relocate(super.getX(),super.getY());
    }
}