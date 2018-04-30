import entities.EntityBase;

import java.awt.*;
import java.awt.image.BufferedImage;

//////////////////////////////
//Character class
//////////////////////////////
public class Character extends GameObject implements EntityBase
{
    private int str;
    private int con;
    private int intel;
    private int dex;
    private int armor;
    private int hp;
    private int wis;
    private int mana;

    /*TODO Thinking about making a seperate class to handle the above variables...
    for in battle, and if trying to access outside of battle, it will call on that
    sperate class. But we will have to see.
    */
   // private double charPosX;
   // private double charPosY;
    private double velY = 0;
    private double velX = 0;
    private Textures tex;
    private BufferedImage player;
    private SpriteSheet ss;
    public Animation anim;


    public Character(double charPosX, double charPosY, Textures tex){
        super(charPosX,charPosY);
        this.str = 10;
        this.con = 10;
        this.intel = 10;
        this.dex = 10;
        this.wis = 10;
        this.armor = 0;
        //this.hp = this.con * 2;
        this.mana = 0;
        this.tex = tex;
        anim = new Animation(10, tex.overworldPlayer[0], tex.overworldPlayer[1]);


        //ss = new SpriteSheet(game.getSpriteSheet());
       // this.player = ss.grabImage(1,1,32,32);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////
    // Ticks and rendering images
    ///////////////////////////////////////////////////////////////////////////////////////
    public void tick(){
        x +=velX;
        y += velY;
        anim.runAnimation();

        if(Physics.wallCollision(this, )){

        }
    }

    public void render(Graphics g){//Draws image
        g.drawImage(tex.overworldPlayer[0], (int)x, (int)y, null);
       // anim.drawAnimation(g, charPosX, charPosY, 0);
    }


    ///////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////
    // Accessors
    ///////////////////////////////////////////////////////////////////////////////////////

    public double getX(){
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public BufferedImage getPlayer(){return this.player;}
    public int getStr (){
        return this.str;
    }

    public int getCon (){
        return this.con;
    }

    public int getIntel (){
        return this.intel;
    }

    public int getDex (){
        return this.dex;
    }

    public int getArmor (){
        return this.armor;
    }

    public int getHp (){
        return this.hp;
    }

    public int getMana(){return  this.mana;}
    ///////////////////////////////////////////////////////////////////////////////////////



    ///////////////////////////////////////////////////////////////////////////////////////
    // Mutators
    ///////////////////////////////////////////////////////////////////////////////////////
    public void setCharPosX(double x){
        this.x = x;
    }

    public void setCharPosY(double y){
        this.x = y;
    }


    public void setVelX(double velX){
        this.velX = velX;
    }

    public void setVelY(double velY){
        this.velY = velY;
    }
    //Strength stat of the character, determines the carrying capacity and ability to do
    //strength based tasks
    public void setStr (int s){
        this.str = s;
    }

    //Constitution stat of character, determines their health and how "beefy" they are
    public void setCon (int c){
        this.con = c;
    }

    //Intelligence stat of the character, determines the spells that they can know
    public void setIntel (int i){
        this.intel = i;
    }

    //Dexterity state of the character, determines the speed at which the character can move
    //as well as their dodge chance
    public void setDex (int d){
        this.dex = d;
    }

    //Armour, on or off.
    public void setArmor (int a){
        this.armor = a;
    }

    //Sets the hit points of the character
    public void setHp (int h){
        this.hp = h;
    }

    //Sets the mana points of the character
    public void setMana(int m){this.mana = m;}
    public void setPlayer(int col, int row, int w, int h){
        this.player = ss.grabImage(col, row, w, h);
    }
    ////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////
    // Behavioral
    ////////////////////////////////////////////////////////////////////////////////////////

    //Equips armour to the character
    public void donArmor(int equip){
    if (equip == 1){
        setArmor(5);
    }
    if (equip == 0)
        setArmor(0);
    }

    public void damageChar(int dmg){
        //Damaging character
        if (dmg > 0)//If the damage is greater than 0, it will subtract from the players health
            this.hp = this.hp - dmg;
        //Healing character
        if (dmg < 0)//If the damage is less than 0, it will add the negative of the damage
            //to the players health.
            this.hp = this.hp + -dmg;
    }

    public Rectangle getBounds(){
       return new Rectangle((int)x, (int)y, 32, 32) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////
}//End of Character Class