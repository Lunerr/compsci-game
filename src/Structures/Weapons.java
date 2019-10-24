package Structures;

import java.io.File;
import java.util.ArrayList;

public class Weapons {
   public ArrayList<Object> weapons = new ArrayList<Object>();
   
   public void addItems() {
      File dir = new File("../Weapons");
      File[] directory = dir.listFiles();
      
      if (directory != null) {
         for (File file : directory) {
            weapons.add(file.)
         }
      }
   }
}
