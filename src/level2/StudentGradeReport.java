import java.util.Scanner;

public class StudentGradeReport {
    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int row = 0; row < scores.length; row++) {
            for (int column = 0; column < scores[row].length; column++) {
                scores[row][column] = 10 + (int) (Math.random() * 91);
            }
        }
        return scores;
    }

    public static double[][] calculateTotalsAveragesAndPercentages(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int row = 0; row < scores.length; row++) {
            int total = scores[row][0] + scores[row][1] + scores[row][2];
            double average = total / 3.0;
            double percentage = total / 3.0;

            result[row][0] = total;
            result[row][1] = Math.round(average * 100.0) / 100.0;
            result[row][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] summary) {
        String[] grades = new String[summary.length];
        for (int row = 0; row < summary.length; row++) {
            double percentage = summary[row][2];
            if (percentage >= 80) {
                grades[row] = "A";
            } else if (percentage >= 70) {
                grades[row] = "B";
            } else if (percentage >= 60) {
                grades[row] = "C";
            } else if (percentage >= 50) {
                grades[row] = "D";
            } else if (percentage >= 40) {
                grades[row] = "E";
            } else {
                grades[row] = "R";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] summary, String[] grades) {
        System.out.printf("%-8s %-8s %-10s %-8s %-8s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int row = 0; row < scores.length; row++) {
            System.out.printf("%-8d %-8d %-10d %-8d %-8.0f %-10.2f %-12.2f %-8s%n",
                    row + 1,
                    scores[row][0],
                    scores[row][1],
                    scores[row][2],
                    summary[row][0],
                    summary[row][1],
                    summary[row][2],
                    grades[row]);
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

        int[][] scores = generateScores(numberOfStudents);
        double[][] summary = calculateTotalsAveragesAndPercentages(scores);
        String[] grades = calculateGrades(summary);

        displayScorecard(scores, summary, grades);

        scanner.close();
    }
}
