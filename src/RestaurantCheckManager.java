import java.util.Scanner;

public class RestaurantCheckManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalSales = 0;
        double pooledTips = 0;
        int numChecks = 0;

        while (true) {
            System.out.print("Enter total check amount: ");
            double checkAmount = scanner.nextDouble();

            if (checkAmount == 0) {
                break;
            }

            System.out.print("Enter tip amount: ");
            double tipAmount = scanner.nextDouble();

            System.out.print("Enter total amount: ");
            double totalAmount = scanner.nextDouble();

            totalSales += totalAmount;
            pooledTips += tipAmount;
            numChecks++;

            System.out.println("Total Sales so far: " + String.format("%.2f", totalSales));
            System.out.println("Current pooled tips so far: " + String.format("%.2f", pooledTips));
            System.out.println("Number of Checks:   " + numChecks);

            System.out.print("Do you want to stop(y/n)? ");
            char choice = scanner.next().charAt(0);

            if (choice == 'y' || choice == 'Y') {
                break;
            }
        }

        // Tip allocation
        System.out.println("Tip allocation for $" + String.format("%.2f", pooledTips) + " in tips.");

        double serverTip = pooledTips * 0.5;
        double kitchenTip = pooledTips * 0.3;
        double hostessTip = pooledTips * 0.1;
        double busserTip = pooledTips * 0.1;

        System.out.println("Servers              : $" + String.format("%.2f", serverTip));
        System.out.println("       Server 1      : $" + String.format("%.2f", serverTip / 2));
        System.out.println("       Server 2      : $" + String.format("%.2f", serverTip / 2));
        System.out.println("       Server 3      : $0.00    (did not work)");
        System.out.println("Kitchen              : $" + String.format("%.2f", kitchenTip));
        System.out.println("       Chef          : $" + String.format("%.2f", kitchenTip * 0.4));
        System.out.println("       Sous-Chef     : $" + String.format("%.2f", kitchenTip * 0.3));
        System.out.println("       Kitchen Aid   : $" + String.format("%.2f", kitchenTip * 0.2));
        System.out.println("Host/Hostess         : $" + String.format("%.2f", hostessTip));
        System.out.println("Busser               : $" + String.format("%.2f", busserTip));
    }
}
