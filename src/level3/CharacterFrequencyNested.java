import java.util.Scanner;

public class CharacterFrequencyNested {
    public static String[][] findFrequenciesUsingNestedLoops(String text) {
        char[] characters = text.toCharArray();
        int[] frequencies = new int[characters.length];
        boolean[] counted = new boolean[characters.length];
        int uniqueCount = 0;

        for (int index = 0; index < characters.length; index++) {
            if (counted[index]) {
                continue;
            }

            int count = 1;
            for (int next = index + 1; next < characters.length; next++) {
                if (characters[index] == characters[next]) {
                    count++;
                    counted[next] = true;
                }
            }

            frequencies[index] = count;
            uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int row = 0;
        for (int index = 0; index < characters.length; index++) {
            if (!counted[index]) {
                result[row][0] = String.valueOf(characters[index]);
                result[row][1] = String.valueOf(frequencies[index]);
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

        String[][] frequencies = findFrequenciesUsingNestedLoops(text);
        displayFrequencies(frequencies);

        scanner.close();
    }
}
