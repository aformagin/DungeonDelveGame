import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {

    private BufferedImage image;
    public SpriteSheet(BufferedImage ss){
        this.image = ss;//Sets the image to the sprite sheet
    }

    //Grabs the image from the sprite sheet
    public BufferedImage grabImage(int col, int row, int width, int height) {
        BufferedImage img = image.getSubimage((col* 32) - 32, (row *32)-32, width, height);
        return img;
    }
}
