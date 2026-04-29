import java.util.Scanner;

public class CharacterFrequencyAscii {
    public static String[][] findFrequenciesUsingAscii(String text) {
        int[] frequencies = new int[256];

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current < 256) {
                frequencies[current]++;
            }
        }

        int uniqueCount = 0;
        boolean[] seen = new boolean[256];
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current < 256 && !seen[current]) {
                seen[current] = true;
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        seen = new boolean[256];
        int row = 0;
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current < 256 && !seen[current]) {
                seen[current] = true;
                result[row][0] = String.valueOf(current);
                result[row][1] = String.valueOf(frequencies[current]);
                row++;
            }
        }
        return result;
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

        String[][] frequencies = findFrequenciesUsingAscii(text);
        displayFrequencies(frequencies);

        scanner.close();
    }
}
