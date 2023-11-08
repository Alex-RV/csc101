import java.util.Scanner;

public class MinMaxAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int min = 0;
        int sum = 0;
        int count = 0;

        System.out.print("Enter positive integers separated by spaces. Enter -1 to terminate: ");

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                if(count ==0){
                    max=number;
                    min=number;
                    sum += number;
                    count++;
                }else{
                    if (number > 0) {
                    if (number > max) {
                        max = number;
                    }
                    if (number < min) {
                        min = number;
                    }
                    sum += number;
                    count++;
                }
                }
                
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                break;
            }
        }

        double average = (double) sum / count;
        System.out.println("The max: " + max);
        System.out.println("The min: " + min);
        System.out.println("The avg: " + average);
    
        scanner.close();
    }
}
