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
public class Tile 
{
            /*  Fields  */

    // tile's coordinate and size
    private  float x, y, width,height;

    // tile's texture image
    private Image image;

    // tile's texture file's name
    private String textureName;

    //tile's rectangle
    private   Rectangle rectangle;





    
        /* Constructor */

    /**
     * Create new tile with give coordinate , size and texture image's filename
     */
    public Tile(float x, float y, float width, float height,String textureName) 
    {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.textureName = textureName;

        FileInputStream input = null;

        try { input = new FileInputStream(".//icons//" + textureName); } 
        catch (FileNotFoundException e) { e.printStackTrace(); }


        image = new Image(input);
    }

            /*  Methods  */


    /**
     * Draw method add a tile to playGround's root
     */
    public void draw()
    {

        rectangle = new Rectangle(x,y,width,height);
        rectangle.setFill(new ImagePattern(image));
        Main.getRootPlayGround().getChildren().add(rectangle);
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
    /**
     * @return x of tile
     */
    public float getX() { return x; }
    /**
     * @return y of tile
     */
    public float getY() { return y; }
    /**
     * @return tile's width
     */
    public float getWidth() { return width; }
    /**
     * @return tile's height
     */
    public float getHeight() { return height; }
    /**
     * @return tile's rectangle
     */
    public Rectangle getRectangle() {
        return rectangle;
    }






    // * setter methods *

    /**
     * @param textureName
     */
    public void setTextureName(String textureName) { this.textureName = textureName; }
    /**
     * @param image
     */
    public void setImage(Image image) { this.image = image; }
    /**
     * @param x
     */
    public void setX(float x) { this.x = x; }
    /**
     * @param y
     */
    public void setY(float y) { this.y = y; }
    /**
     * @param width
     */
    public void setWidth(float width) { this.width = width; }
    /**
     * @param height
     */
    public void setHeight(float height) { this.height = height; }
}
