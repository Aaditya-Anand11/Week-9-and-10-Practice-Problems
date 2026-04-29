import java.util.Scanner;

public class StudentVotingEligibility {
    public static int[] generateAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        for (int index = 0; index < ages.length; index++) {
            ages[index] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int index = 0; index < ages.length; index++) {
            boolean canVote = ages[index] >= 18;
            if (ages[index] < 0) {
                canVote = false;
            }
            table[index][0] = String.valueOf(ages[index]);
            table[index][1] = String.valueOf(canVote);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %-10s%n", "Age", "Can Vote");
        System.out.println("---------------------");
        for (int row = 0; row < table.length; row++) {
            System.out.printf("%-10s %-10s%n", table[row][0], table[row][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        if (numberOfStudents < 1) {
            System.out.println("Number of students must be positive");
            scanner.close();
            return;
        }

        int[] ages = generateAges(numberOfStudents);
        String[][] table = checkVotingEligibility(ages);
        displayTable(table);

        scanner.close();
    }
}
