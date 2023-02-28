package foodmenu;
import java.util.*;
public class FoodMenu {
    private String name = "";
    private double price = 0.00;
    
    public FoodMenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    
    public void addItems(String n, double p){
       
            if(n.equals(name)){
                System.out.println("Error: " + n + " is already on the menu");
            }else{
                System.out.println("Added: " + n + " to the menu for the price of: " + p);
            }
        }
    
    public void editPrice(String n, double p){
        if(n.equals(name)){
            price = p;
            System.out.println("Edited: " + n + "'s prive to: " + p);
        }else{
            System.out.println("Error: " + n + " is not on the menu");
        }
    }
    
    public void displayMenu(){
        if(name.equals("")){
            System.out.println("Error: The menu is empty");
        }else{
        System.out.println("==={Current Menu}===: ");
        System.out.println(name + ": $" + price);
        System.out.println("====================: ");
        }
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FoodMenu menu = new FoodMenu("", 0.00);
        System.out.println("==={Menu}===");
        System.out.println("1. Insert");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("============");
        int MenuChoices = scan.nextInt();
        
        switch(MenuChoices){
            case 1:
                System.out.println("============");
                System.out.println("Enter new menu item name:  ");
                String newName = scan.next();
                System.out.println("Enter new menu item price: ");
                double newPrice = scan.nextDouble();
                menu.addItems(newName, newPrice);
                break;
            case 2:
                System.out.println("============");
                System.out.println("Enter menu item name:  ");
                String itemName = scan.next();
                System.out.println("Enter new menu item price: ");
                double editedPrice = scan.nextDouble();
                menu.editPrice(itemName,editedPrice);
                break;
            case 3:
                menu.displayMenu();
                break;
            case 4:
                System.out.println("Closing Menu, Thank You");
                break;
                default:
                System.out.println("Error: Invalid Choice, Try Again");
        }    
    }
}
