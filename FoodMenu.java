package foodmenu;
import java.util.*;
public class FoodMenu {
    private String name;
    private double price;
    
    public FoodMenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    public void addItems(String n, double p){
        this.name = n;
        this.price = p;
        System.out.println("Added: " + n + " to the menu for: $" + p);
    }
    public void editPrice(String n, double p){
       this.price = p;
       System.out.println("Changed price of: " + n + " to: $" + p);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FoodMenu[] menu = new FoodMenu[10];
        boolean running = true;
        
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
                for(int i = 0; i < menu.length; i++){
                 System.out.println("Enter new menu item name: ");
                 String newName = scan.next();
                 System.out.println("Enter new menu item price: ");
                 double newPrice = scan.nextDouble();
                 boolean exists = false;
                for(int ib = 0; ib < i; ib++){
                    if(menu[ib].name.equals(newName)){
                        System.out.println("Error: item already on menu");
                        exists = true;
                        break;
                    }
                }
                    if(!exists){
                        menu[i] = new FoodMenu(newName, newPrice);
                        System.out.println("Added: " + newName + " for: $" + newPrice);
                    }
                }
                break;
            case 2:
                System.out.println("Enter item name");
                String itemName = scan.next();
                int index = -1;
                for(int ii = 0; ii < menu.length; ii++){
                    if(menu[ii].name.equals(itemName)){
                        index = ii;
                        break;
                    }
                }
                if(index == -1){
                    System.out.println("Error: item not found");
                }else{
                    System.out.println("Enter new item price");
                    double newPrice = scan.nextDouble();
                    menu[index].editPrice(itemName, newPrice);
                }
                break;
            case 3:
                for(int iii = 0; iii < menu.length; iii++){
                    if(menu != null){
                        System.out.println(menu[iii].name + " $" + menu[iii].price);
                    }
                }
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
