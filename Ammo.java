import java.security.Principal;

import javafx.scene.image.ImageView;

/**
 * This class represent an Ammo for Tank in game
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.9.0
 */
public class Ammo extends Tile
{
            /*  Fields  */


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

    //ammo's tank
    private  Tank tank;








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
        this.tank = tank;


        imageView = new ImageView(super.getImage());
        Main.getRootPlayGround().getChildren().add(imageView);


        this.ammoMoveSpeed = 1;

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
     * @return ammo's imageView
     */
    public ImageView getImageView() { return imageView; }
    /**
     * @return the life time of the ammo
     */
    public float getLifeTime() { return lifeTime; }

    /**
     * @return ammo's tank
     */
    public Tank getTank() {   return tank;  }


    /**
     * @param tank
     */
    public void setTank(Tank tank) {
        this.tank = tank;
    }

   


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
        // set teta
        if (this.teta < 0)
            teta = (teta % 360) + 360;
        else
            teta = teta % 360;

        
        if (teta%90 == 0)
        {
            teta += 360;

            return;
        }

        
        if (isTetaInRange(0, 90))
        {
            if (ammoMoveSpeed < 0)
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 180 - teta;
                    break;

                    case 'h':
                        teta = 360 - teta;
                    break;
                }
            }
            else
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 360 - teta;
                        ammoMoveSpeed *= -1;
                    break;

                    case 'h':
                        teta = 180 - teta;
                        ammoMoveSpeed *= -1;
                    break;
                }
            }


            return;
        }

        if (isTetaInRange(90, 180))
        {
            if (ammoMoveSpeed < 0)
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 180 - teta;
                    break;

                    case 'h':
                        teta = 180 + (180 - teta);
                    break;
                }
            }
            else
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 180 + (180 - teta);
                        ammoMoveSpeed *= -1;
                    break;

                    case 'h':
                        teta = 180 - teta;
                        ammoMoveSpeed *= -1;
                    break;
                }
            }


            return;
        }

        if (isTetaInRange(180, 270))
        {
            if (ammoMoveSpeed < 0)
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 90 + (90 - (teta % 90));
                        ammoMoveSpeed *= -1;
                    break;

                    case 'h':
                        teta = 90 + (90 - (teta % 90));
                    break;
                }
            }
            else
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 180 - (teta - 180);
                        ammoMoveSpeed *= -1;
                    break;

                    case 'h':
                        teta = 180 - (teta - 180);
                    break;
                }
            }


            return;
        }

        if (isTetaInRange(270, 360))
        {
            if (ammoMoveSpeed < 0)
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 180 + (90 - (teta % 90));
                    break;

                    case 'h':
                        teta = 90 - (teta % 90);
                    break;
                }
            }
            else
            {
                switch (howHited(wall))
                {
                    case 'v':
                        teta = 360 - teta;
                        ammoMoveSpeed *= -1;
                    break;

                    case 'h':
                        teta = 180 + (360 - teta);
                        ammoMoveSpeed *= -1;
                    break;
                }
            }
        }
    }




    

    // this method calculate the x of the ammo
    private double calculateX(double tankX, float tankTeta)
    {
 
        float teta = (tankTeta % 360 + 360) % 360;
        
        float x_delta2 = 0;
        float x_delta = 0;

        if(teta >= 270 && teta < 360) {
             x_delta2 = -1 * (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 9;
             x_delta = -1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 10;
        }
        else if ( teta > 0 && teta < 90 ){
            x_delta2 =   (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 9;
            x_delta =  -1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 11;
        }
        else if ( teta >= 90 && teta < 180 ){
            x_delta2 =   (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 9;
            x_delta =   -1 *(float) Math.cos(Math.toRadians(90 - tankTeta)) * 12;
        }
        else if ( teta > 180 && teta < 270 ){
            x_delta2 = -1 *  (float) Math.signum(Math.cos(Math.toRadians(90 - tankTeta))) * 9;
            x_delta  =-1 * (float) Math.cos(Math.toRadians(90 - tankTeta)) * 12;
        }


        
        if( teta == 180 || teta == 0)
            x_delta +=  8;


        return tankX + x_delta2  + x_delta ;
    }


    // this method calculate the y of the ammo
    private double calculateY(double tankY, float tankTeta)
    {

        float teta = (tankTeta % 360 + 360) % 360;


        float y_delta2 = 0;
        float y_delta = 0;

        if(teta > 270 && teta < 360) {
             y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 9;
             y_delta = (float) Math.sin(Math.toRadians(90 - tankTeta)) * 10;
        }

        else if ( teta >= 0 && teta < 90 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 9;
            y_delta = (float) Math.sin(Math.toRadians(90 - tankTeta)) * 11;
        }

        else if ( teta > 90 && teta < 180 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 9;
            y_delta =  (float) Math.cos(Math.toRadians(90 - tankTeta)) *  8;
        }

        else if ( teta >= 180 && teta < 270 ) {
            y_delta2 = (float) Math.signum(Math.sin(Math.toRadians(90 - tankTeta))) * 9;
            y_delta =  -1 *(float) Math.cos(Math.toRadians(90 - tankTeta)) *  8;
        }


        if( teta == 90  || teta == 270){
            y_delta += 7;
        }



        return tankY +  y_delta2  +y_delta;
    }


    //this method draw an ammo in game playground
    public void draw()
    {
        if (!isAlive()) {
            GameState.getFiredAmmos().remove(this);
            Main.getRootPlayGround().getChildren().remove(imageView);
            return;
        }

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


    // this method return the case of hit
    private char howHited(Wall wall)
    {
        int xDelta = (int)Math.abs(getX() - wall.getxCoordinate() * 45 - 22.5 );
        int yDelta = (int)Math.abs(getY() - wall.getyCoordinate() * 45 - 22.5);


        if (yDelta < xDelta)
            return 'v';

        return 'h';
    }
}