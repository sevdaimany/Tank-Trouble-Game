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

  
     /**
     * this method play ammo's reflection sound
     */
    public static void ammoReflectionSound(){
        if(!isMute) {
            try {
                AudioInputStream in = AudioSystem.getAudioInputStream(new File(DataBase.getAmmoReflectionSound()).getAbsoluteFile());
                Clip soundEffect = AudioSystem.getClip();
                soundEffect.open(in);
                soundEffect.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


     /**
     * this method play tank's explosion sound
     */
    public static void tankExplosionSound() {
        if(!isMute) {
            try {
                AudioInputStream in = AudioSystem.getAudioInputStream(new File(DataBase.getTankExplosionSound()).getAbsoluteFile());
                Clip soundEffect = AudioSystem.getClip();
                soundEffect.open(in);
                soundEffect.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


     /**
     * this method play wall's explosion sound
     */
    public static void wallExplosionSound() {
        if(!isMute) {
            try {
                AudioInputStream in = AudioSystem.getAudioInputStream(new File(DataBase.getWallExplosionSound()).getAbsoluteFile());
                Clip soundEffect = AudioSystem.getClip();
                soundEffect.open(in);
                soundEffect.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
