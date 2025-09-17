package controller;
import javax.swing.JOptionPane;
import model.Fruit;
import service.FruitService;
import util.InputHelper;


public class MenuController {
    public static void welcomeMessage() {
        JOptionPane.showMessageDialog(null, "Hello Admin, welcome back! What do you need for today?");
    }




    public static void showMenu() {
                  String[] opciones = {"Create fruit", "List inventory", "Search fruit by Id or name", "Update fruit by Id", "Delete fruit by Id", "Exit program"};
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
                              handleCreateFruit();
                              break;
                          case 1: // List inventory
                              handleShowInventory();
                              break;
                          case 2: // Search fruit
                              handleSearchFruit();
                              break;
                          case 3: // Update fruit by Id
                              handleUpdateFruit();
                              break;

                          case 4: // Delete fruit by Id
                              handleDeleteFruit();
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

    public static void handleSearchFruit() {
        String query = InputHelper.getValidQuery("Enter the ID, or the name of the fruit");
        if (query == null) return;

        Fruit foundFruit = FruitService.searchFruitByQuery(query);

        if (foundFruit != null) {
            String details = FruitService.formatFruitDetails(foundFruit);
            JOptionPane.showMessageDialog(null, details);
        } else {
            JOptionPane.showMessageDialog(null, "Fruit not found with: " + query);
        }
    }
    
    public static void handleCreateFruit() {
        String fruitName = InputHelper.getValidString("Enter the fruit name:", "Invalid name.");
        if (fruitName == null) return;

        // Verificar si la fruta ya existe
        if (FruitService.fruitExists(fruitName)) {
            JOptionPane.showMessageDialog(null, "A fruit with this name already exists.");
            return;
        }

        Double price = InputHelper.getValidPositiveDouble("Enter the fruit price:");
        if (price == null) return;

        Double weight = InputHelper.getValidPositiveDouble("Please enter fruit weight:");
        if (weight == null) return;

        String color = InputHelper.getValidString("Please enter the color fruit", "Invalid color.");
        if (color == null) return;

        boolean isOrganic = InputHelper.getConfirmation("Is the fruit organic?");
        boolean isImported = InputHelper.getConfirmation("Is the fruit imported?");

        FruitService.addFruit(new Fruit(fruitName, weight, color, price, isOrganic, isImported));
        JOptionPane.showMessageDialog(null, "Product added correctly");
    }
    
    public static void handleShowInventory() {
        String inventory = FruitService.getAllFruitsFormatted();
        JOptionPane.showMessageDialog(null, inventory);
    }

    public static void handleDeleteFruit() {
        Integer id = InputHelper.getValidPositiveId("Enter fruit ID to delete:");
        if (id == null) return;

        if (FruitService.deleteFruitById(id)) {
            JOptionPane.showMessageDialog(null, "Fruit deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "No fruit found with ID: " + id);
        }
    }
    
    public static void handleUpdateFruit() {
        String query = InputHelper.getValidQuery("Enter fruit ID or name to update:");
        if (query == null) return;
        
        // Buscar la fruta usando searchFruitByQuery
        Fruit existingFruit = FruitService.searchFruitByQuery(query);
        if (existingFruit == null) {
            JOptionPane.showMessageDialog(null, "Fruit not found with: " + query);
            return;
        }
        
        // Mostrar datos actuales usando formatFruitDetails
        String currentData = FruitService.formatFruitDetails(existingFruit);
        JOptionPane.showMessageDialog(null, currentData + "\n\nEnter new data:");
        
        // Pedir nuevos datos usando InputHelper
        String newName = InputHelper.getValidString("Enter new name:", "Invalid name.");
        if (newName == null) return;
        
        Double newPrice = InputHelper.getValidPositiveDouble("Enter new price:");
        if (newPrice == null) return;
        
        Double newWeight = InputHelper.getValidPositiveDouble("Enter new weight:");
        if (newWeight == null) return;
        
        String newColor = InputHelper.getValidString("Enter new color:", "Invalid color.");
        if (newColor == null) return;
        
        boolean newOrganic = InputHelper.getConfirmation("Is the fruit organic?");
        boolean newImported = InputHelper.getConfirmation("Is the fruit imported?");
        
        // Actualizar usando el método updateFruit
        if (FruitService.updateFruit(query, newName, newWeight, newColor, newPrice, newOrganic, newImported)) {
            JOptionPane.showMessageDialog(null, "Fruit updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Error updating fruit.");
        }
    }
}


















