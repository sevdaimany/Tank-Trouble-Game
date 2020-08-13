import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;




/**
 * This class manage game's file and data
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.11.0
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


    // available tank colors
    private static final String[] tanksColors = {"white", "black", "blue", 
                                                 "green", "sand", "orange", 
                                                 "red", "yellow", "pink", 
                                                 "purple", "gray"};


    // path of the icons
    private static final String ICONS_FOLDER = MAIN_FOLDER + "ICONS/";
    private static final String INFO_ICON = ICONS_FOLDER + "info.png";
    private static final String BACKGROUND_ICON = ICONS_FOLDER + "background.jpg";
    private static final String SETTING_ICON = ICONS_FOLDER + "setting.png";
    private static final String REGISTER_ICON = ICONS_FOLDER + "register.png";
    private static final String LEADERBOARDS_ICON = ICONS_FOLDER + "leaderboards.png";
    private static final String ONE_PLAYER_ICON = ICONS_FOLDER + "onePlayerMode.png";
    private static final String TWO_PLAYERS_ICON = ICONS_FOLDER + "twoPlayerMode.png";
    private static final String THREE_PLAYERS_ICON = ICONS_FOLDER + "threePlayerMode.png";
    private static final String SERVER_MODE_ICON = ICONS_FOLDER + "serverMode.png";
    private static final String GO_BACK_ICON = ICONS_FOLDER + "goBack.png";
    private static final String LOGO_IMAGE = ICONS_FOLDER + "logo.png";
    private static final String MOUSE_IMAGE = ICONS_FOLDER + "mouse.png";
    private static final String WSAD_KEYS_IMAGE = ICONS_FOLDER + "wasd.png";
    private static final String UpDown_KEYS_IMAGE = ICONS_FOLDER + "updown.png";
    private static final String Q_BUTTON_IMAGE = ICONS_FOLDER + "q.png";
    private static final String M_BUTTON_IMAGE = ICONS_FOLDER + "m.png";


    

    // * download links *

    private static final String GITHUB_SERVER = "https://raw.githubusercontent.com/sevdaimany/Tank-Trouble-Game/master/";
    
    private static final String infoIconLink = GITHUB_SERVER + INFO_ICON;
    private static final String backgroundIconLink = GITHUB_SERVER + BACKGROUND_ICON;
    private static final String settingIconLink = GITHUB_SERVER + SETTING_ICON;
    private static final String registerIconLink = GITHUB_SERVER + REGISTER_ICON;
    private static final String leaderboardsIconLink = GITHUB_SERVER + LEADERBOARDS_ICON;
    private static final String onePlayerIconLink = GITHUB_SERVER + ONE_PLAYER_ICON;
    private static final String twoPlayersIconLink = GITHUB_SERVER + TWO_PLAYERS_ICON;
    private static final String threePlayersIconLink = GITHUB_SERVER + THREE_PLAYERS_ICON;
    private static final String serverModeIconLink = GITHUB_SERVER + SERVER_MODE_ICON;
    private static final String goBackIconLink = GITHUB_SERVER + GO_BACK_ICON;
    private static final String logoImageLink = GITHUB_SERVER + LOGO_IMAGE;
    private static final String mouseImageLink = GITHUB_SERVER + MOUSE_IMAGE;
    private static final String wsadKeysImageLink = GITHUB_SERVER + WSAD_KEYS_IMAGE;
    private static final String updownKeysImageLink = GITHUB_SERVER + UpDown_KEYS_IMAGE;
    private static final String qButtonImageLink = GITHUB_SERVER + Q_BUTTON_IMAGE;
    private static final String mButtonImageLink = GITHUB_SERVER + M_BUTTON_IMAGE;

    private static final String tanksGithubLink = GITHUB_SERVER + TANK_IMAGES;

    private static final String wallsGithubLink = GITHUB_SERVER + WALL_IMAGES;



    // hold all folders path
    private static final ArrayList<String> folders = new ArrayList<>(
                                                        Arrays.asList(
                                                            MAIN_FOLDER, PHOTOS_FOLDER, 
                                                            ICONS_FOLDER, PLAYERS_FOLDER,
                                                            TANK_IMAGES, GROUND_IMAGES,
                                                            WALL_IMAGES, AMMO_IMAGES,
                                                            AWARD_IMAGES));


    private static final ArrayList<String> iconsDownloadLinks = new ArrayList<>(
                                                                   Arrays.asList(
                                                                       infoIconLink, backgroundIconLink,
                                                                       settingIconLink, registerIconLink,
                                                                       leaderboardsIconLink, goBackIconLink,
                                                                       onePlayerIconLink, twoPlayersIconLink,
                                                                       threePlayersIconLink, serverModeIconLink,
                                                                       logoImageLink, mouseImageLink, qButtonImageLink,
                                                                       wsadKeysImageLink, updownKeysImageLink, mButtonImageLink
                                                                   ));
    // for create random numbers
    private static final Random rand = new Random();










            /*  Methods  */

    /**
     * This method is a kind of constructor for this class
     * This method makes all specific files and folders of the game
     */
    public static void init()
    {
        File holdToMake;
        for (String folder: folders)
        {
            holdToMake = new File(folder);
            holdToMake.mkdirs();
        }


        downloadIcons();
        downloadTanks();
        downloadWalls();
    }


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
    /**
     * @return path of the logo image 
     */
    public static String getLogoImage() { return LOGO_IMAGE; }
    /**
     * @return path of the mouse image 
     */
    public static String getMouseImage() { return MOUSE_IMAGE; }
    /**
     * @return path of the wsad keys image 
     */
    public static String getWsadKeysImage() { return WSAD_KEYS_IMAGE; }
    /**
     * @return path of the up & down keys image 
     */
    public static String getUpdownKeysImage() { return UpDown_KEYS_IMAGE; }
    /**
     * @return path of the q button image 
     */    
    public static String getQButtonImage() { return Q_BUTTON_IMAGE; }
    /**
     * @return path of the m button image
     */
    public static String getMButtonImage() { return M_BUTTON_IMAGE; }



    // * ground files getter *

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



    // * walls getter *

    /**
     * This method return the path of the wall image file
     * 
     * @param kind : 'wood' or 'metal'
     * @return {@code null} if your given kind is invalid
     */
    public static String getWallImageFilePath(String kind)
    {
        if (kind.equalsIgnoreCase("wood"))
            return WALL_IMAGES + "woodWall.png";

        else if (kind.equalsIgnoreCase("metal"))
            return WALL_IMAGES + "metalWall.png";

        else 
            return null;
    }







    // return the path of the file of the player with given username
    private static String getPlayerPath(String username)
    {
        return PLAYERS_FOLDER + username + PLAYER_FILE_FORMAT;
    }


    // this method downloads file from given link and save it to given file address
    private static void downloader(String downloadLink, String saveLocation, String fileName)
    {
        URL url = null;
        try { url = new URL(downloadLink); }
        catch (MalformedURLException e) {}

        HttpURLConnection connection = null;
        try{ connection = (HttpURLConnection) url.openConnection(); }
        catch (IOException e) {}

        try{ connection.setRequestMethod("GET"); }
        catch (ProtocolException | SecurityException e) { return; }

        try { connection.connect(); }
        catch (IOException e) {}

        InputStream in = null;
        try { in = connection.getInputStream(); }
        catch (IOException e) {}


        try ( FileOutputStream out = new FileOutputStream(new File(saveLocation, fileName)) )
        {
            out.write(in.readAllBytes());
        }
        catch (IOException | NullPointerException e) {System.out.println(e.getLocalizedMessage());}

        connection.disconnect();
    }


    // this method returns the file name from given link
    private static String getFileNameFromLink(String link)
    {
        String[] hold = link.split("/");
        link = hold[hold.length-1];

        return link;
    }


    // this method downloads icon files
    private static void downloadIcons()
    {
        for (String link: iconsDownloadLinks)
        {
            if (!isFileAvailable(ICONS_FOLDER + getFileNameFromLink(link)))
                downloader(link, ICONS_FOLDER, getFileNameFromLink(link));
        }
    }


    // this method download tanks files
    private static void downloadTanks()
    {
        for (String color: tanksColors)
            for (int i = 1; i <= 4; i++)
                if (!isFileAvailable(TANK_IMAGES + color + "Tank_kind" + i + ".png"))
                   downloader(tanksGithubLink, TANK_IMAGES, color + "Tank_kind" + i + ".png");

    }


    // this method download walls files
    private static void downloadWalls()
    {
        if (!isFileAvailable(WALL_IMAGES + "metalWall.png"))
            downloader(wallsGithubLink + "metalWall.png", WALL_IMAGES, "metalWall.png");


        if (!isFileAvailable(WALL_IMAGES + "woodWall.png"))
            downloader(wallsGithubLink + "woodWall.png", WALL_IMAGES, "woodWall.png");
    }


    // this method checks that the given file is available or not
    private static boolean isFileAvailable(String path)
    {
        try ( FileInputStream fis = new FileInputStream(new File(path)) ) 
        {
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }
}