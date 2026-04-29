import java.util.Scanner;

public class ShortestLongestWords {
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

    public static String[] findShortestAndLongest(String[] words) {
        if (words.length == 0) {
            return new String[] {"", ""};
        }

        String shortest = words[0];
        String longest = words[0];
        for (int index = 1; index < words.length; index++) {
            if (words[index].length() < shortest.length()) {
                shortest = words[index];
            }
            if (words[index].length() > longest.length()) {
                longest = words[index];
            }
        }
        return new String[] {shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitWordsUsingCharAt(text);
        String[] result = findShortestAndLongest(words);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);

        scanner.close();
    }
}
