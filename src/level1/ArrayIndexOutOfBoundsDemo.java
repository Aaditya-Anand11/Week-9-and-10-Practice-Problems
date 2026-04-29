import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: invalid array index");
        } catch (RuntimeException exception) {
            System.out.println("Handled runtime exception: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        if (size < 1) {
            System.out.println("Number of names must be positive");
            scanner.close();
            return;
        }

        String[] names = new String[size];
        for (int index = 0; index < names.length; index++) {
            System.out.print("Enter name " + (index + 1) + ": ");
            names[index] = scanner.next();
        }

        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Generated ArrayIndexOutOfBoundsException successfully");
        }

        handleException(names);
        scanner.close();
    }
}
