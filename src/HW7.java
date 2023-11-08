import java.io.Console;

public class HW7 {
    static Console console = System.console();
    public static void main(String[] args) {
        sphereVolume(args);
        trianglePerimeter(args);
    }
    public static void sphereVolume(String[] args) {
        String inputMessage =  console.readLine("Enter your radius of Sphere to find volume: ");
        try {
            Float number = Float.parseFloat(inputMessage);
            double perimeterOfSphere = ((Math.pow(number, 3)) * (1.33333333333) * (3.14159265359));
            System.out.println("The perimeter of a Circle of radius: "+ inputMessage+ " is: "+ perimeterOfSphere);
        } catch (Exception e) {
            System.out.println("Wrong input, expected number "+ inputMessage);
            double number = 5.400000;
            double perimeterOfSphere = ((Math.pow(number, 3)) * (1.33333333333) * (3.14159265359));
            System.out.println("Calculating with default. ");
            System.out.println("Volume of a Sphere with radius: "+ number+ " is: "+ perimeterOfSphere);
        }
    }
    public static void trianglePerimeter(String[] args) {
        System.out.println("Enter your sides of Triangle to find perimeter");
        try {
            Float base =  Float.parseFloat(console.readLine("Your base side: "));
            Float height =  Float.parseFloat(console.readLine("Your height side: "));
            Float length =  Float.parseFloat(console.readLine("Your length side: "));
            double volumeOfPrism= (0.5*base*height*length) ;
            System.out.println("The volume of a Triangular Prism with base: "+ base+" height: "+height+" length: "+length+ " is: "+ volumeOfPrism);
        } catch (Exception e) {
            System.out.println("Wrong input, expected number ");
            double base = 4.000000;
            double height = 3.000000;
            double length = 5.000000;
            System.out.println("Calculating with default. ");
            double volumeOfPrism= (0.5*base*height*length) ;
            System.out.println("The volume of a Triangular Prism with base: "+ base+" height: "+height+" length: "+length+ " is: "+ volumeOfPrism);
        }
    }
}
