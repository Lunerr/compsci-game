package Services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Common.Config;
import Utility.Sort_Ascending;

public class GameService {
   public static JSONObject findFood() {
      JSONArray foods = Config.food;
      
      foods.sort(new Sort_Ascending());
      
      int cumulative = 0;
      int roll = Utility.Random.nextInt(1, Config.foodOdds);
      
      for (Object x : foods) {
         JSONObject food = (JSONObject)x;
         
         cumulative += (int)food.get("odds");
         
         if (roll < cumulative) {
            return food;
         }
      }
      
      return null;
   }
   
   public static JSONObject findWeapon() {
      JSONArray weapons = Config.weapons;
      
      weapons.sort(new Sort_Ascending());
      
      int cumulative = 0;
      int roll = Utility.Random.nextInt(1, Config.weaponsOdds);
      
      for (Object x : weapons) {
         JSONObject weapon = (JSONObject)x;
         
         cumulative += (int)weapon.get("odds");
         
         if (roll < cumulative) {
            return weapon;
         }
      }
      
      return null;
   }
}
