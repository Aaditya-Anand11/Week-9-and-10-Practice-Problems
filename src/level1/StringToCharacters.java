import java.util.Scanner;

public class StringToCharacters {
    public static char[] toCharactersUsingCharAt(String text) {
        char[] characters = new char[text.length()];
        for (int index = 0; index < text.length(); index++) {
            characters[index] = text.charAt(index);
        }
        return characters;
    }

    public static boolean compareCharacterArrays(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int index = 0; index < first.length; index++) {
            if (first[index] != second[index]) {
                return false;
            }
        }
        return true;
    }

    public static void displayCharacters(char[] characters) {
        for (int index = 0; index < characters.length; index++) {
            System.out.print(characters[index]);
            if (index < characters.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        char[] manualCharacters = toCharactersUsingCharAt(text);
        char[] builtInCharacters = text.toCharArray();

        System.out.print("Manual characters: ");
        displayCharacters(manualCharacters);
        System.out.println("Results match: " + compareCharacterArrays(manualCharacters, builtInCharacters));

        scanner.close();
    }
}
