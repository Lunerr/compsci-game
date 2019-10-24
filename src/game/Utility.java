package game;

public class Utility {
   static int nextInt(int min, int max) {
      return (int)(Math.floor(Math.random() * (max - min)) + min);
   }
   
   static int roll() {
      return nextInt(0, 100);
   }
}
