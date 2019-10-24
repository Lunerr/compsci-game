package Actions;

import java.util.Scanner;

import Structures.Player;

public class Fight {
   @SuppressWarnings("resource")
   public static void fight(Player player, int health, int damage, int accuracy) {
      boolean fled = false;
      
      while (health > 0 && fled == false) {
         System.out.println(fled);
         System.out.println("1. Fight\t2. Flee");
         
         Scanner options = new Scanner(System.in);
         String choice = options.nextLine();
         
         if (choice.equals("1")) {
            int roll = Utility.Random.roll();
            
            if (roll <= accuracy) {
               int newHealth = player.modifyHealth(damage);
               
               System.out.println("The monster has attacked you for " + damage + " health!" + 
               "\nYour new health is " + newHealth);
            } else if (roll < player.getAccuracy()) {
               health -= player.getStrength();
               
               System.out.println("You've successfully attacked the monster for " + player.getStrength() + 
                     " reducing his health to " + health);
            } else {
               System.out.println("You completely missed the monster, you suck!");
            }
         } else if (choice.equals("2")) {
            int fleeRoll = Utility.Random.roll();
            
            if (fleeRoll < 35) {
               int roll = Utility.Random.nextInt(30, 70);
               player.modifyHealth(roll);
               fled = true;
               
               System.out.println("You've successfully fled, however you lost " + roll + " health in the process"
                     + " making your new health " + player.getHealth());
            } else {
               player.modifyHealth(damage);
               
               System.out.println("You were unsuccessful in fleeing so the monster attacked you!"
                     + " new health " + player.getHealth());
            }
         }
      }
      
      Adventure adventure = new Adventure();
      
      adventure.explore(player);
   }
}
