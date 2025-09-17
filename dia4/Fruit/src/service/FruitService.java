package service;
import model.Fruit;
import java.util.ArrayList;

public class FruitService {

    static ArrayList<Fruit> fruits = new ArrayList<>();

    public static void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    // Método principal de búsqueda (combina búsqueda por ID y nombre)
    public static Fruit searchFruitByQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            return null;
        }

        // Intentar primero como ID
        try {
            int id = Integer.parseInt(query.trim());
            return searchById(id);
        } catch (NumberFormatException e) {
            // No es un número, buscar por nombre
            return searchByName(query.trim());
        }
    }

    // Búsqueda por ID
    public static Fruit searchById(int id) {
        if (fruits.isEmpty()) {
            return null;
        }

        if (id < 0) {
            return null;
        }

        for (Fruit fruit : fruits) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

    // Búsqueda por nombre (parcial)
    public static Fruit searchByName(String query) {
        if (fruits.isEmpty() || query == null || query.trim().isEmpty()) {
            return null;
        }

        String lowerQuery = query.toLowerCase();

        for (Fruit fruit : fruits) {
            if (fruit.getName().toLowerCase().contains(lowerQuery)) {
                return fruit;
            }
        }
        return null;
    }

    // Método helper para formatear los detalles de la fruta
    public static String formatFruitDetails(Fruit fruit) {
        if (fruit == null) return null;

        return "Fruit found:\n" +
                "ID: " + fruit.getId() + "\n" +
                "Name: " + fruit.getName() + "\n" +
                "Color: " + fruit.getColor() + "\n" +
                "Weight: " + fruit.getWeightKg() + " Kg\n" +
                "Price: $" + String.format("%.2f", fruit.getPrice()) + "\n" +
                "Organic: " + (fruit.isOrganic() ? "Yes" : "No") + "\n" +
                "Imported: " + (fruit.isImported() ? "Yes" : "No");
    }
    
    // Verificar si existe una fruta con ese nombre
    public static boolean fruitExists(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        
        for (Fruit f : fruits) {
            if (f.getName().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // Obtener todas las frutas formateadas para mostrar
    public static String getAllFruitsFormatted() {
        if (fruits.isEmpty()) {
            return "No fruits available";
        }
        
        StringBuilder sb = new StringBuilder("Inventory:\n\n");
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            sb.append((i + 1)).append(". ")
                    .append(fruit.getName()).append(" | ")
                    .append("Color: ").append(fruit.getColor()).append(" | ")
                    .append("Weight: ").append(String.format("%.2f", fruit.getWeightKg())).append(" Kg | ")
                    .append("Price: $").append(String.format("%.2f", fruit.getPrice())).append(" | ")
                    .append("Organic: ").append(fruit.isOrganic() ? "Yes" : "No").append(" | ")
                    .append("Imported: ").append(fruit.isImported() ? "Yes" : "No")
                    .append("\n");
        }
        return sb.toString();
    }

    public static boolean deleteFruitById(int id) {
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getId() == id) {
                fruits.remove(i);
                return true;
            }
        } return false;
    }

    public static boolean updateFruit(String query, String name, double weight,
                                      String color, double price,
                                      boolean organic, boolean imported) {

        Fruit fruitToUpdate = searchFruitByQuery(query);

        if (fruitToUpdate == null) {
            return false; // No encontrada
        }

        // Actualizar todos los campos
        fruitToUpdate.setName(name);
        fruitToUpdate.setWeightKg(weight);
        fruitToUpdate.setColor(color);
        fruitToUpdate.setPrice(price);
        fruitToUpdate.setOrganic(organic);
        fruitToUpdate.setImported(imported);

        return true; // Actualizada exitosamente
    }

    
    // Obtener la lista de frutas (para acceso desde otras clases si es necesario)
    public static ArrayList<Fruit> getFruits() {
        return new ArrayList<>(fruits); // Retorna una copia para evitar modificaciones externas
    }
    
    // Método para obtener las frutas más baratas y más caras
    public static String getCheapestAndMostExpensive() {
        if (fruits.isEmpty()) {
            return "No fruits available";
        }
        
        Fruit cheapest = fruits.get(0);
        Fruit mostExpensive = fruits.get(0);
        
        for (Fruit fruit : fruits) {
            if (fruit.getPrice() < cheapest.getPrice()) {
                cheapest = fruit;
            }
            if (fruit.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = fruit;
            }
        }
        
        return "Cheapest fruit: " + cheapest.getName() + " - $" + String.format("%.2f", cheapest.getPrice()) + "\n" +
               "Most expensive fruit: " + mostExpensive.getName() + " - $" + String.format("%.2f", mostExpensive.getPrice());
    }
}