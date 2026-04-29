import java.util.Scanner;

public class ManualStringLength {
    public static int findLengthWithoutLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException exception) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        int manualLength = findLengthWithoutLength(text);
        int builtInLength = text.length();

        System.out.println("Manual length: " + manualLength);
        System.out.println("Built-in length(): " + builtInLength);
        System.out.println("Results match: " + (manualLength == builtInLength));

        scanner.close();
    }
}
