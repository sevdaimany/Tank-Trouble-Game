import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;





/**
 * This class represent a tile in game's playGround
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class Tile extends Rectangle
{
            /*  Fields  */


    // tile's texture image
    private Image image;

    // tile's texture file's name
    private String textureName;

   



    
        /* Constructor */

    /**
     * Create new tile with give coordinate , size and texture image's filename
     */
    public Tile(double x, double y, double width, double height,String textureName)
    {
        super(x,y,width,height);

        this.textureName = textureName;

        FileInputStream input = null;

        try { input = new FileInputStream(textureName); }
        catch (FileNotFoundException e) { e.printStackTrace(); }


        image = new Image(input);

    }

            /*  Methods  */


    /**
     * Draw method add a tile to playGround's root
     */
    public void draw()
    {

        super.setFill(new ImagePattern(image));
        Main.getRootPlayGround().getChildren().add(this);
    }


    

    // * getter methods *

    /**
     * @return texture image's file name
     */
    public String getTextureName() { return textureName; }
    /**
     * @return texture's image
     */
    public Image getImage() { return image; }  
   






    // * setter methods *

    /**
     * @param textureName
     */
    public void setTextureName(String textureName) { this.textureName = textureName; }
    /**
     * @param image
     */
    public void setImage(Image image) { this.image = image; }
    
}
