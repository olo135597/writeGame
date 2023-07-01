package writeGame;

public class enemy { 

    private String name; 
    private int health; 
    private int speed; 
    private String tribes;  
    private int range;
    private int attack; 
    private int defense;
    private int dice;
    public boolean isAttick = false;

    
    public enemy()
    {
        
    }
    public void setHealth(int health) {
       this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
     }

     public void setName(String name) {
        this.name = name;
     }

     public void setTribes(String tribes){
          this.tribes = tribes;
     }

     public int getHealth() {
         return health;
     }

     public int getSpeed() {
         return speed;
     }

     public String getName() {
         return name;
     }

     public String getTribes() {
         return tribes;
     } 


     public void setRange(int range) {
         this.range = range;
     }

     public int getRange() {
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

    
    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDice() {
        return dice;
    }

     public void enemyAttack() {
        System.out.println("The enemy has attacked the player"); 
        isAttick = true;
     }

     public void takeDamage(int damage){
         health = health - damage;
     }
    
}
