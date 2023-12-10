import java.io.Console;
import java.util.Scanner;

public class App {
    static Console console = System.console();
    static Scanner scanner = new Scanner(System.in);

    public static int max(int a, int b){
        if(a < b){
           return b;
        } else { 
           return a;
        }
     }

     static void doubleValue(int value){
        value = (value * 2);
    }
    public static void main(String[] args) {
        int x = 3;
        doubleValue(x);
        System.out.println(x);
        // max('a', 'b');
        
        // circlePerimeter(args);
        // trianglePerimeter(args);
    }
    public static void circlePerimeter(String[] args) {
        String inputMessage =  console.readLine("Enter your radius of Circle to find perimeter: ");
        Float number = Float.parseFloat(inputMessage);
        double perimeterOfCircle = (number * 2 * (3.14159265359)) ;
        System.out.println("The perimeter of a Circle of radius: "+ inputMessage+ " is: "+ perimeterOfCircle);
    }
    public static void trianglePerimeter(String[] args) {
        System.out.println("Enter your sides of Triangle to find perimeter");
        Float firstSide =  Float.parseFloat(console.readLine("Your first side: "));
        Float secondSide =  Float.parseFloat(console.readLine("Your second side: "));
        Float thirdSide =  Float.parseFloat(console.readLine("Your third side: "));

        double perimeterOfTriangle= (firstSide+secondSide+thirdSide) ;
        System.out.println("The perimeter of a Triangle with sides: "+ firstSide+secondSide+thirdSide+ " is: "+ perimeterOfTriangle);
    }
}