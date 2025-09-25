import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConfigDB.openConnection();


        String[] options = {"Create coder", "List coders", "Delete coder by ID", "Exit program"};
        int option;

        do {
            option = JOptionPane.showOptionDialog(
                    null,
                    "Select an option:",
                    "User system",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );


            switch (option) {
                case 0:
                    CoderController.create();
                    break;
                case 1:
                    CoderController.getAllUsers();
                    break;
                case 2:
                    CoderController.delete();
                    break;
            }

        } while (option != 3 && option != JOptionPane.CLOSED_OPTION);
    }
}
