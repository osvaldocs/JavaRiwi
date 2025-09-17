package model;

public class Fruit {
    private static int countId = 0;
    private int id;
    private String name;
    private double weightKg;
    private String color;
    private double price;
    private boolean isOrganic;
    private boolean isImported;

    // Constructor
    public Fruit(String name, double weightKg, String color, double price, boolean isOrganic, boolean isImported) {
        this.name = name;
        this.id = countId++;
        this.weightKg = weightKg;
        this.color = color;
        this.price = price;
        this.isOrganic = isOrganic;
        this.isImported = isImported;
    }

    // Getters y Setters
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


}