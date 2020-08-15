





/**
 * This abstract class is for common attributes of rewards
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.6
 */
public abstract class Award 
{
            /*  Fields  */

    // address of image file of this reward
    private String imagePath;

    // reward cordite
    private float x, y;

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
    public Reward(String imageFilePath, float x, float y, float lifeTime)
    {
        imagePath = imageFilePath;

        this.x = x;
        this.y = y;

        this.lifeTime = lifeTime;
    }







            /*  Methods  */
            
    /**
     * This method apply the reward to tank
     * 
     * 
     * @param tankToApply : tank to apply reward
     */
    public abstract void applyRewardToTank(Tank tankToApply);
}