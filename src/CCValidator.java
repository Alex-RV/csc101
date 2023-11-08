import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a credit card number: ");

            if (scanner.hasNextLong()) {
                long creditCardNumber = scanner.nextLong();

                if (isValidCreditCard(creditCardNumber)) {
                    System.out.println(creditCardNumber + " is a valid credit card number.");
                } else {
                    System.out.println(creditCardNumber + " is an invalid credit card number.");
                }
                break;
            } else {
                System.out.println("You did not enter a number");
                scanner.next();
            }
        }
    }

    public static boolean isValidCreditCard(long creditCardNumber) {
        String creditCardStr = Long.toString(creditCardNumber);

        if (creditCardStr.length() < 13 || creditCardStr.length() > 16) {
            return false;
        }

        char firstDigit = creditCardStr.charAt(0);
        if (!(firstDigit == '4' || firstDigit == '5' || firstDigit == '3' || firstDigit == '6')) {
            return false;
        }

        int sum = 0;

        for (int i = creditCardStr.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(creditCardStr.charAt(i));

            if (i % 2 == creditCardStr.length() % 2) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
        }

        return sum % 10 == 0;
    }
}