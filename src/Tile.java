public class Tile {
    private int height;
    private boolean passable;
    // tile's image

    public Tile(){
        height = 0;
        passable = true;
        // untextured texture
    }

    public Tile(int height, boolean passable){  // add image
        this.height = height;
        this.passable = passable;
        // desired texture
    }

    public int getHeight() {
        return height;
    }

    public boolean getPassable() {
        return passable;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }
}
