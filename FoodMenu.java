package foodmenu;
import java.util.*;
public class FoodMenu {
    private String name;    
    private double price; 
    
    public FoodMenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    
    public void display(){
        System.out.println("=============");
        System.out.println("Current Menu:");
        System.out.println(name + " :$" + price);
        System.out.println("=============");
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        FoodMenu menu = null;
        String itemName = "";
        while(running){
            System.out.println("==={Menu}===");
            System.out.println("1. Insert");
            System.out.println("2. Edit");
            System.out.println("3. View");
            System.out.println("4. Exit");
            System.out.println("============");
            int choice = scan.nextInt();
        
            switch(choice){
                case 1:
                    System.out.println("=============");
                    System.out.println("Enter new menu item name: ");
                    String name = scan.next();
                    System.out.println("Enter new menu item price: ");
                    double price = scan.nextDouble();
                    menu = new FoodMenu(name, price);
                break;
                case 2:
                    System.out.println("Enter item name: ");
                    itemName = scan.next();
                    if(itemName.equals(menu.name)){
                        System.out.println("Enter item's new price: ");
                        double newPrice = scan.nextDouble();
                        menu.price = newPrice;
                    } else {
                        System.out.println("Error: Item is not on the menu");
                    }
                break;
                case 3:
                    System.out.println("=============");
                    System.out.println("Current Menu:");
                    if (menu != null) {
                        menu.display();
                    }
                    System.out.println("=============");
                break;
                case 4:
                    System.out.println("Closing menu");
                    running = false;
                break;
                default:
                    System.out.println("Error: invalid input");
            }
        }
    }
}