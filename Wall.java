import javafx.scene.image.ImageView;

/**
 * <br>This class represent a wall in game.</br>
 * <br>Walls can reflect the {@link Ammo}s </br>
 * <br>{@link Tank}s can not moves over walls</br>
 * 

 * 
 * @author Mohammad Mahdi Malmasi
 * @author Sevda Imany
 * 
 * @version 0.0.6
 */
public class Wall extends Tile
{
         /* Constructor */

         // wall's imageView
         private ImageView imageView;

         //wall's x and y coordinates
         private int xCoordinate , yCoordinate;



    /**
     * Create a new wall with given details
     * 
     * 
     * @param imagePath : address of the wall image file
     * @param x : x of the wall
     * @param y : y of the wall
     */
    public Wall(float x, float y, float width, float height,String imagePath)
    {
        super(x,y,width,height,imagePath);

        xCoordinate = (int)x/45;
        yCoordinate = (int)y/45;

        imageView = new ImageView(super.getImage());

    }

    
    /** 
     * @return wall's x coordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @return wall's y coordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * @return wall's imageView
     */
    public ImageView getImageView() {
        return imageView;
    }

}