import java.util.Scanner;

public class WordLengthsTable {
    public static boolean isWhitespace(char character) {
        return character == ' ' || character == '\t' || character == '\n' || character == '\r';
    }

    public static String[] splitWordsUsingCharAt(String text) {
        String trimmedText = text.trim();
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

    public static String[][] buildWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int index = 0; index < words.length; index++) {
            table[index][0] = words[index];
            table[index][1] = String.valueOf(findLengthWithoutLength(words[index]));
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-20s %10s%n", "Word", "Length");
        System.out.println("-------------------------------");
        for (int row = 0; row < table.length; row++) {
            System.out.printf("%-20s %10s%n", table[row][0], table[row][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitWordsUsingCharAt(text);
        String[][] table = buildWordLengthTable(words);
        displayTable(table);

        scanner.close();
    }
}
