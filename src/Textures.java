import java.awt.image.BufferedImage;

public class Textures {
    public BufferedImage[] overworldPlayer = new BufferedImage[2];
    private SpriteSheet ss;
    public Textures (Game game){
        ss = new SpriteSheet(game.getSpriteSheet());
        getTextures();
    }

    public void getTextures(){
        overworldPlayer[0] = ss.grabImage(1,1,32,32);
        overworldPlayer[1] = ss.grabImage(1,2,32,32);

    }

}
