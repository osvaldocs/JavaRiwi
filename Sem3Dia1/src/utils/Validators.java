package utils;

public class Validators {
    public boolean stringValidator (String input) {
        return input != null && !input.trim().isEmpty();
    }
}
