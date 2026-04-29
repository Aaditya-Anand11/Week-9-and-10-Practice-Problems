import java.util.Scanner;

public class StringAnalyzer {
    public static int[] findAllIndexes(String text, char target) {
        int count = 0;
        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == target) {
                count++;
            }
        }

        int[] indexes = new int[count];
        int resultIndex = 0;
        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == target) {
                indexes[resultIndex] = index;
                resultIndex++;
            }
        }
        return indexes;
    }

    public static void displayIndexes(int[] indexes, char target) {
        System.out.print("Indexes of '" + target + "': ");
        if (indexes.length == 0) {
            System.out.println("not found");
            return;
        }

        for (int index = 0; index < indexes.length; index++) {
            System.out.print(indexes[index]);
            if (index < indexes.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        System.out.print("Enter a character to find: ");
        char target = scanner.next().charAt(0);

        int[] indexes = findAllIndexes(text, target);
        displayIndexes(indexes, target);

        scanner.close();
    }
}
