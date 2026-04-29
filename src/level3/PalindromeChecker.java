import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeUsingIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseUsingCharAt(String text) {
        char[] reverse = new char[text.length()];
        for (int index = 0; index < text.length(); index++) {
            reverse[index] = text.charAt(text.length() - 1 - index);
        }
        return reverse;
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseUsingCharAt(text);

        for (int index = 0; index < original.length; index++) {
            if (original[index] != reverse[index]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.println("Using indexes: " + isPalindromeUsingIndexes(text));
        System.out.println("Using recursion: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Using arrays: " + isPalindromeUsingArrays(text));

        scanner.close();
    }
}
