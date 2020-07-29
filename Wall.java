import java.io.File;





/**
 * <br>This class represent a wall in game.</br>
 * <br>Walls can reflect the {@link Ammo}s </br>
 * <br>{@link Tank}s can not moves over walls</br>
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Wall 
{
            /*  Fields  */

    // image file of the wall
    private File image;

    // wall cordite (center of the wall)
    private int x, y;

    // length of the wall
    private int length;

    // horizontal(= true) or vertical(= false)
    private boolean state;









         /* Constructor */

    /**
     * Create a new wall with given details
     * 
     * 
     * @param imagePath : address of the wall image file
     * @param x : x of the wall
     * @param y : y of the wall
     * @param state : set it 'H' for horizontal or 'V' for vertical
     */
    public Wall(String imagePath, int x, int y, char state)
    {
        this.image = new File(imagePath);

        this.x = x;
        this.y = y;

        this.state = (Character.toLowerCase(state) == 'h');
    }
}