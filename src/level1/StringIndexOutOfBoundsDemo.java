import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateException(String text) {
        text.charAt(text.length());
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Handled StringIndexOutOfBoundsException: invalid character index");
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
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Generated StringIndexOutOfBoundsException successfully");
        }

        handleException(text);
        scanner.close();
    }
}
