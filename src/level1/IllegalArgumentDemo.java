import java.util.Scanner;

public class IllegalArgumentDemo {
    public static String substringWithValidation(String text, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start index cannot be greater than end index");
        }
        return text.substring(start, end);
    }

    public static void generateException(String text) {
        substringWithValidation(text, text.length(), 0);
    }

    public static void handleException(String text) {
        try {
            System.out.println(substringWithValidation(text, text.length(), 0));
        } catch (IllegalArgumentException exception) {
            System.out.println("Handled IllegalArgumentException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Handled runtime exception: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        try {
            generateException(text);
        } catch (IllegalArgumentException exception) {
            System.out.println("Generated IllegalArgumentException successfully");
        }

        handleException(text);
        scanner.close();
    }
}
