import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String text) {
        Integer.parseInt(text);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException exception) {
            System.out.println("Handled NumberFormatException: input is not a valid integer");
        } catch (RuntimeException exception) {
            System.out.println("Handled runtime exception: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text that is not a number: ");
        String text = scanner.next();

        try {
            generateException(text);
        } catch (NumberFormatException exception) {
            System.out.println("Generated NumberFormatException successfully");
        }

        handleException(text);
        scanner.close();
    }
}
