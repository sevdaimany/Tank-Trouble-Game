




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

         public NormalAmmo(String color, Tank tank)
         {
             super(DataBase.getAmmo(color, 's'), 8, 18 , tank);
         }
}