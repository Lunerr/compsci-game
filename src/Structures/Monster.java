package Structures;

public class Monster {
   public int health = Utility.Random.nextInt(30, 500);
   public int damage = Utility.Random.nextInt(5, 25);
   public int accuracy = Utility.Random.nextInt(15, 50);
}
