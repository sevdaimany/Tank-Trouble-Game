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






    /**
     * this method play fired ammo's sound
     */
    public static void fireSound() {
        if(!isMute) {
            try {
                AudioInputStream in = AudioSystem.getAudioInputStream(new File(DataBase.getFireSound()).getAbsoluteFile());
                Clip soundEffect = AudioSystem.getClip();
                soundEffect.open(in);
                soundEffect.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

  






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
