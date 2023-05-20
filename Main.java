package pkg08handsonact_taleon;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your student number:");
            String id = input.nextLine();
            
            Pattern a = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{3}");
            Matcher m = a.matcher(id);
            
            if(m.matches()==true){
                
            System.out.println(id);
            System.out.println("You have succesfyully logged in!");
            System.out.println("Welcome to your dashboard");
                
            }
            else{
                System.out.print("Error: Input valid student id number");
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
}
