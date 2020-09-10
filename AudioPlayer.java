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


    // clip object of the given file
    private Clip soundEffect;







         /* Constructor */

    /**
     * Create a new Audio Player which just plays the given file
     * 
     * 
     * @param filePath : file that you want to play it
     * @throws Exception if can't open the file
     */
    public AudioPlayer(String filePath) throws Exception
    {
        AudioInputStream in = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        soundEffect = AudioSystem.getClip();
        soundEffect.open(in);
    }









            /*  Methods  */

    /**
     * This method plays the file
     */
    public void playFile()
    {
        if (!isMute)
            soundEffect.start();
    }


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
