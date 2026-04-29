import java.util.Scanner;

public class BmiReport {
    public static double[][] readMeasurements(int numberOfPeople, Scanner scanner) {
        double[][] measurements = new double[numberOfPeople][2];
        for (int row = 0; row < measurements.length; row++) {
            System.out.println("Person " + (row + 1));
            System.out.print("Enter weight in kg: ");
            measurements[row][0] = scanner.nextDouble();
            System.out.print("Enter height in cm: ");
            measurements[row][1] = scanner.nextDouble();
        }
        return measurements;
    }

    public static String[] findBmiAndStatus(double weightKg, double heightCm) {
        if (weightKg <= 0 || heightCm <= 0) {
            return new String[] {"0.00", "Invalid"};
        }

        double heightMeters = heightCm / 100.0;
        double bmi = weightKg / (heightMeters * heightMeters);
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {String.format("%.2f", bmi), status};
    }

    public static String[][] buildBmiReport(double[][] measurements) {
        String[][] report = new String[measurements.length][4];
        for (int row = 0; row < measurements.length; row++) {
            String[] bmiAndStatus = findBmiAndStatus(measurements[row][0], measurements[row][1]);
            report[row][0] = String.format("%.2f", measurements[row][1]);
            report[row][1] = String.format("%.2f", measurements[row][0]);
            report[row][2] = bmiAndStatus[0];
            report[row][3] = bmiAndStatus[1];
        }
        return report;
    }

    public static void displayReport(String[][] report) {
        System.out.printf("%-8s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------");
        for (int row = 0; row < report.length; row++) {
            System.out.printf("%-8d %-12s %-12s %-10s %-15s%n",
                    row + 1, report[row][0], report[row][1], report[row][2], report[row][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int teamSize = 10;
        double[][] measurements = readMeasurements(teamSize, scanner);
        String[][] report = buildBmiReport(measurements);
        displayReport(report);

        scanner.close();
    }
}
