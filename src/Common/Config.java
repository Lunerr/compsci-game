package Common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Food.BearMeat;
import Food.Beef;
import Food.Chicken;
import Food.Gapple;
import Weapons.ButterflyKnife;
import Weapons.HuntsmanKnife;
import Weapons.Karambit;
import Weapons.KitchenKnife;
import Weapons.M9Bayonet;

public class Config {
   public static JSONArray weapons = new JSONArray();
   public static JSONArray food = new JSONArray();
   public static JSONArray levels = new JSONArray();
   
   public static int weaponsOdds = 0;
   public static int foodOdds = 0;
   
   static ButterflyKnife butterfly_knife = new ButterflyKnife();
   static HuntsmanKnife huntsman_knife = new HuntsmanKnife();
   static KitchenKnife kitchen_knife = new KitchenKnife();
   static M9Bayonet m9_bayonet = new M9Bayonet();
   static Karambit karambit = new Karambit();
   
   static Gapple gapple = new Gapple();
   static BearMeat bear_meat = new BearMeat();
   static Beef beef = new Beef();
   static Chicken chicken = new Chicken();
   
   public static void initiate() {
      weaponsInitiate();
      foodInitiate();
      levelsInitiate();
   }
   
   public static void weaponsInitiate() {
      weapons.add(addGun(butterfly_knife.name, butterfly_knife.type, butterfly_knife.damage, butterfly_knife.accuracy, butterfly_knife.durability, butterfly_knife.odds));
      weapons.add(addGun(huntsman_knife.name, huntsman_knife.type, huntsman_knife.damage, huntsman_knife.accuracy, huntsman_knife.durability, huntsman_knife.odds));
      weapons.add(addGun(kitchen_knife.name, kitchen_knife.type, kitchen_knife.damage, kitchen_knife.accuracy, kitchen_knife.durability, kitchen_knife.odds));
      weapons.add(addGun(m9_bayonet.name, m9_bayonet.type, m9_bayonet.damage, m9_bayonet.accuracy, m9_bayonet.durability, m9_bayonet.odds));
      weapons.add(addGun(karambit.name, karambit.type, karambit.damage, karambit.accuracy, karambit.durability, karambit.odds));
   }
   
   public static void foodInitiate() {
      food.add(addFood(gapple.name, gapple.type, gapple.health, gapple.odds));
      food.add(addFood(bear_meat.name, bear_meat.type, bear_meat.health, bear_meat.odds));
      food.add(addFood(beef.name, beef.type, beef.health, beef.odds));
      food.add(addFood(chicken.name, chicken.type, chicken.health, chicken.odds));
   }
   
   public static void levelsInitiate() {
      int level = 2;
      int xpNeeded = 0;
      int strengthIncrease = 0;
      int accuracyIncrease = 0;
      int dexterityIncrease = 0;
      
      for (int i = 0; i < 15; i++) {
         xpNeeded += Utility.Random.nextInt(10, 30);
         strengthIncrease += Utility.Random.nextInt(5, 10);
         accuracyIncrease += Utility.Random.nextInt(5, 10);
         dexterityIncrease += Utility.Random.nextInt(5, 10);
         
         levels.add(addLevel(level, xpNeeded, strengthIncrease, accuracyIncrease, dexterityIncrease));
         
         level++;
      }
   }
   
   public static JSONObject addLevel(int levelNumber, int xpNeeded, int strengthIncrease, int accuracyIncrease, int dexterityIncrease) {
      JSONObject level = new JSONObject();
      
      level.put("level", levelNumber);
      level.put("xpNeeded", xpNeeded);
      level.put("strengthIncrease", strengthIncrease);
      level.put("accuracyIncrease", accuracyIncrease);
      level.put("dexterityIncrease", dexterityIncrease);
      
      return level;
   }

   public static JSONObject addGun(String name, String type, int damage, int accuracy, int durability, int odds) {
      JSONObject weapon = new JSONObject();
      weaponsOdds += odds;
      
      weapon.put("name", name);
      weapon.put("type", type);
      weapon.put("damage", damage);
      weapon.put("accuracy", accuracy);
      weapon.put("durability", durability);
      weapon.put("odds", odds);
      
      return weapon;
   }
   
   public static JSONObject addFood(String name, String type, int health, int odds) {
      JSONObject food = new JSONObject();
      foodOdds += odds;
      
      food.put("name", name);
      food.put("health", health);
      food.put("type", type);
      food.put("odds", odds);
      
      return food;
   }
}
