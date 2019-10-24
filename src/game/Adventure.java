package game;

public class Adventure {
   public static void explore() {
      int roll = Utility.roll();
      
      if (roll >= 75) {
         Monster monster = new Monster();
         
         System.out.println("You've found a monster!\nHealth: " + monster.health +
               "\tDamage: " + monster.damage + "\tAccuracy: " + monster.accuracy);
         
         Fight.fight(monster.health, monster.damage, monster.accuracy);
      }
   }
}
