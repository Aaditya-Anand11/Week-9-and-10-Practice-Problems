import java.util.Scanner;

public class CharacterTypeTable {
    public static boolean isLetter(char character) {
        return (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z');
    }

    public static boolean isVowel(char character) {
        char lower = character;
        if (character >= 'A' && character <= 'Z') {
            lower = (char) (character + 32);
        }
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    public static String getCharacterType(char character) {
        if (!isLetter(character)) {
            return "Not a Letter";
        }
        return isVowel(character) ? "Vowel" : "Consonant";
    }

    public static String[][] buildCharacterTypeTable(String text) {
        String[][] table = new String[text.length()][2];
        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            table[index][0] = String.valueOf(current);
            table[index][1] = getCharacterType(current);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-12s %-15s%n", "Character", "Type");
        System.out.println("---------------------------");
        for (int row = 0; row < table.length; row++) {
            System.out.printf("%-12s %-15s%n", table[row][0], table[row][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = buildCharacterTypeTable(text);
        displayTable(table);

        scanner.close();
    }
}
