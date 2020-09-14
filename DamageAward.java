



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


            /*  Methods  */

    public void applyRewardToTank(Tank tankToApply) 
    {
        while(isAlive()) {
            tankToApply.getAmmo().setDamage(DataBase.getSettings().ammoDamage * 2);
        }
        tankToApply.getAmmo().setDamage(DataBase.getSettings().ammoDamage);

    }
}