import java.util.Scanner;

public class VowelConsonantCount {
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

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int index = 0; index < text.length(); index++) {
            char current = text.charAt(index);
            if (isLetter(current)) {
                if (isVowel(current)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return new int[] {vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);

        scanner.close();
    }
}
