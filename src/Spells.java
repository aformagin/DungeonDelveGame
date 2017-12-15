////////////////////////////////////////////////////////////////////////////////
//Spells class, this is the generic spell class and all spells that are added will be
//a child of this class
//Updated Date: 2017-12-14
////////////////////////////////////////////////////////////////////////////////
public class Spells {


    private String spellType;//The type of spell it is, damage, healing, etc. Types will be defined me in the readMe
    private int damage;//The amount of damage it will do, or will determine if it heals
    private boolean learned;//Determines if the user has the spell learned
   private  int manaRequired;//The amount of 'mana' required to use this spell

    public Spells() {
        this.spellType = "DIRECT";
        this.damage = SpellDamage(1, 6);//Assigns base spell a damage of d6
    }

    //Where the client or another class/method will put the information required to create the spell
    public Spells(int damage, boolean learned, int manaRequired, int mana, String spellType) {
        this.spellType = spellType;
    }

    //Randomly assigns spell damage
    private  int SpellDamage(int lowDMG, int highDMG) {
        int outputDMG;
        outputDMG = (int) Math.round(Math.random() * (highDMG - lowDMG + 1) + lowDMG);
        return outputDMG;
    }
}
