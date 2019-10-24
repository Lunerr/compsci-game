package Structures;

public class Player {
   private int health;
   private int strength;
   private int dexterity;
   private int accuracy;
   
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
   
   public int modifyHealth(int healthLost) {
      int newHealth = this.getHealth() - healthLost;
      
      this.setHealth(newHealth);
      
      return this.getHealth();
   }
}
