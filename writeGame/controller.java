package writeGame;
import writeGame.gameMaker;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

import javax.lang.model.util.ElementKindVisitor6;
public class controller {
   
   
   public int distance;
   public String turn = "1";
   public boolean isPlayerFinished;
   public boolean isEnemyFinished;
   public boolean isFinished;
   
    public controller()
    {

    }
    
    public String ReadLine()
    {
        Scanner myObj = new Scanner(System.in); 
         String  string = myObj.nextLine();
         return string; 
    }
    
    public void game()
    {
        enemy Goblin = new enemy();
    player Link = new player();
    
    Link.setName("Link");
    Link.setHealth(100);
    Link.setSpeed(20);

    Goblin.setName("Bokoblin");
    Goblin.setHealth(30);
    Goblin.setSpeed(16);
    Goblin.setTribes("The tribe of the great Plateau");

    Goblin.enemyAttack(); 
     if(Goblin.isAttick == true)
     {
        Link.getDamage();
      
     } 

     if(Link.getHealth() == 90)
     {
        Link.drinkPotion(); 
        
     }

     System.out.println("Current life status: " + Link.getHealth());
    }
    

 public int roleDice(int times, int digits){
  
   
   
    int[] rolls = new int[times];
   int calc = 0; 
    for( int i = 0; i < times; i++ )
    {
      Random rand = new Random();
       rolls[i] = rand.nextInt(digits) + 1; 
      

        calc = calc + rolls[i];
    }
    return calc;
   } 


   public boolean decisionPhase(player player, enemy enemy)
   {
      boolean isAttackingPlayer = false; 
      int coinflip; 
      if(player.getSpeed() > enemy.getSpeed())
      {
          coinflip = 3;
      }
      else
      {
         coinflip = 1;
      }

      Random rand = new Random();
      int result = rand.nextInt(coinflip);
      
      System.out.println("Now it will be decided witch side can attack first."); 
      System.out.println("This will be done random but a greater speed has an advantage."); 
      
      if(coinflip > 0)
      {
         isAttackingPlayer = false;
         System.out.println("You are attacking first.");
      }
      else
      {
         isAttackingPlayer = true;
         System.out.println("The enemy is attacking first.");
      }

     
      return isAttackingPlayer;
   }

   public void analyzePhase(player player, enemy enemy){
      System.out.println("Analyze phase:");
      System.out.println("Your Range:       " + player.getRange());
      System.out.println("Your Speed:       " + player.getSpeed());
      System.out.println("Your Attack:      " + player.getAttack());
      System.out.println("Your Defense:    "  + player.getDefense());
      System.out.println("Distance:       " + distance); 

      System.out.println("Enemy Range: " + enemy.getRange());
      System.out.println("Enemy Speed: " + enemy.getSpeed());
      System.out.println("Enemy Attack: " + enemy.getAttack());
      System.out.println("Enemy Defense: " + enemy.getDefense());
   }

   public void playerTurn(player player, enemy enemy)
   {
      boolean isDead;
      int timesAttack = 0;
      System.out.println("Jetzt bist du dran anzugreifen");

      if(distance > player.getRange())
      {
         timesAttack--;
      }
      
     turn = ReadLine();

      System.out.println("Battlephase:   ");
      int playerAttack = roleDice(player.getSpeed() + timesAttack, player.getAttack());

      int enemyDefend = roleDice(enemy.getSpeed(), enemy.getDefense());
      System.out.println("You are now using your sword and prepare a blow");
      System.out.println("This is how much your attack damage is:   " + playerAttack);
      
      System.out.println("This is how the enemy defended:  " + enemyDefend);
      
      int Damage = playerAttack - enemyDefend;
      System.out.println("You have dealt him: " +  Damage + " damage.");
      enemy.takeDamage(Damage);

   }

   public void enemyTurn(player player, enemy enemy)
   {
      boolean isDead;
      int timesAttack = 0;
      System.out.println("Now the enemy is attacking"); 

      if(distance > enemy.getRange())
      {
         timesAttack--;
      }

      turn = ReadLine();

      System.out.println("Battlephase:   ");
      int enemyAttack = roleDice(enemy.getSpeed() + timesAttack, enemy.getAttack());


      int playerDefend = roleDice(player.getSpeed(), player.getDefense());
      System.out.println("The enemy is using his weapon and prepares a blow.");
      System.out.println("This is how much the Attack damage is:   " + enemyAttack);
      
      System.out.println("This is how you have defended:  " + playerDefend);

      int Damage = enemyAttack - playerDefend;
      System.out.println("The enemy has dealt you: " +  Damage + " damage.");
      player.takeDamage(Damage);

      
   }

   public void battleSystem(player player, enemy enemy, int distance)
   {
      
      analyzePhase(player, enemy);
      turn = ReadLine();
       
      if(decisionPhase(player, enemy) == false)
      {
         
         do
         {
            isFinished = false;
            playerTurn(player, enemy);
            
            if(enemy.getHealth() <= 0)
            {
               isFinished = true;
            }
            else {
                     isFinished = false;
            }

            if(isFinished == false)
            {
               enemyTurn(player, enemy);

            }
            else{
               if(player.getHealth() <= 0)
               {
                  System.out.println("You are dead");
                  System.out.println("The battle is lost.");
                  isFinished = true;

               
               }
               else {
                  System.out.println("The enemy is dead");
                  System.out.println("The battle has been won.");
                  isFinished = true;

               }
            }
         }while(isFinished == true);
      }
      else
      {
        
            do
            {
                enemyTurn(player,enemy);
                if(player.getHealth() <= 0)
                {
                   isFinished = true;
               }
                  else {
                     try {
                  if(player.getHealth() >= 0) 
                  {
                     isFinished = false;
                  }
                  }catch (Exception e) {
                  System.out.println(e.getMessage());
                  }
               }

               if(isFinished == false)
               {
                  playerTurn(player,enemy);
               }
               else {
                  if(enemy.getHealth() <= 0)
                  {
                     System.out.println("The enemy is dead.");
                     System.out.println("The battle has been won.");
                  }
                  else {
                     System.out.println("You are dead.");
                     System.out.println("The battle is lost.");
                  }
               }
   
            }while (isFinished == true);
      }
   }
   
}
