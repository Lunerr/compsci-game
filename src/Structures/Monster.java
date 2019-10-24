package Structures;

import Utility.Utility;

public class Monster {
   public int health = Utility.nextInt(30, 500);
   public int damage = Utility.nextInt(5, 25);
   public int accuracy = Utility.nextInt(15, 50);
}
