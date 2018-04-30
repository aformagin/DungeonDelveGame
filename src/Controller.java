//This is the entity controller class. Everything in this class is very experimental right now
//Sorry about that.

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    private LinkedList<EntityStructure> wall =  new LinkedList<>();
    private LinkedList<Character>player = new LinkedList<>();

    public void tick(){}

    public void render(Graphics g){
    }

    public void addWall(EntityStructure block){
        wall.add(block);
    }

    public void removeWall(EntityStructure block){
     wall.remove(block);
    }

    public LinkedList<EntityStructure> getEntityStructure(){
        return wall;
    }

}
