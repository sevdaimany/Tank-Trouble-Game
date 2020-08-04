import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;



/**
 * This class manage game's file and data
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.7.3
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

    // path of the icons
    private static final String ICONS_FOLDER = MAIN_FOLDER + "ICONS/";
    private static final String INFO_ICON = ICONS_FOLDER + "info.png";
    private static final String BACKGROUND_ICON = ICONS_FOLDER + "background.jpg";
    private static final String SETTING_ICON = ICONS_FOLDER + "setting.png";
    private static final String REGISTER_ICON = ICONS_FOLDER + "register.png";
    private static final String LEADERBOARDS_ICON = ICONS_FOLDER + "leaderboards.png";
    private static final String ONE_PLAYER_ICON = ICONS_FOLDER + "onePlayerMode.png";
    private static final String TWO_PLAYERS_ICON = ICONS_FOLDER + "twoPlayersMode.png";
    private static final String THREE_PLAYERS_ICON = ICONS_FOLDER + "threePlayersMode.png";
    private static final String SERVER_MODE_ICON = ICONS_FOLDER + "serverMode.png";
    private static final String GO_BACK_ICON = ICONS_FOLDER + "goBack.png";


    // for create random numbers
    private static final Random rand = new Random();










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
            catch (ClassNotFoundException e) { holdToCheck = null; }
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


    /**
     * This method return the {@code Player} object of given username
     * 
     * 
     * @param username : username of the player that you want
     * @return {@code Player} of given username
     * 
     * @throws IOException if can not open player file
     */
    public static Player getPlayer(String username) throws IOException
    {
        ObjectInputStream player = new ObjectInputStream(new FileInputStream(new File(getPlayerPath(username))));


        try { return (Player) player.readObject(); }
        catch (ClassNotFoundException e) { return null; }
        finally { player.close(); }
    }


    /**
     * This method checks the given password and username
     * 
     * 
     * @param username
     * @param password
     * 
     * @return {@code true} if username and password are ok
     * 
     * @throws IOException if can not open file
     */
    public static boolean isPasswordCorrect(String username, String password) throws IOException
    {
        Player player = getPlayer(username);
        return player.isPasswordCorrect(password);
    }




    // * icon files getters *

    /**
     * @return path of the info icon image
     */
    public static String getInfoIconPath() { return INFO_ICON; }
    /**
     * @return path of the background icon image
     */
    public static String getBackgroundIconPath() { return BACKGROUND_ICON; }
    /**
     * @return path of the setting icon image
     */
    public static String getSettingIconPath() { return SETTING_ICON; }
    /**
     * @return path of the register icon image
     */
    public static String getRegisterIconPath() { return REGISTER_ICON; }
    /**
     * @return path of the leaderboards icon image
     */
    public static String getLeaderboardsIconPath() { return LEADERBOARDS_ICON; }
    /**
     * @return path of the one player mode icon image
     */
    public static String getOnePlayerIconPath() { return ONE_PLAYER_ICON; }
    /**
     * @return path of the two player mode icon image
     */
    public static String getTwoPLAyersIconPath() { return TWO_PLAYERS_ICON; }
    /**
     * @return path of the three player mode icon image
     */    
    public static String getThreePlayersIconPath() { return THREE_PLAYERS_ICON; }
    /**
     * @return path of the server mode icon image
     */
    public static String getServerModeIconPath() { return SERVER_MODE_ICON; }
    /**
     * @return path of the back button icon image
     */
    public static String getGoBackIcon() { return GO_BACK_ICON; }



    // * ground files getters *

    /**
     * Get path of ground image files
     * there are to kind of ground image: 1. grass,  2. sand
     * 
     * 
     * @param which : with kind of ground do you want? (grass or sand)
     * @return path of the image file. return {@code null} if your given kind is invalid
     */
    public static String getGroundImageFilePath(String which)
    {
        which = which.toLowerCase();

        if (!(which.equals("grass") || which.equals("sand")))
            return null;


        return PHOTOS_FOLDER + GROUND_IMAGES + which + "Ground" + (rand.nextInt()%2 + 1) + ".png";
    }







    // return the path of the file of the player with given username
    private static String getPlayerPath(String username)
    {
        return PLAYERS_FOLDER + username + PLAYER_FILE_FORMAT;
    }


    // this method downloads file from given link and save it to given file address
    private static void downloader(String downloadLink, String saveLocation, String fileName)
    {
        URL url;
        try { url = new URL(downloadLink); }
        catch (MalformedURLException e) {}

        HttpURLConnection connection;
        try{ connection = (HttpURLConnection) url.openConnection(); }
        catch (IOException e) {}

        try{ connection.setRequestMethod("GET"); }
        catch (ProtocolException | SecurityException e) { return; }

        try { connection.connect(); }
        catch (IOException e) {}

        InputStream in;
        try { in = connection.getInputStream(); }
        catch (IOException e) {}


        try ( FileOutputStream out = new FileOutputStream(new File(saveLocation, fileName)) )
        {
            out.write(in.readAllBytes());
        }
        catch (IOException e) {}
    }
}