package Structures;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Player {
   private int health;
   private int strength;
   private int dexterity;
   private int accuracy;
   private boolean active_fight = false;
   private JSONObject active_weapon = new JSONObject();
   private JSONArray inventory = new JSONArray();
   
   public Player(int health, int strength, int dexterity, int accuracy) {
      this.health = health;
      this.strength = strength;
      this.dexterity = dexterity;
      this.accuracy = accuracy;
   }
   
   public void setHealth(int health) {
      this.health = health;
   }
   
   public void setStrength(int strength) {
      this.strength = strength;
   }
   
   public void setDexterity(int dexterity) {
      this.dexterity = dexterity;
   }
   
   public void setAccuracy(int accuracy) {
      this.accuracy = accuracy;
   }
   
   public void setWeapon(JSONObject weapon) {
      this.active_weapon = weapon;
   }
   
   public void setFight(boolean fight) {
      this.active_fight = fight;
   }
   
   public int getHealth() {
      return health;
   }
   
   public int getStrength() {
      return strength;
   }
   
   public int getDexterity() {
      return dexterity;
   }
   
   public int getAccuracy() {
      return accuracy;
   }
   
   public boolean getFight() {
      return active_fight;
   }
   
   public JSONArray getInventory() {
      return inventory;
   }
   
   public JSONObject getWeapon() {
      return active_weapon;
   }
   
   public int modifyHealth(int health) {
      int newHealth = this.getHealth() + health;
      
      this.setHealth(newHealth);
      
      return this.getHealth();
   }
   
   public JSONObject modifyDurability(JSONObject item, int damage) {
      JSONObject newItem = (JSONObject)inventory.get(inventory.indexOf(item));
      
      inventory.remove(newItem);
      
      int durability = (int)newItem.get("durability") - damage;
      
      newItem.replace("durability", durability);
      
      giveItem(newItem);
      
      return newItem;
   }
   
   public JSONArray removeItem(JSONObject item) {
      inventory.remove(item);
      
      return inventory;
   }
   
   public JSONArray giveItem(JSONObject item) {
      inventory.add(item);
      
      return inventory;
   }
}
