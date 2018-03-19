
import java.awt.image.BufferedImage;
import java.io.*;

public class Tile {
    private int height;             // the z-value of the tile
    private boolean passable;       // if a non-flying unit can pass
    private boolean tall;           // if a flying unit can pass
    private int moveMod;            // how much is removed from unit's possible movement.
    private BufferedImage texture;  // the tile's graphic
    private BufferedImageLoader loader = new BufferedImageLoader();

    public Tile() throws IOException{
        this.height = 0;
        this.passable = true;
        this.tall = true;
        this.moveMod = 0;
        try {
            this.texture = loader.loadImage("res/images/missing_texture.png");
        } catch (IOException e) {   //Error catching :D
            e.printStackTrace();
        }
    }

    public Tile(int height, boolean passable, boolean tall, int moveMod, BufferedImage texture){  // add image
        this.height = height;
        this.passable = passable;
        this.tall = tall;
        this.moveMod = moveMod;
        this.texture = texture;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getPassable() {
        return this.passable;
    }

    public boolean isTall() {
        return this.tall;
    }

    public int getMoveMod() {
        return this.moveMod;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public void setTall(boolean tall) {
        this.tall = tall;
    }

    public void setMoveMod(int moveMod) {
        this.moveMod = moveMod;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}
