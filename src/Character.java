import java.awt.*;
import java.awt.image.BufferedImage;

//////////////////////////////
//Character class
//////////////////////////////
public class Character
{
    private int str;
    private int con;
    private int intel;
    private int dex;
    private int armor;
    private int hp;
    private int mana;
    private double charPosX;
    private double charPosY;
    private BufferedImage player;


    public Character (double charPosX, double charPosY, Game game){
        this.str = 10;
        this.con = 10;
        this.intel = 10;
        this.dex = 10;
        this.armor = 0;
        this.hp = this.con * 2;
        this.mana = 0;
        this.charPosX = charPosX;
        this.charPosY = charPosY;

        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        player = ss.grabImage(1,1,32,32);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////
    // Ticks and rendering images
    ///////////////////////////////////////////////////////////////////////////////////////
    public void tick(){

    }

    public void render(Graphics g){//Draws image
        g.drawImage(player, (int)charPosX, (int)charPosY, null);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////
    // Accessors
    ///////////////////////////////////////////////////////////////////////////////////////

    public double getCharPosX(){
        return this.charPosX;
    }
    public double getCharPosY(){
        return this.charPosY;
    }
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
        this.charPosX = x;
    }

    public void setCharPosY(double y){
        this.charPosY = y;
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
    ////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////
}//End of Character Class