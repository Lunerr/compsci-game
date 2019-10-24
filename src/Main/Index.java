package Main;

import Structures.Player;

public class Index {
   public static void main(String[] args) {
      Game game = new Game();
      Player player = new Player();
      
      player.setHealth(100);
      player.setAccuracy(35);
      player.setDexterity(1);
      player.setStrength(Utility.Random.nextInt(15, 30));
      
      game.initiate(player);
   }
}
