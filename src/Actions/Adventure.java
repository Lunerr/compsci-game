package Actions;

import Structures.Monster;
import Structures.Player;

public class Adventure {
   public void explore(Player player) {
      int roll = Utility.Random.roll();
      
      if (roll >= 75) {
         Monster monster = new Monster();
         
         System.out.println("You've found a monster!\nHealth: " + monster.health +
               "\tDamage: " + monster.damage + "\tAccuracy: " + monster.accuracy);
         
         Fight.fight(player, monster.health, monster.damage, monster.accuracy);
      }
   }
}
