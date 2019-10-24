package game;

import java.util.Scanner;

public class Game {
   public void initiate() {
      System.out.println("1. Adventure\t2. Bag\n3. Cry\t\t4. Exit");
      
      @SuppressWarnings("resource")
      Scanner consoleChoice = new Scanner(System.in);
      String choice = consoleChoice.nextLine();
      
      if (choice.equals("1")) {
         Adventure adventure = new Adventure();
         
         adventure.explore();
      } else if (choice.equals("2")) {
         Bag bag = new Bag();
         
         bag.inBag();
      } else if (choice.equals("3")) {
         System.out.println("You've successfully sat down and cried, doing nothing useful with your life, loser.");
      } else if (choice.equals("4")) {
         dead();
      }
   }
   
   public void dead() {
      System.exit(0);
   }
}