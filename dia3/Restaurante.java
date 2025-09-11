package dia3;
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

    public static void dishesMenu() {
        System.out.println("===  Menu ===");
        System.out.println("1. Rib eye");
        System.out.println("2. Tomahawk");
        System.out.println("3. Milanesa napolitana");
        System.out.println("4. Sorrentino capresse");
        System.out.println("5. Bottle of Red wine Catena Zapata");
        System.out.println("6. Coke zero");
        System.out.println("7. Fernet con Coca");
        System.out.println("8. Flan con dulce de leche");
        System.out.print("0. Return to the main menu ");
        System.out.print("Chose an option: ");
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
                    do {
                        dishesMenu();
                        suboption = userEntry(scanner);
                        if (!suboption.equals("0")) {
                            System.out.println("Your order is: " + suboption);
                            customers++;
                        }
                    } while (!suboption.equals("0"));
                    break;

                case "2":
                    System.out.println(wifipassword);
                    break;

                case "3":
                    System.out.println(thankYou);
                    customers--;
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

