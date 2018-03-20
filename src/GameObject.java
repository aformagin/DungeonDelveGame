//This is the game object class, this basically allows for us to place textures and positions to objects
//In terms of mapping this will be useful for creating single tiles for each map

public class GameObject {
    double x, y;
    private Textures tex;

    public GameObject(double PosX, double PosY) {
        this.x = x;
        this.y = y;
       // this.tex = tex;
    }
}
// TODO Create entities for walls and such that have rectangles to check if they intersect with the player