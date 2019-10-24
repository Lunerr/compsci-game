package game;

import java.util.Scanner;

public class Game {
   @SuppressWarnings("resource")
   public static void initiate() {
      while (Player.health > 0) {
         System.out.println("1. Adventure\t2. Bag\n3. Stats\t4. Exit");

         Scanner consoleChoice = new Scanner(System.in);
         String choice = consoleChoice.nextLine();
         
         if (choice.equals("1")) {
            Adventure.explore();
         } else if (choice.equals("2")) {
            Bag.inBag();
         } else if (choice.equals("3")) {
            System.out.println("Health: " + Player.health + "\nStrength: "
                  + Player.strength + "\nDexterity: " + Player.dexterity);
         } else if (choice.equals("4")) {
            System.out.println("Are you sure you'd like to close?\n1. Yes\t2. No");
            
            Scanner exitChoice = new Scanner(System.in);
            String exit = exitChoice.nextLine();
            
            if (exit.equals("1")) {
               exit();
            }
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
