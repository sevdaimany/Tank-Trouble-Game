import javafx.scene.image.ImageView;

/**
 * This class represent an Ammo for Tank in game
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.8.2
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

    // ammo's image view
    private ImageView imageView;

    // ammo life time
    private float lifeTime;

    // hold the creation time
    private long createTime;









         /* Constructor */

    /**
     * Create a new Ammo with given details
     * 
     * 
     * @param imagePath : address of the image file
     * @param height : height of the ammo image
     * @param width : width of the ammo image
     */
    public Ammo(String imagePath, int height, int width , Tank tank)
    {
        super(tank.getX(), tank.getY(), width, height, imagePath);
        this.teta = tank.getTeta();
        super.setX(calculateX(tank.getX(), teta));
        super.setY(calculateY(tank.getY(), teta));

        imageView = new ImageView(super.getImage());
        Main.getRootPlayGround().getChildren().add(imageView);


        this.ammoMoveSpeed = 1;

        this.damage = DataBase.getSettings().ammoDamage;

        this.lifeTime = DataBase.getSettings().ammosLifeTime;

        createTime = System.currentTimeMillis();
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
     * @return ammo's imageView
     */
    public ImageView getImageView() { return imageView; }
    /**
     * @return the life time of the ammo
     */
    public float getLifeTime() { return lifeTime; }








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
        if (this.teta < 0)
            teta = (teta % 360) + 360;

        if ()
    }




    

    // this method calculate the x of the ammo
    private double calculateX(double tankX, float tankTeta)
    {
 
        float teta = (tankTeta % 360 + 360) % 360;
        
        float x_delta2 = 0;
        float x_delta = 0;

        if(teta >= 270 && teta < 360) {
             x_delta2 = -1 * (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 21;
             x_delta = -1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 23;
        }
        else if ( teta > 0 && teta < 90 ){
            x_delta2 =   (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 21;
            x_delta =  -1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 25;
        }
        else if ( teta >= 90 && teta < 180 ){
            x_delta2 =   (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 21;
            x_delta =   -1 *(float) Math.cos(Math.toRadians(90 - tankTeta)) * 27;
        }
        else if ( teta > 180 && teta < 270 ){
            x_delta2 = -1 *  (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 21;
            x_delta  =-1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 27;
        }


        
        if( teta == 180 || teta == 0)
            x_delta += 18;


        return tankX + x_delta2  + x_delta ;
    }




    // this method calculate the y of the ammo
    private double calculateY(double tankY, float tankTeta)
    {

        float teta = (tankTeta % 360 + 360) % 360;


        float y_delta2 = 0;
        float y_delta = 0;

        if(teta > 270 && teta < 360) {
             y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 21;
             y_delta = (float) Math.sin(Math.toRadians(90 - tankTeta)) * 23;
        }

        else if ( teta >= 0 && teta < 90 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 21;
            y_delta = (float) Math.sin(Math.toRadians(90 - tankTeta)) * 25;
        }

        else if ( teta > 90 && teta < 180 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 21;
            y_delta =  (float) Math.cos(Math.toRadians(90 - tankTeta)) * 18;
        }

        else if ( teta >= 180 && teta < 270 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 21;
            y_delta =  -1 *(float) Math.cos(Math.toRadians(90 - tankTeta)) * 18;
        }


        if( teta == 90  || teta == 270){
            y_delta += 16;
        }



        return tankY +  y_delta2  +y_delta;
    }


    //this method draw an ammo in game playground
    public void draw()
    {
        if (!isAlive())
            return;

        imageView.setRotate(teta + 180);
        imageView.relocate(super.getX(),super.getY());
    }


    // this method return true if ammos life time not ended
    private boolean isAlive()
    {
        long currentTime = System.currentTimeMillis();

        return (float)((currentTime - createTime)/1000.0) <= lifeTime;
    }


    // this method returns true if this ammo teta is in the given range
    private boolean isTetaInRange(int start, int end)
    {
        return (teta >= start && teta < end);
    }
}