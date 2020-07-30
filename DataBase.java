import java.io.*;
import java.util.*;



/**
 * This class manage game's file and data
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.2.1
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


    /**
     * This method save a {@code Player} object in file
     * 
     * 
     * @param playerToSave : player that you want save it
     * @throws IOException : if can't open file
     * 
     * @see DataBase#savePlayers(List)
     */
    public static void savePlayer(Player playerToSave) throws IOException
    {
        ObjectOutputStream playerFile = new ObjectOutputStream(
                                        new FileOutputStream(
                                        new File(PLAYERS_FOLDER + playerToSave.getUsername() + PLAYER_FILE_FORMAT)));
                                         
        playerFile.writeObject(playerToSave);
        playerFile.close();
    }


    /**
     * This method gives a {@code List} of players and save them
     * 
     * 
     * @param playersToSave : a {@code List} of players to save
     * @throws IOException : if can't open file
     * 
     * @see DataBase#savePlayer(Player)
     */
    public static void savePlayers(List<Player> playersToSave) throws IOException
    {
        for (Player player: playersToSave)
            savePlayer(player);
    }
}