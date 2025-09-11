package dia3;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    public static void menu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. Place an order");
        System.out.println("2. Check Wifi password");
        System.out.println("3. Pay your bill");
        System.out.println("4. Call the waiter");
        System.out.println("0. Exit the program");
        System.out.print("Chose an option: ");
    }

    static ArrayList<String> dishes = new ArrayList<>();

    public static void fullDishes() {
        dishes.add("===  Menu ===");
        dishes.add("1. Rib eye");
        dishes.add("2. Tomahawk");
        dishes.add("3. Milanesa napolitana");
        dishes.add("4. Sorrentino capresse");
        dishes.add("5. Bottle of Red wine Catena Zapata");
        dishes.add("6. Coke zero");
        dishes.add("7. Fernet con Coca");
        dishes.add("8. Flan con dulce de leche");
        dishes.add("0. Return to the main menu");
        dishes.add("Chose an option: ");
    }

    public static void displayDishes(ArrayList<String> array) {
        for (String item : array) {
            System.out.println(item);
        }
    }



    public static String userEntry(Scanner scanner) {

        return scanner.nextLine();

    }

    public static void showCustomerCount(int customers) {
        System.out.println("Total customers served: " + customers);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String welcome = "Welcome to the restaurant next to Lina";
        String option;
        int customers = 0;
        String wifipassword = "Qwe.123*";
        String thankYou = "Thank you very much for your visit, we hope to see you again soon!";




        System.out.println(welcome);

        do {
            menu();
            option = userEntry(scanner);

            switch (option) {
                case "1":
                    String suboption;
                    fullDishes();
                    displayDishes(dishes);
                    do {

                        suboption = userEntry(scanner);
                        if (!suboption.equals("0")) {
                            for (String item : dishes) {
                                if (item.startsWith(suboption + ".")) {
                                    System.out.println("Your order is: " + item);
                                    break;
                                }
                            }
                            customers++;
                        }
                    } while (!suboption.equals("0"));
                    break;

                case "2":
                    System.out.println(wifipassword);
                    break;

                case "3":
                    System.out.println(thankYou);
                    break;

                case "4":
                    System.out.println("Ding ding! The waiter appears out of nowhere 🤵🍽️");
                    break;
            }
        } while(!option.equals("0"));
        System.out.println(thankYou);
        scanner.close();

        showCustomerCount(customers);
    }
}
