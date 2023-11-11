import java.util.Scanner;

public class HousingSelection {
    static Scanner scanner = new Scanner(System.in);
    static Double max_inc_Points = 1.5, med_inc_Points = 1.3, min_inc_Points = 1.1,
                max_dec_Points = 0.5,med_dec_Points = 0.7,min_dec_Points = 0.9;
    public static void main(String[] args) {
        Object[] userInfo = askForInfo();
        int result = getHousingScore(userInfo);
        System.out.println("Housing Score: " + result);
    }

    static int getHousingScore(Object[] userInfo) {
        if (userInfo == null) {
            return -1;}

        // getting Points
        double agePoints = getAgePoints((int) userInfo[0]);
        double yearPoints = getYearPoints((int) userInfo[1]);
        double acadProbPoints = getProbationPoints((char) userInfo[2]);
        double dicipProbPoints = getProbationPoints((char) userInfo[3]);
        double finAidPoints = getFinAndDisabilitiesPoints((char) userInfo[4]);
        double disabilitiesPoints = getFinAndDisabilitiesPoints((char) userInfo[5]);
        double extraDisabilitiesPoints = getFinAndDisabilitiesPoints((char) userInfo[6]);
        double distancePoints = getDistancePoints((int) userInfo[7]);
        double studentTimePoints = getStudentTimePoints((int) userInfo[8]);
        double housingBeforePoints = getHousingBeforePoints((char) userInfo[9]);

        // Defining the weight
        double ageWeight = 0.1;
        double yearWeight = 0.1;
        double acadProbWeight = 0.1;
        double dicipProbWeight = 0.1;
        double finAidWeight = 0.05;
        double disabilitiesWeight = 0.2;
        double extraDisabilitiesWeight = 0.2;
        double distanceWeight = 0.05;
        double studentTimeWeight = 0.05;
        double housingBeforeWeight = 0.05;
        
        // weighted sum
        double score = agePoints * ageWeight +
                      yearPoints * yearWeight +
                      acadProbPoints * acadProbWeight +
                      dicipProbPoints * dicipProbWeight +
                      finAidPoints * finAidWeight +
                      disabilitiesPoints * disabilitiesWeight +
                      extraDisabilitiesPoints * extraDisabilitiesWeight +
                      distancePoints * distanceWeight +
                      studentTimePoints * studentTimeWeight +
                      housingBeforePoints * housingBeforeWeight;                    
        double final_score = (score/1.28)*100;    //1.28 - the max score
        return (int)final_score;
    }

    static double getAgePoints(int age){
        if(age >= 17 && age <= 24){
            return 1;
        }else{
            return max_dec_Points;
        }
    }
    static double getYearPoints(int year){
        switch (year) {
            case 1:
                return max_inc_Points;
            case 2:
                return med_inc_Points;
            case 3:
                return min_inc_Points;
            case 4:
                return 1;
            case 5:
                return min_dec_Points;
            default:
                return 1;
        }
    }

    static double getProbationPoints(char dicip_prob){
        switch (dicip_prob) {
            case 'y':
                return max_dec_Points;
            default:
                return 1;
        }
    }

    static double getFinAndDisabilitiesPoints(char disabilities){
        switch (disabilities) {
            case 'y':
                return max_inc_Points;
            default:
                return max_dec_Points;
        }
    }

    static double getDistancePoints(int distance){
        if(distance>100 && distance<1000){
            return min_inc_Points;
        }else if(distance >= 1000){
            return med_inc_Points;
        }
        return 1;
    }

    static double getStudentTimePoints(int time){
        switch (time) {
            case 1:
                return max_dec_Points;
            default:
                return 1;
        }
    }

    static double getHousingBeforePoints(char housing){
        switch (housing) {
            case 'y':
                return med_dec_Points;
            default:
                return 1;
        }
    }

    static char yesOrNoInput() {
        char response = 'i'; 
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                response = 'y';
                break;
            } else if (input.equalsIgnoreCase("n")) {
                response = 'n';
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' for Yes or 'n' for No.");
            }
        }
        return response;
    }

    public static Object[] askForInfo() {
        try {
            System.out.print("How old are you? ");
            int age = scanner.nextInt();
            System.out.println("What year are you in? \n" +
                    "\t1: Freshman \n" +
                    "\t2: Sophomore \n" +
                    "\t3: Junior \n" +
                    "\t4: Senior \n" +
                    "\t5: Super Senior ");
            System.out.print("Enter Selection: ");
            int year = scanner.nextInt();
            System.out.print("Are you on Academic Probation? (y or n) ");
            char acad_prob = yesOrNoInput();
            System.out.print("Are you on Disciplinary Probation? (y or n) ");
            char dicip_prob = yesOrNoInput();
            System.out.print("Are you on Financial Aid? (y or n) ");
            char fin_aid = yesOrNoInput();
            System.out.print("Do you have disabilities? (y or n) ");
            char disabilities = yesOrNoInput();
            char extra_disabilities = 'n';
            if (disabilities == 'y') {
                System.out.print("Do you have any mobility challenges or require assistance with walking? (y or n) ");
                extra_disabilities = yesOrNoInput();
            }
            System.out.print("How many miles are you from school? Please estimate. ");
            int distance = scanner.nextInt();
            System.out.println("Are you a part-time or full-time student? \n" +
                    "\t1: Part-Time \n" +
                    "\t2: Full-Time");
            System.out.print("Enter Selection: ");
            int employment = scanner.nextInt();
            System.out.print("Have you had housing before? (y or n) ");
            char housing = yesOrNoInput();
            Object[] userInfo = {age, year, acad_prob, dicip_prob, fin_aid, disabilities, extra_disabilities, distance, employment, housing};
            return userInfo;
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return null;
        }
    }
}