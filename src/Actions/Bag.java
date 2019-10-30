package Actions;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Main.Game;
import Structures.Monster;
import Structures.Player;

public class Bag {
   public static void displayBag(Player player, Monster monster) {
      JSONArray weapons = player.getWeapons();
      JSONArray food = player.getFood();
      
      if (weapons.isEmpty() && food.isEmpty()) {
         System.out.println("\nYou have nothing in your inventory.");
      } else {
         if (player.getWeapon().isEmpty() && weapons.isEmpty() == false) {
            System.out.println("You have no active weapon");
         } else {
            System.out.println("Active Weapon: " + player.getWeapon().get("name"));
         }
         
         String inv = "\nYour inventory contains:\n";
         String weaponsString = "";
         String foodString = "";
         String addItem = "";
         
         if (weapons.isEmpty() == false) {
            inv += "Weapons:\n";
            
            for (int i = 0; i < weapons.size(); i++) {
               JSONObject weapon = (JSONObject)weapons.get(i);
               String name = (String)weapon.get("name");
               
               inv += name + ": " + weapon.get("damage") + " damage, " 
                     + weapon.get("accuracy") + "% accuracy, " + weapon.get("durability") + " durability\n";
               
               weaponsString += i + 1 + ". " + name + "\t";
            }
            
            inv += "\n";
         }
         
         if (food.isEmpty() == false) {
            inv += "Food:\n";
            
            for (int x = 0; x < food.size(); x++) {
               JSONObject foodItem = (JSONObject)food.get(x);
               String name = (String)foodItem.get("name");
               
               inv += name + ": " + foodItem.get("health") + " health regeneration\n";
               
               foodString += x + 1 + ". " + name + "\t";
            }
         }
         
         System.out.println(inv);
         
         int options = 1;
         int weaponOption = 1;
         int eatOption = 1;
         int exitOption = 1;
         
         String bagChoices = "";
         
         if (weapons.isEmpty() == false) {
            weaponOption = options++;
            
            bagChoices += weaponOption + ". Set new main weapon\t";
         }
         
         if (food.isEmpty() == false) {
            eatOption = options++;
            
            bagChoices += eatOption + ". Eat\t";
         }
         
         exitOption = options;
         
         System.out.println(bagChoices + exitOption + ". Exit bag");
         
         Scanner consoleChoice = new Scanner(System.in);
         int choice = consoleChoice.nextInt();
         
         if (choice == weaponOption && weapons.isEmpty() == false) {
            System.out.println("Choose: " + weaponsString);
            
            Scanner weaponChoice = new Scanner(System.in);
            
            JSONObject weapon = (JSONObject)weapons.get(weaponChoice.nextInt() - 1);
            
            player.setWeapon(weapon);
         } else if (choice == eatOption && food.isEmpty() == false) {
            System.out.println("Choose: " + foodString);
            
            Scanner foodChoice = new Scanner(System.in);
            
            JSONObject foodItem = (JSONObject)food.get(foodChoice.nextInt() - 1);
            
            player.modifyHealth((int)foodItem.get("health"));
            player.removeFood(foodItem);
            
            System.out.println("You ate a " + foodItem.get("name") + " for " + foodItem.get("health") + " health\n"
                  + "New Health: " + player.getHealth());
         } else {
            boolean fighting = player.getFight();
            
            if (fighting == true) {
               Fight fight = new Fight();
               
               fight.initiate(player, monster);
            } else {
               Game game = new Game();
               
               game.initiate(player);
            }
         }
      }
   }
}
