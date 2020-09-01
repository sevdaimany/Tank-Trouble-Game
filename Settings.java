import java.io.Serializable;



/**
 * This class holds game settings fields
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.2
 */
public final class Settings implements Serializable
{
            /*  Fields  */

    // tank's health
    int tanksHealth;

    // woody walls health
    int woodWallsHealth;

    // damage of the ammos
    int ammoDamage;

    // life time of the ammos
    float ammosLifeTime;


    private static final long serialVersionUID = 3076892867441666860L;
}