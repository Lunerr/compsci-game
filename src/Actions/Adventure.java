package Actions;

import org.json.simple.JSONObject;

import Services.GameService;
import Structures.Monster;
import Structures.Player;

public class Adventure {
   public void explore(Player player) {
      int roll = Utility.Random.roll();
      
      if (roll <= 25) {
         Monster monster = new Monster();
         Fight fight = new Fight();
         
         System.out.println("You've found a monster!\n\nHealth: " + monster.health +
               "\tDamage: " + monster.damage + "\tAccuracy: " + monster.accuracy);
         
         player.setFight(true);
         fight.initiate(player, monster);
      } else if (roll <= 55) {
         JSONObject food = GameService.findFood();
         
         if (food == null) {
            System.out.println("ERROR: COULDNT FIND FOOD" + food);
         }
         
         player.giveFood(food);
         
         System.out.println("You went searching " + (food.get("name").equals("Gapple (God Apple)") ? 
               "and found a " : "and hunted for ") + food.get("name") + "!");
      } else if (roll <= 75) {
         JSONObject weapon = GameService.findWeapon();
         
         if (weapon == null) {
            System.out.println("ERROR: COULDNT FIND WEAPON" + weapon);
         }
         
         player.giveWeapon(weapon);
         
         System.out.println("You've found a " + weapon.get("name") + "!");
      } else {
         System.out.println("You walked around and enjoyed nature :)");
      }
      
      int experience = Utility.Random.nextInt(1, 5);
      player.setExperience(player.getExperience() + experience);
      
      System.out.println("Gained " + experience + " experience");
   }
}
