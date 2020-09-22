
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

    //damage of tank's ammo
    private int ammoDamage;

    // tank angel 
    private float teta;

    // radius of tank body
    private float tankRadius;

    //tank's width
    private static final float WIDTH = 20;

    //tank's height
    private static final float HEIGHT = 22;

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
        health = DataBase.getSettings().tanksHealth;
        ammoDamage = DataBase.getSettings().ammoDamage;
        ammo = null;
        teta = 0;
    }









            /*  Methods */


    /**
     * this method add tank's imageView to the root of game
     */
    public void addToGameRoot(){
        Main.getRootPlayGround().getChildren().add(imageView);
    }


    /**
     * this method remove tank's imageView from the root of game
     */
    public void removeFromRoot(){
        Main.getRootPlayGround().getChildren().remove(imageView);
    }

            

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
     * @return damage of tank's ammo
     */
    public int getAmmoDamage() { return ammoDamage; }

    /**
     * @param damage
     */
    public void setAmmoDamage(int damage) {
        this.ammoDamage = damage;
    }

    /**
     * @return tank's health
     */
    public int getHealth() {   return health;  }



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
     * This method reduce tank's health with given damage value
     * @param ammo_damage
     */
    public void reduceHealth(int ammo_damage){
        this.health -= ammo_damage;
    }


    // this method draw a tank in game's playground
    public void draw()
    {
        imageView.setRotate(teta);
        imageView.relocate(super.getX(),super.getY());
    }
}