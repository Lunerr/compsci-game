package game;

public class Player {
   public static int health = 100;
   public static int strength = Utility.nextInt(15, 30);
   public static int dexterity = 1;
   public static int accuracy = 35;
   
   public static int modifyHealth(int healthLost) {
      int newHealth = health - healthLost;
      
      health = newHealth;
      
      return health;
   }
}
