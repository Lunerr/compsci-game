package Utility;

public class Utility {
   public static int nextInt(int min, int max) {
      return (int)(Math.floor(Math.random() * (max - min)) + min);
   }
   
   public static int roll() {
      return nextInt(0, 100);
   }
}
