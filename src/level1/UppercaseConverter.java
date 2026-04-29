import java.util.Scanner;

public class UppercaseConverter {
    public static String toUppercaseUsingCharAt(String text) {
        String result = "";
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current >= 'a' && current <= 'z') {
                result = result + (char) (current - 32);
            } else {
                result = result + current;
            }
        }
        return result;
    }

    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        for (int index = 0; index < first.length(); index++) {
            if (first.charAt(index) != second.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String manualUppercase = toUppercaseUsingCharAt(text);
        String builtInUppercase = text.toUpperCase();

        System.out.println("Manual uppercase: " + manualUppercase);
        System.out.println("Built-in toUpperCase(): " + builtInUppercase);
        System.out.println("Results match: " + compareUsingCharAt(manualUppercase, builtInUppercase));

        scanner.close();
    }
}
