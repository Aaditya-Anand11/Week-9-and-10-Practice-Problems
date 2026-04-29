import java.util.Scanner;

public class CharacterFrequencyUnique {
    public static char[] findUniqueCharacters(String text) {
        char[] temporary = new char[text.length()];
        int uniqueCount = 0;

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            boolean alreadyPresent = false;
            for (int previous = 0; previous < index; previous++) {
                if (text.charAt(previous) == current) {
                    alreadyPresent = true;
                    break;
                }
            }

            if (!alreadyPresent) {
                temporary[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] uniqueCharacters = new char[uniqueCount];
        for (int index = 0; index < uniqueCount; index++) {
            uniqueCharacters[index] = temporary[index];
        }
        return uniqueCharacters;
    }

    public static String[][] findFrequenciesUsingUniqueCharacters(String text) {
        char[] uniqueCharacters = findUniqueCharacters(text);
        String[][] frequencies = new String[uniqueCharacters.length][2];

        for (int row = 0; row < uniqueCharacters.length; row++) {
            int count = 0;
            for (int index = 0; index < text.length(); index++) {
                if (text.charAt(index) == uniqueCharacters[row]) {
                    count++;
                }
            }
            frequencies[row][0] = String.valueOf(uniqueCharacters[row]);
            frequencies[row][1] = String.valueOf(count);
        }

        return frequencies;
    }

    public static void displayFrequencies(String[][] frequencies) {
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        System.out.println("------------------------");
        for (int row = 0; row < frequencies.length; row++) {
            System.out.printf("%-12s %-10s%n", frequencies[row][0], frequencies[row][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] frequencies = findFrequenciesUsingUniqueCharacters(text);
        displayFrequencies(frequencies);

        scanner.close();
    }
}
