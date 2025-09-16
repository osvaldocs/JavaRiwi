package service;
import model.Fruit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FruitService {

    static ArrayList<Fruit> fruits = new ArrayList<>();
    public static void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

}
