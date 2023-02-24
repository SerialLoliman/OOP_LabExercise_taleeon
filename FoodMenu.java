package foodmenu;
import java.util.*;

public class FoodMenu {
    
    public Map <String, Double> items;
    
    public FoodMenu(){
        items = new HashMap<>();
        
    }
    
    public void addItem(String n, double p){
        
        if(items.containsKey(n)){
            System.out.println("Error: " +  n + " is already on the menu");
        }else{
            items.put(n, p);
            System.out.println("Added item : " + n + " to the menu for $ : " + p  );
        
        }
    }
    
    public void editItem(String n, double p){
        
        if (items.containsKey(n)){
            items.put(n, p);
        System.out.println("Changed price of : " + n + " to $ : " + p);
        }else{
            System.out.println("Error: " +  n + " is not on the menu");
        }  
    }
    
    public void displayMenu(){
        
        if(items.isEmpty()){
            System.out.println("Error: The menu is empty");
        }else{
        System.out.println("==={Current Men}===: ");
        for(Map.Entry<String, Double>entry : items.entrySet()){
        System.out.println(entry.getKey() + " $: " + entry.getValue());
        }
        }
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        FoodMenu menu = new FoodMenu();
        boolean running = true;
        
        while(running){
        System.out.println("==={Menu}===");
        System.out.println("1. Insert");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Exit");
        System.out.println("============");
        
        int MenuChoices = scan.nextInt();
        
        switch(MenuChoices){
            
            case 1 -> {
                System.out.println("============");
                System.out.println("Enter new menu item name:  ");
                String NewName = scan.next();
                System.out.println("Enter new menu item price: ");
                double NewPrice = scan.nextDouble();
                menu.addItem(NewName, NewPrice);
                }
               
            case 2 -> {
                System.out.println("============");
                System.out.println("Enter menu item name:  ");
                String EditedName = scan.next();
                System.out.println("Enter new menu item price: ");
                double EditedPrice = scan.nextDouble();
                menu.editItem(EditedName, EditedPrice);
                }
                
            case 3 -> menu.displayMenu();
                
            case 4 -> {
                System.out.println("Closing Menu, Thank You");
                running = false;
                break;
                }
            default -> System.out.println("Error: Invalid Choice, Try Again");
        }
        }
    }
}
