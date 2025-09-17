import controller.MenuController;
import model.Fruit;
import service.FruitService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FruitService.addFruit(new Fruit("banana", 80, "yellow", 1000, true, false));

        MenuController.welcomeMessage();
        MenuController.showMenu();
    }
}