




/**
 * This class represent a normal ammo in game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.0.0
 */
public class NormalAmmo extends Ammo
{
            /*  Field  */

    // color of the ammo
    private String color;




    

         /* Constructor */

    public NormalAmmo(String color, float tankX, float tankY, float tankTeta)
    {
        super(DataBase.getAmmo(color, 'n'), tankX, tankY, tankTeta, 8, 18);
    }
}