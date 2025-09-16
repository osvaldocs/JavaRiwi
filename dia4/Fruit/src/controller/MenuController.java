package controller;
import javax.swing.JOptionPane;
import model.Fruit;

import static model.Fruit.fruitInput;


public class MenuController {
    public static void welcomeMessage() {
        JOptionPane.showMessageDialog(null, "Hello Admin, welcome back! What do you need for today?");
    }




    public static void showMenu() {
                  String[] opciones = {"Create fruit", "List inventory", "Search fruit by Id or name", "Update fruit", "Delete fruit by Id", "Exit program"};
                  int opcion;

                  do {
                      opcion = JOptionPane.showOptionDialog(
                          null,
                          "Select an option:",
                          "Menú app",
                          JOptionPane.DEFAULT_OPTION,
                          JOptionPane.INFORMATION_MESSAGE,
                          null,
                          opciones,
                          opciones[0]
                      );

                      switch (opcion) {
                          case 0: // Add product
                              fruitInput();
                              break;
                          case 1: // List inventory
                              Fruit.showFruits();
                              break;
                          case 2: // Search fruit
                              String query = JOptionPane.showInputDialog(null, "Enter the ID, or the name of the fruit");

                          case 3: // Order by price
                              String resultado = Fruit.getCheapestAndMostExpensive();
                              JOptionPane.showMessageDialog(null, resultado);
                              break;

                          case 4: // Search product by name
                              String query = JOptionPane.showInputDialog("Enter product name (or part of it):");
                              if (query == null) break; // cancel
                              String results = Fruit.searchProductsByName(query);
                              JOptionPane.showMessageDialog(null, results);
                              break;

                          case 5: // Salir
                          case JOptionPane.CLOSED_OPTION:
                              JOptionPane.showMessageDialog(null, "See you!.");
                              break;
                          default:
                              JOptionPane.showMessageDialog(null, "Invalid option.");
                              break;
                      }

                  } while (opcion != 5 && opcion != JOptionPane.CLOSED_OPTION);
              }


}
















