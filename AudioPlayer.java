import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;





/**
 * This class is a simple audio file player
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.3.2
 */
public class AudioPlayer 
{
            /*  Fields  */

    // is game mute or not
    private static boolean isMute = false;







  






            /*  Methods  */

    

    /**
     * This method mute the game sound
     */
    public static void mute()
    {
        isMute = true;
    }


    /**
     * This method un mute the game sound
     */
    public static void unMute()
    {
        isMute = false;
    }
}
