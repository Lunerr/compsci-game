package Main;

import Common.Config;
import Structures.Player;

public class Index {
   public static void main(String[] args) {
      Game game = new Game();
      Player player = new Player(100, 35, 1, Utility.Random.nextInt(15, 30));
      
      Config.initiate();
      game.initiate(player);
   }
}
