import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * This class represent a tile grid in game
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class TileGrid 
{

            /*  Fields  */

    //2d array for holding playGround's tile's
    private static Tile[][] map;








         /* Constructor */

    /**
     * create a tile grid with given map
     * @param newMap
     */
    public TileGrid(int[][] newMap) 
    {
        map = new Tile[newMap[0].length][newMap.length];

        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[i].length; j++) 
            {
                int tileSize = 45;

                if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize, tileSize, DataBase.getGroundImageFilePath("sand"));

                else if (newMap[j][i] == 2){  
                    map[i][j] = new WoodWall(i * tileSize, j * tileSize, tileSize, tileSize, DataBase.getWallImageFilePath("wood"));
                    GameState.getWalls().add((WoodWall) map[i][j]);
                }

                else if (newMap[j][i] == 1){ 
                    map[i][j] = new Wall(i * tileSize, j * tileSize, tileSize, tileSize, DataBase.getWallImageFilePath("metal"));
                    GameState.getWalls().add((Wall) map[i][j]);

                }
            }
        }
    }









            /*  Methods  */


    /**
     * This method set a tile with given information in game's playGround
     * 
     * 
     * @param xcoord
     * @param ycoord
     * @param textureName
     */
    public static void setTile(int xcoord, int  ycoord)
    {
        GameState.explosion(xcoord * 45 , ycoord * 45);

        FileInputStream input = null;

        try { input = new FileInputStream(DataBase.getGroundImageFilePath("sand")); }
        catch (FileNotFoundException e) { e.printStackTrace(); }


        Image image = new Image(input);

        map[xcoord][ycoord].setFill(new ImagePattern(image));
    }


    /**
     * @param xcoord
     * @param ycoord
     * @return tile with given coordinate
     */
    public static Tile getTile(int xcoord, int ycoord)
    {
        return map[xcoord][ycoord];
    }


    /**
     * This method draw tile grid in map playGround
     */
    public void draw()
    {
        for (int i = 0 ; i < map.length; i++)
            for (int j = 0; j<map[i].length ;  j++)
                map[i][j].draw();
    }
}
