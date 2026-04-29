import java.util.Scanner;

public class ManualSubstring {
    public static String substringUsingCharAt(String text, int start, int end) {
        if (start < 0 || end > text.length() || start > end) {
            throw new IllegalArgumentException("Invalid substring range");
        }

        String result = "";
        for (int index = start; index < end; index++) {
            result = result + text.charAt(index);
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
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String manualSubstring = substringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Manual substring: " + manualSubstring);
        System.out.println("Built-in substring(): " + builtInSubstring);
        System.out.println("Results match: " + compareUsingCharAt(manualSubstring, builtInSubstring));

        scanner.close();
    }
}
