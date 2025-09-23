package controller;

import model.User;

import javax.swing.*;
import java.util.Map;

public class MenuController {

    ;

    public static void showStartMenu() {
        String welcome = "Welcome to Riwi user System";
        String farewell = "Goodbye, see you later.";
        JOptionPane.showMessageDialog(null, welcome);

        String[] options = {"Login", "Create an account", "help", "Exit program"};
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
                case 0: //Login

            }


        } while (option != 3 && option != JOptionPane.CLOSED_OPTION);
        JOptionPane.showMessageDialog(null, farewell);
    }

    public void showUserProfile(User user) {
        Map<String, String> profileData = user.getProfileFields();

        StringBuilder sb = new StringBuilder();
        sb.append("User Profile:\n\n");

        for (Map.Entry<String, String> entry : profileData.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Profile", JOptionPane.INFORMATION_MESSAGE);
    }

}
