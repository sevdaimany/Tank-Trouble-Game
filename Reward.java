import java.io.File;





/**
 * This abstract class is for common attributes of rewards
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public abstract class Reward 
{
            /*  Fields  */

    // image file of this reward
    private File image;

    // reward cordite
    private int x, y;

    // time of visibility of this reward in map
    private float lifeTime;







         /* Constructor */

    /**
     * Create a new reward with given details
     * 
     * 
     * @param imageFilePath : address of reward image file
     * @param x : x of the reward
     * @param y : y of the reward
     * @param lifeTime : visibility time of this reward
     */
    public Reward(String imageFilePath, int x, int y, float lifeTime)
    {
        image = new File(imageFilePath);

        this.x = x;
        this.y = y;

        this.lifeTime = lifeTime;
    }
}