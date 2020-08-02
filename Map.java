import java.util.ArrayList;




/**
 * This class holds the required details of game map
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class Map 
{
            /*  Fields  */

    // address of the image file for map ground
    private String groundImagePath;

    // a list of map walls
    private ArrayList<Wall> walls;








         /* Constructor */

    /**
     * Create a new map with given image file
     * 
     * 
     * @param mapGroundImagePath : address of the image file for ground
     */
    public Map(String mapGroundImagePath)
    {
        this.groundImagePath = mapGroundImagePath;
        walls = new ArrayList<>();
    }
}