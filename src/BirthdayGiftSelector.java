import java.util.Scanner;

public class BirthdayGiftSelector {
    static Scanner scanner = new Scanner(System.in);
    static String[] choices = {"Electronics", "Clothes", "Book", "Gift card"}, 
    electronics = {"phone charger", "phone case","camera lens for a phone"},
    clothes = {"Giants cap","SFSU t-shirt","SFSU hoodie"},
    book = {"The Book Thief", "Flowers for Algernon", "The Lord of the Rings trilogy"},
    gift_card = {"Starbucks gift card", "Target gift card", "Visa gift card"};

    static String[][] types = {electronics, clothes, book, gift_card};
    
    static int amount = -1, type = -1;

    public static void main(String[] arg){
        amount = askForAmount();
        if (amount > 0 && amount <=50){
            type = askForType();
            if(type >= 0 && type < types.length){
                if (amount < 10){
                    System.out.println("You can consider buying: " + String.join(", ", types[type][0]));
                }else if(10 <= amount && amount <= 30){
                    System.out.println("You can consider buying: " + String.join(", ", types[type][1]));
                }else if(30 <= amount && amount <= 50){
                    System.out.println("You can consider buying: " + String.join(", ", types[type][2]));
                }
            }
        }else if(amount > 50){
            System.out.println("Instead of a gift, please donate this amount to charity");
        }
    }

    static int askForAmount(){
        System.out.print("How much would you like to spend on a gift? ");
        try {
            amount = scanner.nextInt();
            scanner.nextLine();
            return amount;
        } catch (Exception e) {
            System.out.println("Invalid choice. Please select from numbers");
            scanner.nextLine();
            return -1;
        }
        
    }

    static int askForType() {
        System.out.print("What kind of item do you want to buy (Electronics, Clothes, Book, Gift card): ");
        String userChoice = scanner.nextLine().trim();
        for (int i = 0; i < choices.length; i++) {
            if (userChoice.equalsIgnoreCase(choices[i])) {
                return i;
            }
        }
        System.out.println("Invalid choice. Please select from available options.");
        return -1;
    }
}