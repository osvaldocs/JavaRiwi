package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Fruit {
    private static int countId = 0;
    private int id;
    private String name;
    private double weightKg;
    private String color;
    private double  price;
    private boolean isOrganic;
    private boolean isImported;

    public Fruit(String name, double weightKg, String color, double price, boolean isOrganic, boolean isImported) {
        this.name = name;
        this.id = countId++;
        this.weightKg = weightKg;
        this.color = color;
        this.price = price;
        this.isOrganic = isOrganic;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    static ArrayList<Fruit> fruits = new ArrayList<>();
    static HashMap<String, Integer> stock= new HashMap<>();


    public static void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public static void fruitInput() {
        String fruitName = JOptionPane.showInputDialog("Enter the fruit name:");
        if (fruitName == null || fruitName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name.");
            return;
        }

        fruitExists(fruitName);

        String fruitPrice = JOptionPane.showInputDialog("Enter the fruit price:");
        double decimalPrice;
        try {
            decimalPrice = Double.parseDouble(fruitPrice);
            if (decimalPrice <= 0) {
                JOptionPane.showMessageDialog(null, "The price must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price. It must be a number");
            return;
        }

        String fruitWeightInput = JOptionPane.showInputDialog("Please enter fruit weight:");
        double fruitWeight;
        try {
            fruitWeight = Double.parseDouble(fruitPrice);
            if (fruitWeight <= 0) {
                JOptionPane.showMessageDialog(null, "The weight must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid weight. It must be a number");
            return;
        }

        String fruitStock = JOptionPane.showInputDialog("Enter the fruit stock:");
        int quantity;
        try {
            quantity = Integer.parseInt(fruitStock);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "Stock must be zero or positive");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid stock. It must be an integer");
            return;
        }

        String fruitColor = JOptionPane.showInputDialog("Please enter the color fruit");


        addFruit(new Fruit(fruitName,));
        JOptionPane.showMessageDialog(null, "Product added correctly");
    }

    public static boolean fruitExists(String name) {
        for (Fruit f : fruits) {
            if (f.getName().equalsIgnoreCase(name)) { // puedes usar equals() si no quieres ignorar mayúsculas/minúsculas
                return true;
            }
        }
        return false;
    }


    public static void showProducts() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available");
            return;
        }
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i);
            double price = prices.get(i);
            int quantity = stock.getOrDefault(name, 0);
            sb.append((i + 1) + ". " + name + " - $" + price + " - Stock: " + quantity + "\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static boolean reduceStock(String productName, int quantity) {
        if (!stock.containsKey(productName)) {
            return false;
        }
        int current = stock.get(productName);
        if (current < quantity) {
            return false;
        }
        stock.put(productName, current - quantity);
        return true;
    }

    public static double getPrice(String productName) {
        int index = products.indexOf(productName);
        return prices.get(index);
    }

    public static String[] getAvailableProducts() {
        java.util.List<String> disponibles = new java.util.ArrayList<>();
        for (String nombre : products) {
            int stockActual = stock.getOrDefault(nombre, 0);
            if (stockActual > 0) {
                disponibles.add(nombre + " (Stock: " + stockActual + ")");
            }
        }
        return disponibles.toArray(new String[0]);
    }

    public static String getCheapestAndMostExpensive() {
        if (products.isEmpty()) {
            return "No products available.";
        }

        double minPrice = prices.get(0);
        double maxPrice = prices.get(0);
        String minName = products.get(0);
        String maxName = products.get(0);

        for (int i = 1; i < prices.size(); i++) {
            double price = prices.get(i);
            String name = products.get(i);
            if (price < minPrice) {
                minPrice = price;
                minName = name;
            }
            if (price > maxPrice) {
                maxPrice = price;
                maxName = name;
            }
        }

        return "Cheapest: " + minName + " ($" + minPrice + ")\n"
                + "Most expensive: " + maxName + " ($" + maxPrice + ")";
    }

    public static String searchProductsById(String query) {
        if (products.isEmpty()) {
            return "No products available.";
        }

        if (query == null || query.trim().isEmpty()) {
            return "Please enter a search term.";
        }

        StringBuilder sb = new StringBuilder("Search results:\n");
        String lowerQuery = query.toLowerCase();
        boolean found = false;

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i);
            if (name.toLowerCase().contains(lowerQuery)) {
                double price = prices.get(i);
                int stockActual = stock.getOrDefault(name, 0);
                sb.append(name)
                        .append(" - $").append(price)
                        .append(" (Stock: ").append(stockActual).append(")\n");
                found = true;
            }
        }

        if (!found) {
            return "No products match your search.";
        }

        return sb.toString();
    }


}