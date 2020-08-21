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

         private ImageView imageView;


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
        imageView = new ImageView(super.getImage());

    }

    public ImageView getImageView() {
        return imageView;
    }

}