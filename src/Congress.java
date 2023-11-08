import java.util.Scanner;

public class Congress {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] arg){
        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        System.out.print("How many years have you been a US Citizen? ");
        int citizen = scanner.nextInt();
        if(age >= 30 && citizen >= 9){
            System.out.print("You are eligible for both offices! Now make it happen!");
        }else if(age >= 25 && citizen >= 7){
            System.out.print("You are eligible to be a US Representative but not a Senator yet!");
        }else{
            System.out.print("While you aren't eligible to be a Senator or a US Representative, you can always lead us to a better future!");
        }
    }
}
