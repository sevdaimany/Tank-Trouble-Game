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
    private Tile[][] map;








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
                if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, "tileSand1.png");

                else if (newMap[j][i] == 2) 
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, "wall2.png");

                else if (newMap[j][i] == 1) 
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, "wall1.png");
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
    public void setTile(int xcoord, int  ycoord,String textureName)
    {
        map[xcoord][ycoord] = new Tile(xcoord*64,ycoord*67,64,67,textureName);
        map[xcoord][ycoord].draw();

    }


    /**
     * @param xcoord
     * @param ycoord
     * @return tile with given coordinate
     */
    public Tile getTile(int xcoord, int ycoord)
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
