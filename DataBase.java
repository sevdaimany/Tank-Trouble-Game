import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * This class manage game's file and data
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.1
 */
public class DataBase
{
            /*  Fields  */

    // path of the main folder of files
    private static final String MAIN_FOLDER = "./.TANK_TROUBLE_DATA_BASE/";

    // path of the players data folder
    private static final String PLAYERS_FOLDER = MAIN_FOLDER + "PLAYERS/";
    private static final String PLAYER_FILE_FORMAT = ".plyr";

    // path of the photos folder
    private static final String PHOTOS_FOLDER = MAIN_FOLDER + "PHOTOS/";
    private static final String TANK_IMAGES = PHOTOS_FOLDER + "TANKS/";
    private static final String GROUND_IMAGES = PHOTOS_FOLDER + "GROUNDS/";
    private static final String WALL_IMAGES = PHOTOS_FOLDER + "WALLS/";
    private static final String AMMO_IMAGES = PHOTOS_FOLDER + "AMMOS/";
    private static final String AWARD_IMAGES = PHOTOS_FOLDER + "AWARDS/";










            /*  Methods  */

    /**
     * This method checks that is there any player with given username or not
     * 
     * 
     * @param usernameToCheck : nwe username to check
     * @return {@code true} if there is any player with the same username. 
     * 
     * @throws IOException if can not open players object file
     */
    public static boolean isRegistered(String usernameToCheck) throws IOException
    {
        File players = new File(PLAYERS_FOLDER);


        ObjectInputStream ois = null; 
        Player holdToCheck = null;
        for (File player : players.listFiles())
        {
            ois = new ObjectInputStream(new FileInputStream(player));


            try{ holdToCheck = (Player) ois.readObject(); }
            catch (ClassNotFoundException e) {holdToCheck = null; }
            finally { ois.close(); }

            if (holdToCheck.getUsername().equals(usernameToCheck))
                return true;
        }


        return false;
    }
}