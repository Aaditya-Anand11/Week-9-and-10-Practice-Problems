import java.util.Scanner;

public class UniqueCharacters {
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

    public static char[] findUniqueCharacters(String text) {
        int length = findLengthWithoutLength(text);
        char[] temporary = new char[length];
        int uniqueCount = 0;

        for (int index = 0; index < length; index++) {
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

    public static void displayCharacters(char[] characters) {
        System.out.print("Unique characters: ");
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
        String text = scanner.nextLine();

        char[] uniqueCharacters = findUniqueCharacters(text);
        displayCharacters(uniqueCharacters);

        scanner.close();
    }
}
