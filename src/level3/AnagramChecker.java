import java.util.Scanner;

public class AnagramChecker {
    public static boolean isLetterOrDigit(char character) {
        return (character >= 'A' && character <= 'Z')
                || (character >= 'a' && character <= 'z')
                || (character >= '0' && character <= '9');
    }

    public static char toLowercase(char character) {
        if (character >= 'A' && character <= 'Z') {
            return (char) (character + 32);
        }
        return character;
    }

    public static String normalizeText(String text) {
        String normalized = "";
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (isLetterOrDigit(current)) {
                normalized = normalized + toLowercase(current);
            }
        }
        return normalized;
    }

    public static boolean areAnagrams(String firstText, String secondText) {
        String first = normalizeText(firstText);
        String second = normalizeText(secondText);

        if (first.length() != second.length()) {
            return false;
        }

        int[] firstFrequencies = new int[256];
        int[] secondFrequencies = new int[256];

        for (int index = 0; index < first.length(); index++) {
            char firstCharacter = first.charAt(index);
            char secondCharacter = second.charAt(index);

            if (firstCharacter >= 256 || secondCharacter >= 256) {
                return false;
            }

            firstFrequencies[firstCharacter]++;
            secondFrequencies[secondCharacter]++;
        }

        for (int index = 0; index < firstFrequencies.length; index++) {
            if (firstFrequencies[index] != secondFrequencies[index]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String firstText = scanner.nextLine();

        System.out.print("Enter second text: ");
        String secondText = scanner.nextLine();

        System.out.println("Anagram: " + areAnagrams(firstText, secondText));

        scanner.close();
    }
}
