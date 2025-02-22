package homeworks.homework13.utils;

public class NumberParser {

    public static Integer parseCount(String value) throws IllegalArgumentException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}

