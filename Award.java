





/**
 * This abstract class is for common attributes of rewards
 * 
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.6
 */
public abstract class Award  extends Tile
{
            /*  Fields  */

   
    // time of visibility of this reward in map
    private float lifeTime = 5;

    // hold the creation time
    private long createTime;

    






         /* Constructor */

    /**
     * Create a new reward 
     */
    public Award()
    {
        super(0, 0, 30, 30, DataBase.getAward());

        int[] randomXandY = GameState.randomXandY();
        super.setX(randomXandY[0]);
        super.setY(randomXandY[1]);

        this.lifeTime = lifeTime;
        this.createTime = System.currentTimeMillis();
        draw();

    }







            /*  Methods  */
            
    /**
     * This method apply the reward to tank
     * 
     * 
     * @param tankToApply : tank to apply reward
     */
    public abstract void applyRewardToTank(Tank tankToApply);


    
     /**
      *  this method return true if award's life time not ended
     */
     public boolean isAlive()
     {
         long currentTime = System.currentTimeMillis();
 
         return (float)((currentTime - createTime)/1000.0) <= lifeTime;
 
     }
 

     /**
      * this method remove award from game playground
      */
     public void remove(){

        Main.getRootPlayGround().getChildren().remove(this);

    }
}