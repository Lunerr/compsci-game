package Actions;

import java.util.Scanner;

import org.json.simple.JSONObject;

import Main.Game;
import Structures.Monster;
import Structures.Player;

public class Fight {
   public void initiate(Player player, Monster monster) {
      boolean fled = false;
      
      while (monster.health > 0 && fled == false) {
         if (player.getHealth() <= 0) {
            System.out.println("You've died, now exiting");
            Game.exit();
         }
         
         System.out.println("\n1. Fight\t2. Bag\t3. Flee");
         
         Scanner options = new Scanner(System.in);
         String choice = options.nextLine();
         JSONObject playerWeapon = player.getWeapon();
         
         if (choice.equals("1")) {
            int monsterRoll = Utility.Random.roll();
            
            if (monsterRoll <= monster.accuracy) {
               System.out.println("The monster has attacked you for " + monster.damage + " health!" + 
               "\nNew Health: " + player.modifyHealth(-monster.damage));
            }
            
            int playerRoll = Utility.Random.roll();
            int playerAccuracy = player.getAccuracy();
            
            if (!playerWeapon.isEmpty()) {
               playerAccuracy += (int)playerWeapon.get("accuracy");
            }
            
            if (playerRoll < playerAccuracy) {
               int givenDamage = player.getStrength();
               
               if (!playerWeapon.isEmpty()) {
                  givenDamage += (int)playerWeapon.get("damage");
                  
                  player.modifyDurability(playerWeapon, -2);
               }
               
               monster.health -= givenDamage;
               
               System.out.println("You've successfully attacked the monster for " + givenDamage
                     + " damage, reducing his health to " + monster.health);
            } else {
               System.out.println("You completely missed the monster, you suck!");
            }
         } else if (choice.equals("2")) {
            Bag.displayBag(player, monster);
         } else if (choice.equals("3")) {
            int fleeRoll = Utility.Random.roll();
            
            if (fleeRoll < 35) {
               int roll = Utility.Random.nextInt(30, 70);
               fled = true;
               
               System.out.println("You've successfully fled, however you lost " + roll + " health in the process"
                     + " making your new health " + player.modifyHealth(-roll));
            } else {
               player.modifyHealth(-monster.damage);
               
               System.out.println("You were unsuccessful in fleeing so the monster attacked you!"
                     + "\nNew health: " + player.getHealth());
            }
         }
      }
      
      player.setFight(false);
      
      Game game = new Game();
      
      game.initiate(player);
   }
}
