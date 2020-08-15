



/**
 * This class represent a health reward in game 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.1
 */
public class HealthAward extends Award
{
            /*  Fields  */

    // amount of health that this reward given to tank
    private int health;






         /* Constructor */

    /**
     * Create a new health reward with given details
     * 
     * 
     * @param imageFilePath : address of reward image file
     * @param x : x of the reward
     * @param y : y of the reward
     * @param lifeTime : visibility time of this reward
     * @param health : amount of health that this award gives to tank
     */
    public HealthAward(String imageFilePath, float x, float y, float lifeTime, int health)
    {
        super(imageFilePath, x, y, lifeTime);
        this.health = health;
    }


    public void applyRewardToTank(Tank tankToApply) 
    {
        tankToApply.healthDelta(health);
    }
}