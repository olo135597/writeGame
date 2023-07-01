package writeGame;
public class player {
    

    public static String name; 
    private int speed; 
    private int health; 
    private int range; 
    private int attack; 
    private int defense;
    private int dice;

    public player() {
    
    }
    
    public void setName(String name) {
       this.name = name;
    }

    public String getName() { 
        return name; 
    }

    public void setHealth(int Health) {
        this.health = Health;
    }

    public int getHealth(){
        return health;
    } 

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    } 
     
    public void setRange(int range){
        this.range = range;
    }

    public int getRange(){
        return range;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
    public void getDamage(){
        health = health - 10;
        System.out.println("Taken Damage: " + (100 -health));
        
    }
    

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDice() {
        return dice;
    }
    public void drinkPotion()
    {
        
        System.out.println("Drinking the Potion...");
        health = health + 20; 
        System.out.println("Healed: " + (20));
    }

    public void takeDamage(int damage){
        health = health - damage;
    }
 

}
