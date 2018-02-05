//Welcome to the Dungeon Delve game class. This is where the majority of the action is going to
//end up taking in place! Surprise, surprise. It is almost like this is our MAIN CLASS or something?


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    ////////////////////////////////////////////////////////////////////////////////////////
    //Variables
    ////////////////////////////////////////////////////////////////////////////////////////

    //Height of window
    public static final int HEIGHT = 320;//Setting the height of the screen to 800 pixels
    //Width of window
    public static final int WIDTH = (HEIGHT * 16) / 9;//Creating a 16:9 ratio
    public static final int SCALE = 2;//Scale factor, this will be used to scale the size of the window up
    public final String TITLE = "Dungeon Delve 0.1a";//Title of the game

    private boolean running = false;
    private Thread gameThread;


    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;

    private Character character;
    private Thread animate;
    ////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////
    //Initialize
    public void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            spriteSheet = loader.loadImage("res/images/sprite_sheet.png");//Loads the sprite sheet which is yet to be created
        } catch (IOException e) {//Error catching :D
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));
        this.requestFocus();
        character = new Character(100, 100, this);//Character creation
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    //Starting gameThread
    private synchronized void start() {
        if (running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }//end of start method

    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////
    private synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            gameThread.join();
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
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            //The game loop :D A.K.A The heart of the game!

            long newTime = System.nanoTime();
            delta += (newTime - lastTime) / ns;
            lastTime = newTime;

            if (delta >= 1) {//"Catch up" for FPS and Ticks
                tick();//Sets a maximum amount of ticks/second
                updates++;
                delta--;
            }
            render();//Renders the screen
            frames++;//Adds to the frame counter

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;//Sets to 1000 to exit out.

                //Displays the tick rate and frame rate
                System.out.println("Ticks: " + updates);
                System.out.println("FPS: " + frames);

                //Resets back to zero
                updates = 0;
                frames = 0;
            }


        }
        stop();//Stops the game

    }//end of run method
    ////////////////////////////////////////////////////////////////////////////////////////

    private void tick() {//Everything that updates
        character.tick();
    }

    private void render() {//Everything that renders
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);//Triple buffering, increases speed overtime.
            return;
        }

        Graphics g = bs.getDrawGraphics();//Draws out buffers
        ////////////////////////////////////////////////////////////////////////////////////////
        //Between these comment lines is where images can be drawn out to the screen
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);//Draws image

        character.render(g);

        //End of drawing
        ////////////////////////////////////////////////////////////////////////////////////////
        g.dispose();//Destroys image
        bs.show();//Shows buffer


    }

    //Keyboard inputs
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            character.setVelY(-2);
        } else if (key == KeyEvent.VK_A) {
            character.setVelX(-2);
        }else if (key == KeyEvent.VK_S) {
            character.setVelY(2);
        }else if (key == KeyEvent.VK_D) {
            character.setVelX(2);
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            character.setVelY(0);
        }else if (key == KeyEvent.VK_A) {
            character.setVelX(0);
        }else if (key == KeyEvent.VK_S) {
            character.setVelY(0);
        }else if (key == KeyEvent.VK_D) {
            character.setVelX(0);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) {
        Game game = new Game();//Creating a game object

        //Window Creation
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Start size of window
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Max size of window
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));//Min size of window

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);//Adds the game to the frame
        frame.pack();//Sets all contents to preferred sizes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Sets the function to close
        frame.setResizable(false);//Allows the window to be resized
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//Makes the frame visible



        //Call on the start method to start the game
        game.start();
    }//end of main method
    ////////////////////////////////////////////////////////////////////////////////////////

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

}//end of Game Class
