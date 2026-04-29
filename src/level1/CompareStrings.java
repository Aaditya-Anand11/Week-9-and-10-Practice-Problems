import java.util.Scanner;

public class CompareStrings {
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

        System.out.print("Enter first string: ");
        String first = scanner.next();

        System.out.print("Enter second string: ");
        String second = scanner.next();

        boolean manualResult = compareUsingCharAt(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("Manual comparison: " + manualResult);
        System.out.println("Built-in equals(): " + builtInResult);
        System.out.println("Results match: " + (manualResult == builtInResult));

        scanner.close();
    }
}
