import java.util.Scanner;

public class SplitWordsCompare {
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

    public static String[] splitWordsUsingCharAt(String text) {
        String trimmedText = trimUsingCharAt(text);
        if (trimmedText.length() == 0) {
            return new String[0];
        }

        int wordCount = 0;
        boolean inWord = false;
        for (int index = 0; index < trimmedText.length(); index++) {
            if (isWhitespace(trimmedText.charAt(index))) {
                inWord = false;
            } else if (!inWord) {
                wordCount++;
                inWord = true;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        String currentWord = "";
        for (int index = 0; index < trimmedText.length(); index++) {
            char current = trimmedText.charAt(index);
            if (isWhitespace(current)) {
                if (currentWord.length() > 0) {
                    words[wordIndex] = currentWord;
                    wordIndex++;
                    currentWord = "";
                }
            } else {
                currentWord = currentWord + current;
            }
        }

        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord;
        }
        return words;
    }

    public static boolean compareStringArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int index = 0; index < first.length; index++) {
            if (!first[index].equals(second[index])) {
                return false;
            }
        }
        return true;
    }

    public static void displayWords(String label, String[] words) {
        System.out.print(label + ": ");
        for (int index = 0; index < words.length; index++) {
            System.out.print(words[index]);
            if (index < words.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] manualWords = splitWordsUsingCharAt(text);
        String trimmedText = text.trim();
        String[] builtInWords = trimmedText.length() == 0 ? new String[0] : trimmedText.split("\\s+");

        displayWords("Manual split", manualWords);
        displayWords("Built-in split()", builtInWords);
        System.out.println("Results match: " + compareStringArrays(manualWords, builtInWords));

        scanner.close();
    }
}
