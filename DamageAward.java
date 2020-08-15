



/**
 * This class represent a damage award in game
 * This award increase the damage of the tank's ammo
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class DamageAward extends Award
{
            /*  Fields  */

    // amount of damage to give tank's ammos
    private int damage;








         /* Constructor */

    /**
     * Create a new damage reward with given details
     * 
     * 
     * @param imageFilePath : address of reward image file
     * @param x : x of the reward
     * @param y : y of the reward
     * @param lifeTime : visibility time of this reward
     * @param damage : new damage to give to the tanks
     */
    public DamageAward(String imageFilePath, float x, float y, float lifeTime, int damage) 
    {
        super(imageFilePath, x, y, lifeTime);
        this.damage = damage;
    }







            /*  Methods  */

    public void applyRewardToTank(Tank tankToApply) 
    {
        
    }
}