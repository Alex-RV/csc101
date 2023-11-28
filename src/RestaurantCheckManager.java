import java.util.Scanner;
import java.util.HashMap;

class EmployeeInfo {
    private String title;
    private int numberOfEmployees;
    private int numberOfEmployeesToday;
    private int percentageOfTips;
    private double tipAmount;

    public EmployeeInfo(String title, int numberOfEmployees, int numberOfEmployeesToday, int percentageOfTips, double tipAmount) {
        this.title = title;
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfEmployeesToday = numberOfEmployeesToday;
        this.percentageOfTips = percentageOfTips;
        this.tipAmount = tipAmount;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getNumberOfEmployeesToday() {
        return numberOfEmployeesToday;
    }

    public int getPercentageOfTips(){
        return percentageOfTips;
    }

    public double getTipAmount() {
        return tipAmount;
    }
}


public class RestaurantCheckManager {
    public static Scanner scanner = new Scanner(System.in);

    // output : [0]-totalSales, [1]-pooledTips, [2]-numChecks
    static double[] AskForData(){
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
        double[] output = {totalSales, pooledTips, numChecks};
        return output;
    }

    static HashMap<String, EmployeeInfo> InitializeEmployees(){
        HashMap<String, EmployeeInfo> employees = new HashMap<String, EmployeeInfo>();
        employees.put("Servers", new EmployeeInfo("Server", 3, 2, 60, 0));
        employees.put("Kitchen", new EmployeeInfo("Kitchen", 3, 3, 25, 0));
        // host/hostess and the busser
        employees.put("HHB", new EmployeeInfo("HHB", 2, 2,15, 0));
        return employees;
    }

    static void MakeOutput(double[] tips){
        double serverTip = tips[0];
        double kitchenTip = tips[1];
        double HHBTip = tips[2]; 
        double pooledTips = tips[3];

        // Tip allocation
        System.out.println("Tip allocation for $" + String.format("%.2f", pooledTips) + " in tips.");

        System.out.println("Servers              : $" + String.format("%.2f", serverTip));
        System.out.println("       Server 1      : $" + String.format("%.2f", tips[4]));
        System.out.println("       Server 2      : $" + String.format("%.2f", tips[4]));
        System.out.println("       Server 3      : $0.00    (did not work)");
        System.out.println("Kitchen              : $" + String.format("%.2f", kitchenTip));
        System.out.println("       Chef          : $" + String.format("%.2f", tips[5] ));
        System.out.println("       Sous-Chef     : $" + String.format("%.2f", tips[5] ));
        System.out.println("       Kitchen Aid   : $" + String.format("%.2f", tips[5] ));
        System.out.println("Host/Hostess         : $" + String.format("%.2f", tips[6]));
        System.out.println("Busser               : $" + String.format("%.2f", tips[6]));
    }

    static double[] TotalTipsAmount(HashMap<String, EmployeeInfo> employees, double pooledTips){
        double serverTip, kitchenTip, HHBTip, eachServerTip, eachKitchenTip, eachHHBTip;

        serverTip = pooledTips * ((employees.get("Servers").getPercentageOfTips())/100.0);
        eachServerTip = serverTip/employees.get("Servers").getNumberOfEmployeesToday();

        kitchenTip = pooledTips * ((employees.get("Kitchen").getPercentageOfTips())/100.0);
        eachKitchenTip = kitchenTip/employees.get("Kitchen").getNumberOfEmployeesToday();

        HHBTip = pooledTips * ((employees.get("HHB").getPercentageOfTips())/100.0);
        eachHHBTip = HHBTip/employees.get("HHB").getNumberOfEmployeesToday();

        double[] tips={serverTip, kitchenTip, HHBTip, pooledTips,eachServerTip, eachKitchenTip, eachHHBTip};
        return tips;
    }

    public static void main(String[] args) {
        // UnitTests();

        double[] output = AskForData();
        MakeOutput(TotalTipsAmount(InitializeEmployees(), output[1]));
    }

    static void UnitTests(){
        double[] output0 = {500, 100, 4};
        double[] output1 = {500, 150, 2};
        double[] output2 = {500, 10, 1};
        MakeOutput(TotalTipsAmount(InitializeEmployees(), output0[1]));
        MakeOutput(TotalTipsAmount(InitializeEmployees(), output1[1]));
        MakeOutput(TotalTipsAmount(InitializeEmployees(), output2[1]));
    }

}
