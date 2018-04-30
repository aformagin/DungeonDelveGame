import java.util.LinkedList;

public class Physics {

    public static boolean wallCollision(Character player, LinkedList<EntityStructure> wall){

        for(int i =0; i <wall.size(); i++){
            if(player.getBounds().intersects(wall.get(i).getBounds(32, 32))){
                return true;

            }
        }
        return false;
    }

}
