package foodmenu;
import java.util.*;

public class FoodMenu {
    private String name, itemName;
    private double price, newPrice;
    Scanner sc1 = new Scanner(System.in);
    public FoodMenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    public void addItems(){
        System.out.println("=============");
        System.out.println("Enter new menu item name: ");
        name = sc1.next();
        System.out.println("Enter new menu item price: ");
        price = sc1.nextDouble();
    }
    public void editPrice(String n, double p){
      System.out.println("Enter menu item name: ");
      itemName = sc1.next();
      if(itemName.equals(name)){
          System.out.println("Enter new menu item price: ");
          newPrice = sc1.nextDouble();
          price = newPrice;
      }else{
          System.out.println("Error: item is not on the menu");
      }
    }
    public void displayMenu(){
        System.out.println("=============");
        System.out.println("Current Menu:");
        System.out.println(name + " :$" + price);
        System.out.println("=============");
    }
    public static void main(String[] args) {
        FoodMenu menu = new FoodMenu("", 10);
        Scanner sc2 =new Scanner(System.in);
        boolean running = true;
        while(running){
        System.out.println("==={Menu}===");
        System.out.println("1. Insert");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("============");
        int choice = sc2.nextInt();
        
        switch(choice){
            case 1:
                menu.addItems();
                break;
            case 2:
                menu.editPrice("", 0);
                break;
            case 3:
                menu.displayMenu();
                break;
            case 4:
                System.out.println("Closing menu");
                running = false;
                break;
            default:
                System.out.println("Error: invalid intput");
        }
        }
        }
    }    
