package util;
import javax.swing.JOptionPane;

public class InputHelper {
    
    // Validar texto no vacío
    public static String getValidString(String message, String errorMessage) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessage);
            return null;
        }
        return input.trim();
    }
    
    // Validar número positivo (double)
    public static Double getValidPositiveDouble(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null) return null;
        
        try {
            double value = Double.parseDouble(input.trim());
            if (value <= 0) {
                JOptionPane.showMessageDialog(null, "Value must be greater than 0");
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid format. It must be a number");
            return null;
        }
    }
    
    // Validar ID positivo (int)
    public static Integer getValidPositiveId(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        
        try {
            int id = Integer.parseInt(input.trim());
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "ID must be a positive number.");
                return null;
            }
            return id;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.");
            return null;
        }
    }
    
    // Validar confirmación Yes/No
    public static boolean getConfirmation(String message) {
        int answer = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION);
        return (answer == JOptionPane.YES_OPTION);
    }
    
    // Validar query (ID o nombre) no vacía
    public static String getValidQuery(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        return input.trim();
    }
}