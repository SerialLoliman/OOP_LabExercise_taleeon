package foodmenu;
import java.util.*;

public class FoodMenu {
    private String name;    
    private double price; 
    
    public FoodMenu(String n, double p){
        this.name = n;
        this.price = p;
    }
    public void display(String n, double p){
        System.out.println("=============");
        System.out.println("Current Menu:");
        System.out.println(name + " :$" + price);
        System.out.println("=============");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
                System.out.println("=============");
                System.out.println("Enter new menu item name: ");
                String name = scan.next();
                System.out.println("Enter new menu item price: ");
                double price = scan.nextDouble();
                FoodMenu menu = new FoodMenu(name, price);
            break;
            case 2:
                System.out.println("Enter item name: ");
                scan.next();
                name = scan.next();
                if(name.equals(name)){
                    System.out.println("Error: Item is not on the menu");
                }else{
                    System.out.println("Enter item's new price: ");
                    scan.nextDouble();
                    price = scan.nextDouble();
                }
            break;
            case 3:
                System.out.println("=============");
                System.out.println("Current Menu:");
                System.out.println();
                System.out.println("=============");
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
