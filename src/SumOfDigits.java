import java.util.Scanner;

public class SumOfDigits {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your 3 digits number: ");
        int number, lengthOfnumber, sum  = 0;
        try {
            number = scanner.nextInt();
            lengthOfnumber = (int) Math.round(Math.log10(number) + 1);
        } catch (Exception e) {
            System.out.println("Not number, default 321");
            number = 321;
            lengthOfnumber = (int) Math.round(Math.log10(number) + 1);
        }
        
        for (int i = 0; i < lengthOfnumber; i++) {
            int power = (int) Math.pow(10, i); 
            int digit = (number / power) % 10;
            sum += digit;
        }
        System.out.println(number+" has the sum of digits of: "+sum);
    }
}
