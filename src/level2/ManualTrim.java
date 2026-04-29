import java.util.Scanner;

public class ManualTrim {
    public static boolean isWhitespace(char character) {
        return character == ' ' || character == '\t' || character == '\n' || character == '\r';
    }

    public static String trimUsingCharAt(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && isWhitespace(text.charAt(start))) {
            start++;
        }

        while (end >= start && isWhitespace(text.charAt(end))) {
            end--;
        }

        String result = "";
        for (int index = start; index <= end; index++) {
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

        System.out.print("Enter text with leading or trailing spaces: ");
        String text = scanner.nextLine();

        String manualTrim = trimUsingCharAt(text);
        String builtInTrim = text.trim();

        System.out.println("Manual trim: [" + manualTrim + "]");
        System.out.println("Built-in trim(): [" + builtInTrim + "]");
        System.out.println("Results match: " + compareUsingCharAt(manualTrim, builtInTrim));

        scanner.close();
    }
}
