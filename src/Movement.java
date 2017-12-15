//The Movement class will be used to move the character around the screen/map outside
//of combat
//Programmer Assigned: Austin

public class Movement {
    private int charPosX;
    private int charPosY;



    ////////////////////////////////////////////////////////////////////////////////////////
    //Change the values of X & Y
    ////////////////////////////////////////////////////////////////////////////////////////

    //Movement Right
    public void moveRight(int currentPosX){
        //Adjust the x value to become more positive
        charPosX = currentPosX + 5;//Value will change after testing
    }//End of moveRight

    //Movement Left
    public void moveLeft(int currentPosX){
        //Adjust the x value to become more negative
        charPosX = currentPosX - 5;//Value will change after testing
    }//End of moveLeft

    //Movement Up
    public void moveUp(int currentPosY){
        //Adjust the y value to become more positive
        charPosX = currentPosY + 5;//Value will change after testing
    }//end of MoveUp

    //Movement Down
    public void moveDown(int currentPosY){
        //Adjust the y value to become more negative
        charPosX = currentPosY - 5;//Value will change after testing
    }//End of moveDown
    ////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////
}//End of Movement class
