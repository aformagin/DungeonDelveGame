

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {

    private BufferedImage image;
    public SpriteSheet(BufferedImage ss){
        this.image = ss;//Sets the image to the sprite sheet
    }

    //Grabs the image from the sprite sheet
    public BufferedImage grabImage(int col, int row, int width, int height) {
        //Finds the part of the sprite sheet to grab, starting at pixel 0 of the square
        BufferedImage img = image.getSubimage((col* 32) - 32, (row *32)-32, width, height);
        return img;
    }

    public BufferedImage grabMap (int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col* 512) - 512, (row *512)-512, width, height);
        return img;
    }
}
