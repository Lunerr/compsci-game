package Structures;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Player {
   private int level;
   private int experience;
   private int health;
   private int strength;
   private int dexterity;
   private int accuracy;
   private boolean active_fight = false;
   private JSONObject active_weapon = new JSONObject();
   private JSONArray weapons = new JSONArray();
   private JSONArray food = new JSONArray();
   
   public Player(int level, int experience, int health, int strength, int dexterity, int accuracy) {
      this.level = level;
      this.experience = experience;
      this.health = health;
      this.strength = strength;
      this.dexterity = dexterity;
      this.accuracy = accuracy;
   }
   
   public void setLevel(int level) {
      this.level = level;
   }
   
   public void setExperience(int experience) {
      this.experience = experience;
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
   
   public int getLevel() {
      return level;
   }
   
   public int getExperience() {
      return experience;
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
   
   public JSONArray getWeapons() {
      return weapons;
   }
   
   public JSONArray getFood() {
      return food;
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
      JSONObject newItem = (JSONObject)weapons.get(weapons.indexOf(item));
      
      weapons.remove(newItem);
      
      int durability = (int)newItem.get("durability") + damage;
      
      newItem.replace("durability", durability);
      
      if (durability <= 0) {
         return null;
      }
      
      giveWeapon(newItem);
      
      return newItem;
   }
   
   public JSONArray removeWeapon(JSONObject weapon) {
      weapons.remove(weapon);
      
      return weapons;
   }
   
   public JSONArray giveWeapon(JSONObject weapon) {
      weapons.add(weapon);
      
      return weapons;
   }
   
   public JSONArray removeFood(JSONObject foodItem) {
      food.remove(foodItem);
      
      return food;
   }
   
   public JSONArray giveFood(JSONObject foodItem) {
      food.add(foodItem);
      
      return food;
   }
}
