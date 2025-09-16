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
            fruitWeight = Double.parseDouble(fruitWeightInput);
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
        if (fruitColor == null || fruitColor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name.");
            return;
        }

        int answer1 = JOptionPane.showConfirmDialog(null, "Is the fruit organic?", "Confirm", JOptionPane.YES_NO_OPTION);
        boolean isOrganic = (answer1 == JOptionPane.YES_NO_OPTION);

        int answer2 = JOptionPane.showConfirmDialog(null, "Is the fruit imported?", "Confirm", JOptionPane.YES_NO_OPTION);
        boolean isImported = (answer2 == JOptionPane.YES_NO_OPTION);


        addFruit(new Fruit(fruitName, fruitWeight, fruitColor,decimalPrice, isOrganic, isImported));
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


    public static void showFruits() {
        if (fruits.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No fruits available");
            return;
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
        JOptionPane.showMessageDialog(null, sb.toString());

    }


    public static Fruit searchByName(ArrayList<Fruit> fruits, String query) {
        if (fruits == null || fruits.isEmpty()) {
            return null;
        }

        if (query == null || query.trim().isEmpty()) {
            return null;
        }

        String lowerQuery = query.toLowerCase();

        for (Fruit fruit : fruits) {
            if (fruit.getName().toLowerCase().contains(lowerQuery)) {
                return fruit; // retorna el primero que coincide
            }
        }

        return null; // no se encontró ninguno
    }


    public Fruit searchById(ArrayList<Fruit> fruits, int id) {
        if (fruits == null || fruits.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, there are no fruits yet.");
            return null;
        }

        if (id < 0) {
            JOptionPane.showMessageDialog(null, "Error id not found");
            return null;
        }

        for (Fruit fruit : fruits) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }

        return null;
    }



}
