



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


    // ammo life time
    private float lifeTimeApply =15;

    // hold the creation time
    private long createTimeApply;


    private Tank tank;



            /*  Methods  */

    public void applyRewardToTank(Tank tankToApply) 
    {
        GameView.getAwardLable().setText("Damage award applied");

        tankToApply.setAmmoDamage(DataBase.getSettings().ammoDamage * 2);

        this.tank = tankToApply;
        createTimeApply = System.currentTimeMillis();

    }

    
    public void removeAward(){

        this.tank.setAmmoDamage(DataBase.getSettings().ammoDamage);
        GameView.getAwardLable().setText("");

    }

    
    public float getLifeTimeApply() {
        return lifeTimeApply;
    }

    public long getCreateTimeApply() {
        return createTimeApply;
    }
}