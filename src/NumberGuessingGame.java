import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(1,100);
        System.out.println("Welcome to the number guessing Game!");
        while (true) {
            System.out.print("Please guess a number: ");
            int user_number = scanner.nextInt();
            if(user_number > numberToGuess){
                System.out.println("Your guess is too high!");
            }else if(user_number < numberToGuess){
                System.out.println("Your guess is too low!");
            }else {
                System.out.println("Yes the number is "+numberToGuess);
                break;
            }
        }
    }
}
