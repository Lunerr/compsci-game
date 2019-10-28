package Actions;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Main.Game;
import Structures.Monster;
import Structures.Player;

public class Bag {
   public static void displayBag(Player player, Monster monster) {
      JSONArray inventory = player.getInventory();
      
      if (player.getWeapon().isEmpty()) {
         System.out.println("You have no active weapon");
      } else {
         System.out.println("Active Weapon: " + player.getWeapon().get("name"));
      }
      
      if (inventory.isEmpty()) {
         System.out.println("\nYou have nothing in your inventory.");
      } else {
         String inv = "\nYour inventory contains:\n";
         String weapons = "";
         String food = "";
         
         for (int i = 0; i < inventory.size(); i++) {
            JSONObject item = (JSONObject)inventory.get(i);
            String type = (String)item.get("type");
            String name = (String)item.get("name");
            
            String addItem = type.equals("Weapon") ? name + " with " + item.get("damage")
                  + " damage and " + item.get("accuracy") + "% accuracy\n" : name
                  + " with " + item.get("health") + " health regeneration\n";
            
            inv += addItem;

            if (type.equals("Weapon")) {
               weapons += i + 1 + ". " + name + " " + item.get("durability") + "%\t";
            } else {
               food += i + 1 + ". " + name + "\t";
            }
         }
         
         System.out.println(inv.substring(0, inv.length() - 1) + ".");
         
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
            System.out.println("Choose: " + weapons);
            
            Scanner weaponChoice = new Scanner(System.in);
            
            JSONObject weapon = (JSONObject)inventory.get(weaponChoice.nextInt() - 1);
            
            player.setWeapon(weapon);
         } else if (choice == eatOption && food.isEmpty() == false) {
            System.out.println("Choose: " + food);
            
            Scanner foodChoice = new Scanner(System.in);
            
            JSONObject foodItem = (JSONObject)inventory.get(foodChoice.nextInt() - 1);
            
            player.modifyHealth((int)foodItem.get("health"));
            player.removeItem(foodItem);
            
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
