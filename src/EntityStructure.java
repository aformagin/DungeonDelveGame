//The EntityStructure class, this is what I am going to use to determine collisions of each "tile" I think in the OverWorld
//NOTE: This is an experimental class.

import entities.EntityBase;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class EntityStructure extends GameObject implements EntityBase{

    private BufferedImage img;
    public EntityStructure(double posX, double posY, BufferedImage img) {
        super(posX, posY);
        this.img = img;
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    public double getX() {
        return 0;
    }

    public double getY() {
        return 0;
    }

//    public Rectangle getBounds(int width, int height) {
//        return new Rectangle((int)x, (int)y, width, height);
//    }
}
