//Welcome to the Dungeon Delve game class. This is where the majority of the action is going to
//end up taking in place! Surprise, surprise. It is almost like this is our MAIN CLASS or something?


import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    ////////////////////////////////////////////////////////////////////////////////////////
    //Variables
    ////////////////////////////////////////////////////////////////////////////////////////
    //Height of window
    public static final int HEIGHT = 800;//Setting the height of the screen to 800 pixels
    //Width of window
    public static final int WIDTH = (HEIGHT * 16) / 9;//Creating a 16:9 ratio
    public static final int SCALE = 2;//Scale factor, this will be used to scale the size of the window up
    public final String TITLE = "Dungeon Delve 0.1a";//Title of the game

    private boolean running = false;
    private Thread thread;
    ////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////
    //Starting thread
    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }//end of start method
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }//end of stop method
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //Runnable Method
    @Override
    public void run() {
        while(running){
        System.out.println("Running");
        //The game loop :D A.K.A The heart of the game!
        }
        stop();//Stops the game :(

    }//end of run method
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    public static void main (String args[]){
        Game game = new Game();//Creating a game object

        //Window Creation
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Start size of window
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Max size of window
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Min size of window

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);//Adds the game to the frame
        frame.pack();//Sets all contents to preferred sizes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Sets the function to close
        frame.setResizable(true);//Allows the window to be resized
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//Makes the frame visible



        //Call on the start method to start the game
        game.start();
    }//end of main method
    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    //Movement or something? I'll figure this part out later

    //FPS counter, this will only be displayed as a command line program. In this form, it will not be meant
    //for the end user.



}//end of Game Class
