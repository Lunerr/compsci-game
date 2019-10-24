package game;

import java.util.Scanner;

public class Fight {
   @SuppressWarnings("resource")
   public static void fight(int health, int damage, int accuracy) {
      boolean fled = false;
      
      while (health > 0 && fled == false) {
         System.out.println(fled);
         System.out.println("1. Fight\t2. Flee");
         
         Scanner options = new Scanner(System.in);
         String choice = options.nextLine();
         
         if (choice.equals("1")) {
            int roll = Utility.roll();
            
            if (roll <= accuracy) {
               int newHealth = Player.modifyHealth(damage);
               
               System.out.println("The monster has attacked you for " + damage + " health!" + 
               "\nYour new health is " + newHealth);
            } else if (roll < Player.accuracy) {
               health -= Player.strength;
               
               System.out.println("You've successfully attacked the monster for " + Player.strength + 
                     " reducing his health to " + health);
            } else {
               System.out.println("You completely missed the monster, you suck!");
            }
         } else if (choice.equals("2")) {
            int fleeRoll = Utility.roll();
            
            if (fleeRoll < 35) {
               int roll = Utility.nextInt(30, 70);
               Player.modifyHealth(roll);
               fled = true;
               
               System.out.println("You've successfully fled, however you lost " + roll + " health in the process"
                     + " making your new health " + Player.health);
            } else {
               Player.modifyHealth(damage);
               
               System.out.println("You were unsuccessful in fleeing so the monster attacked you!"
                     + " new health " + Player.health);
            }
         }
      }
      
      Adventure.explore();
   }
}
