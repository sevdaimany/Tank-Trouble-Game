/**
 * this class represent a tile grid in game
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class TileGrid {

            /*  Fields  */

    //2d array for holding playGround's tile's
    private Tile[][] map;


         /* Constructor */

    /**
     * create a tile grid with given map
     * @param newMap
     */
    public TileGrid(int[][] newMap) {

        map = new Tile[24][12];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 64, j * 67, 64, 67, "tileSand1.png");
                else if (newMap[j][i] == 2) {
                    map[i][j] = new Tile(i * 64, j * 67, 64, 67, "wall2.png");
                } else if (newMap[j][i] == 1) {
                    map[i][j] = new Tile(i * 64, j * 67, 64, 67, "wall1.png");
                }

            }
        }

    }



            /*  Methods  */


    /**
     * this method set a tile with given informaton in game's playGround
     * @param xcoord
     * @param ycoord
     * @param textureName
     */
    public void setTile(int xcoord, int  ycoord,String textureName){
        map[xcoord][ycoord] = new Tile(xcoord*64,ycoord*67,64,67,textureName);
        map[xcoord][ycoord].Draw();

    }


    /**
     * @param xcoord
     * @param ycoord
     * @return tile with given coordinate
     */
    public Tile getTile(int xcoord, int ycoord){
        return map[xcoord][ycoord];
    }


    /**
     * this method draw tile grid in map playGround
     */
    public void Draw(){
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0; j<map[i].length ;  j++){
                map[i][j].Draw();
            }
        }
    }

}
