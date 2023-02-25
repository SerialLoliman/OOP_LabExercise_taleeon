
package rectangle;
import java.util.*;
public class Rectangle {
    
    public class Area{
        
        private double length;
        private double width;
         
    }
    
    private void getLength(double length){
        this.getLength(length);
        
    }
    
    private void getWidth(double width){
        this.getWidth(width);
        
    }
    private void getArea(double length, double width){
        int a = (int) (length * width);
    }
    
    public static void main(String[]args){
     Scanner scanlength = new Scanner(System.in);
     System.out.println("Enter length");
    double l = scanlength.nextDouble();
     Scanner scanwidth = new Scanner(System.in);
     System.out.println("Eneter width");
    double w = scanwidth.nextDouble();
    
    int a = (int) (l * w);
     System.out.println(a);
     
     
    }
}