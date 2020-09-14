



/**
 * This class represent a health reward in game 
 * This award increase health of the tank
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.3
 */
public class HealthAward extends Award
{
     

            /*  Methods  */

    public void applyRewardToTank(Tank tankToApply) 
    {
        tankToApply.healthDelta((int)(DataBase.getSettings().tanksHealth * 0.1));

    }

}