import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;

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

}
