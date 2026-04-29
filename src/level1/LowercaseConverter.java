import java.util.Scanner;

public class LowercaseConverter {
    public static String toLowercaseUsingCharAt(String text) {
        String result = "";
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current >= 'A' && current <= 'Z') {
                result = result + (char) (current + 32);
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

        String manualLowercase = toLowercaseUsingCharAt(text);
        String builtInLowercase = text.toLowerCase();

        System.out.println("Manual lowercase: " + manualLowercase);
        System.out.println("Built-in toLowerCase(): " + builtInLowercase);
        System.out.println("Results match: " + compareUsingCharAt(manualLowercase, builtInLowercase));

        scanner.close();
    }
}
