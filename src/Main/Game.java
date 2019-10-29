package Main;

import java.util.Scanner;

import org.json.simple.JSONObject;

import Actions.Adventure;
import Actions.Bag;
import Services.GameService;
import Structures.Player;

public class Game {
   public void initiate(Player player) {
      int health = player.getHealth();
      
      while (health > 0) {
         System.out.println("1. Adventure\t2. Bag\n3. Stats\t4. Exit");

         Scanner consoleChoice = new Scanner(System.in);
         String choice = consoleChoice.nextLine();
         
         System.out.println("\n");
         
         if (choice.equals("1")) {
            Adventure adventure = new Adventure();
            
            adventure.explore(player);
         } else if (choice.equals("2")) {
            Bag.displayBag(player, null);
         } else if (choice.equals("3")) {
            System.out.println("Level: " + player.getLevel() + "\nExperience: " + player.getExperience() + "\nHealth: " + player.getHealth() + "\nStrength: "
                  + player.getStrength() + "\nDexterity: " + player.getDexterity());
         } else if (choice.equals("4")) {
            System.out.println("Are you sure you'd like to close?\n1. Yes\t2. No");
            
            Scanner exitChoice = new Scanner(System.in);
            String exit = exitChoice.nextLine();
            
            if (exit.equals("1")) {
               exit();
            } else if (!exit.equals("2")) {
               System.out.println("Please choose a correct option.");
            }
         } else {
            System.out.println("Please choose a correct option.");
         }
         JSONObject nextLevel = GameService.findNextLevel(player);
         
         if (player.getExperience() >= (int)nextLevel.get("xpNeeded") ) {
            GameService.levelUp(player);
            
            System.out.println("You've leveled up to level " + nextLevel.get("level") + " gaining "
                  + nextLevel.get("strengthIncrease") + " strength, " + nextLevel.get("accuracyIncrease")
                  + " accuracy and " + nextLevel.get("dexterityIncrease") + " dexterity");
         }
         
         System.out.println("\n");
      }
      
      System.out.println("You've died, now exiting");
      
      exit();
   }
   
   public static void exit() {
      System.exit(0);
   }
}
