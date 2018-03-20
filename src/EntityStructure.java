//The EntityStructure class, this is what I am going to use to determine collisions of each "tile" I think in the OverWorld
//NOTE: This is an experimental class.

import entities.EntityBase;

import java.awt.*;

public class EntityStructure extends GameObject implements EntityBase{

    public EntityStructure(double posX, double posY) {
        super(posX, posY);
    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public double getX() {
        return 0;
    }

    public double getY() {
        return 0;
    }
}
