package utils;

public class Validators {
    public static boolean stringValidator(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean intValidator(String input) {
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error invalid input");
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        if (!stringValidator(email)) return false; // chequea null y vacío
        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    public static boolean isValidPhone(String phone) {
        if (!intValidator(phone)) return false;
        // Ejemplo simple: solo dígitos, entre 7 y 15 caracteres
        return phone.matches("\\d{7,15}");
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        // Al menos 8 caracteres, al menos 1 letra y 1 número
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(regex);
    }
}
