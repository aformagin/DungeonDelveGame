//This is the game object class, this basically allows for us to place textures and positions to objects
//In terms of mapping this will be useful for creating single tiles for each map

import java.awt.*;

public class GameObject {
    double x, y;
    private Textures tex;

    public GameObject(double PosX, double PosY) {
        this.x = x;
        this.y = y;
       // this.tex = tex;
    }

    public Rectangle getBounds(int width, int height) {
        return new Rectangle((int)x, (int)y, width, height);
    }
}
// TODO Create entities for walls and such that have rectangles to check if they intersect with the player