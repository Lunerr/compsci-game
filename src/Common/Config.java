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
   }
   
   public static void weaponsInitiate() {
      weapons.add(addGun(butterfly_knife.name, butterfly_knife.type, butterfly_knife.damage, butterfly_knife.accuracy, butterfly_knife.odds));
      weapons.add(addGun(huntsman_knife.name, huntsman_knife.type, huntsman_knife.damage, huntsman_knife.accuracy, huntsman_knife.odds));
      weapons.add(addGun(kitchen_knife.name, kitchen_knife.type, kitchen_knife.damage, kitchen_knife.accuracy, kitchen_knife.odds));
      weapons.add(addGun(m9_bayonet.name, m9_bayonet.type, m9_bayonet.damage, m9_bayonet.accuracy, m9_bayonet.odds));
      weapons.add(addGun(karambit.name, karambit.type, karambit.damage, karambit.accuracy, karambit.odds));
   }
   
   public static void foodInitiate() {
      food.add(addFood(gapple.name, gapple.type, gapple.health, gapple.odds));
      food.add(addFood(bear_meat.name, bear_meat.type, bear_meat.health, bear_meat.odds));
      food.add(addFood(beef.name, beef.type, beef.health, beef.odds));
      food.add(addFood(chicken.name, chicken.type, chicken.health, chicken.odds));
   }

   public static JSONObject addGun(String name, String type, int damage, int accuracy, int odds) {
      JSONObject weapon = new JSONObject();
      weaponsOdds += odds;
      
      weapon.put("name", name);
      weapon.put("type", type);
      weapon.put("damage", damage);
      weapon.put("accuracy", accuracy);
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
