import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;




/**
 * This class holds and update the state of the game
 * 
 * 
 * @author Mohammad Mahdi Malmasi
 * @author Sevda Imany
 * 
 * @version 0.6.0
 */
public class GameState 
{
            /* Fields */

    // players of the game
    private static ArrayList<Player> players;

    // tank of players
    private static ArrayList<Tank> tanks;

    // fired ammos from tanks
    private static List<Ammo> firedAmmos;

    // walls of the map
    private static ArrayList<Wall> walls ;

    //game awards
    private static List<Award> awards;

    // playing controllers
    private static ArrayList<PlayingController> playingControllers;

    //list of protected tanks
    private static ArrayList<Tank> protectedTanks;

    //list of damageAward awards
    private static List<DamageAward> poweredAmmoAward;

    //list of protecterAward awards
    private static  List<ProtecterAward> protectedAward;


    //width of game's playground    
    private static double widthPLayGround;

    //height of game's playground
    private static double heightPLayGround;

    //explosion imageView's array
   private static ImageView[] slides;

   //tank and progressbar hashmap
   private static HashMap<Tank, ProgressBar> tankProgressBar = new HashMap<>();












            /* Methods */

    /**
     * This method is a kind of constructor for this class
     */
    public static void init() 
    {
        keyholder();
    }


    /**
     * this method new lists in game
     */
    public  static void  newFields(){
        players = new ArrayList<>();
        tanks = new ArrayList<>();
        awards = new CopyOnWriteArrayList<>();
        firedAmmos = new CopyOnWriteArrayList<>();
        playingControllers = new ArrayList<>();
        protectedTanks = new ArrayList<>();
        poweredAmmoAward = new CopyOnWriteArrayList<>();
        protectedAward = new CopyOnWriteArrayList<>();

    }

    /**
     * this method new walls arraylist
     */
    public static  void newWalls(){
        walls = new ArrayList<>();
   }


    /**
     * This method updates the state of the game
     */
    public static void updateStates()
    {
        updateTankState();
        updateFiredAmmosState();
        updateAwardsState();
    }


    /**
     * This method add a new player to game
     * 
     * @param player : new player to add
     */
    public static void addPlayer(Player player) 
    {
        players.add(player);
        tanks.add(player.getPlayerTank());
    }


    /**
     * This method add the given ammo to the fired ammo list
     * 
     * @param ammo : ammo to add
     */
    public static void addFiredAmmo(Ammo ammo)
    {
        firedAmmos.add(ammo);
    }


    /**
     * The method which updates the tanks state.
     */
    public static void updateTankState() 
    {
        for (PlayingController controller : playingControllers)
            controller.updateTankState();

        
         for (Tank tank: tanks){
              tank_Award_Intersect(tank);
          }
    }

    
    /**
     * this method updated awards state
     */
    public static void updateAwardsState(){
        for(Award award : awards){
            if(!award.isAlive()){
                awards.remove(award);
                award.remove();
            }
        }

    }

    /**
     * This method updates fired ammos state
     */
    public static void updateFiredAmmosState()
    {
        for (Ammo ammo: firedAmmos){ 
            ammo.move();
            if(ammo_WoodWall_intersect(ammo)) {
                firedAmmos.remove(ammo);
                Main.getRootPlayGround().getChildren().remove(ammo.getImageView());

            }

            Wall hitedWall = ammo_Wall_intersect(ammo);
            if (hitedWall != null){
                ammo.hit(hitedWall);
                ammo.setTank(null);
            }

            Tank hitedTank = ammo_Tank_intersect(ammo);
            if(hitedTank != null &&  hitedTank != ammo.getTank()){

                if(!protectedTanks.contains(hitedTank)){
                    hitedTank.reduceHealth(hitedTank.getAmmoDamage());
                    tankProgressBar.get(hitedTank).setProgress((double) hitedTank.getHealth()/DataBase.getSettings().tanksHealth);
                }

                firedAmmos.remove(ammo);
                Main.getRootPlayGround().getChildren().remove(ammo.getImageView());
               
            }

        }
    }


    /**
     * The keyboard handler.
     */
    public static void keyholder() 
    {
        Main.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (PlayingController controller : playingControllers) {
                    controller.keyPressEvent(event.getCode());
                }
            }
        });

        Main.getStage().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (PlayingController controller : playingControllers) {
                    controller.keyReleasedEvent(event.getCode());
                }
            }
        });
    }


    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Tank> getTanks() {
        return tanks;
    }

    public static List<Award> getAwards() {
        return awards;
    }

    public static List<Ammo> getFiredAmmos() {
        return firedAmmos;
    }

    public static ArrayList<PlayingController> getPlayingControllers() {
        return playingControllers;
    }


    public static ArrayList<Tank> getProtectedTanks() {
        return protectedTanks;
    }

    public static List<DamageAward> getPoweredAmmoAward() {
        return poweredAmmoAward;
    }

    public static List<ProtecterAward> getProtectedAward() {
        return protectedAward;
    }
    

    public static ArrayList<Wall> getWalls() {
        return walls;
    }

    public static double getWidthPLayGround() {
        return widthPLayGround;
    }

   
    public static double getHeightPLayGround() {
        return heightPLayGround;
    }


    public static HashMap<Tank, ProgressBar> getTankProgressBar() {
        return tankProgressBar;
    }

    public static void setHeightPLayGround(double heightPLayGround) {
        GameState.heightPLayGround = heightPLayGround;
    }


    public static void setWidthPLayGround(double widthPLayGround) {
        GameState.widthPLayGround = widthPLayGround;
    }



    public static Boolean intersect(Rectangle tile , Rectangle tile2) {
        if (tile.getBoundsInParent().intersects(tile2.getBoundsInParent()))
            return true;
        return false;
    }


    public static boolean tank_Wall_OtherTank_intersect(Rectangle tankRectangle,Tank thisTank){

        for (Wall wall : GameState.getWalls()) {
            if (intersect(tankRectangle , wall)) {
                return true;
            }

        }

        for(Tank tank : GameState.getTanks()){
            if(tank == thisTank)
                continue;
            else{
                if(intersect(tankRectangle , tank)){
                    return  true;
                }
            }
        }


            return false;
    }



    public static void tank_Award_Intersect(Tank tank){
        for(Award award : awards){
            if(intersect(tank,award)){
                award.applyRewardToTank(tank);
                awards.remove(award);
                award.remove();

                if(award instanceof DamageAward){
                    poweredAmmoAward.add((DamageAward) award);
                }
                else if(award instanceof ProtecterAward){
                    protectedAward.add((ProtecterAward) award);
                }
            }
        }
    }


    public static boolean ammo_WoodWall_intersect(Rectangle ammoRectangle){

        for (Wall wall : GameState.getWalls()) {
            if (wall instanceof WoodWall) {
                WoodWall woodWall = (WoodWall) wall;
                if (intersect(ammoRectangle, woodWall)) {
                        TileGrid.setTile(woodWall.getxCoordinate() , woodWall.getyCoordinate());
                        walls.remove(woodWall);
                        return true;

                }

            }

        }
        return false;

    }


    public static Wall ammo_Wall_intersect(Rectangle ammoRectangle){

        for (Wall wall : GameState.getWalls()) {
            if(!(wall instanceof WoodWall)){
                if (intersect(ammoRectangle , wall)) {
                    AudioPlayer.ammoReflectionSound();
                    return wall;
                }

            }
        }

        return null;
    }


    /**
     * this method check if the given ammo hit a tank or not
     * @param ammoRectangle
     * @return hitedTank if ammo hit any , otherwise return null
     */
    public static Tank ammo_Tank_intersect(Rectangle ammoRectangle){

        for (Tank tank : GameState.getTanks()) {
                if (intersect(ammoRectangle , tank)) {
                    return tank;
                }
            }


        return null;
    }



    public static void simpleSlideShow(double x, double y) {
        slides = new ImageView[10];
        String[] smoke = DataBase.getFireExplosion("smoke");
        String[] fire = DataBase.getFireExplosion("fire");

        int j =0 ;
        for(int i = 0 ; i < 5 ; i++){
            FileInputStream input = null;

            try { input = new FileInputStream(smoke[i]); }
            catch (FileNotFoundException e) { e.printStackTrace(); }


            int imageSize = 45;
            Image image = new Image(input , imageSize, imageSize,false,false);


            FileInputStream input2= null;

            try { input2 = new FileInputStream(fire[i]); }
            catch (FileNotFoundException e) { e.printStackTrace(); }


            Image image2 = new Image(input2 , imageSize, imageSize,false,false);

            slides[j] = new ImageView(image2);
            slides[j].relocate(x,y);

            j++;

            slides[j] = new ImageView(image);
            slides[j].relocate(x,y);

            j++;

        }
    }

    public static FadeTransition getFadeTransition(ImageView imageView, double fromValue, double toValue, int durationInMilliseconds) {

        FadeTransition ft = new FadeTransition(Duration.millis(durationInMilliseconds), imageView);
        ft.setFromValue(fromValue);
        ft.setToValue(toValue);

        return ft;

    }

    public static void explosion(double x ,double y) {

        simpleSlideShow(x, y);

        SequentialTransition slideshow = new SequentialTransition();

        for (ImageView slide : slides) {

            SequentialTransition sequentialTransition = new SequentialTransition();

            FadeTransition fadeIn = getFadeTransition(slide, 0.0, 1.0, 10);
            PauseTransition stayOn = new PauseTransition(Duration.millis(50));
            FadeTransition fadeOut = getFadeTransition(slide, 1.0, 0.0, 10);

            sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);
            slide.setOpacity(0);
            Main.getRootPlayGround().getChildren().add(slide);
            slideshow.getChildren().add(sequentialTransition);

        }
        slideshow.play();
    }


    /**
     * this method check if game is over or not
     * @return {@code true} if game ends otherwise return {@code false}  
     */
    public static boolean gameOver(){
        for (Tank tank : tanks){
            if(!tank.isAlive()){
                return true;
            }
        }
        return  false;
    }

    /**
     * @return array that holds tank's first x and y in the game 
     */
    public static int[] randomXandY(){

        Random random = new Random();
        int[] array = new int[3];

        int x = (int)(random.nextInt(99999) % widthPLayGround) ;
        int y = (int)(random.nextInt(99999) % heightPLayGround);
        int teta = (int)(random.nextInt(360));
        array[2] = teta;

        while (true) {
            
            Rectangle hiddenTank = new Rectangle(x, y ,18,20);

            if(!tank_Wall_OtherTank_intersect(hiddenTank , null)) {
                array[0] = x;
                array[1] = y;
                return array;

            }
             x = (int)(random.nextInt(99999) % widthPLayGround) ;
             y = (int)(random.nextInt(99999) % heightPLayGround);

        }

    }

}