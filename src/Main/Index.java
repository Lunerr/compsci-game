package Main;

import Common.Config;
import Structures.Player;

public class Index {
   public static void main(String[] args) {
      Game game = new Game();
      
      int level = 1;
      int experience = 0;
      int health = 100;
      int strength = Utility.Random.nextInt(5, 10);
      int dexterity = 1;
      int accuracy = Utility.Random.nextInt(15, 30);
      
      Player player = new Player(level, experience, health, strength, dexterity, accuracy);
      
      Config.initiate();
      game.initiate(player);
   }
}
