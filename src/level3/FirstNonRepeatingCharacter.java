import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequencies = new int[256];

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current < 256) {
                frequencies[current]++;
            }
        }

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (current < 256 && frequencies[current] == 1) {
                return current;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingCharacter(text);
        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        scanner.close();
    }
}
