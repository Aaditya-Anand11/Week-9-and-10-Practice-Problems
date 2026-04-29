import java.util.Scanner;

public class RockPaperScissorsStats {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "rock";
        }
        if (choice == 1) {
            return "paper";
        }
        return "scissors";
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "tie";
        }

        if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "user";
        }

        return "computer";
    }

    public static String[][] playGames(int numberOfGames, Scanner scanner) {
        String[][] results = new String[numberOfGames][4];
        for (int game = 0; game < numberOfGames; game++) {
            String userChoice;
            while (true) {
                System.out.print("Game " + (game + 1) + " - enter rock, paper, or scissors: ");
                userChoice = scanner.next().toLowerCase();
                if (isValidChoice(userChoice)) {
                    break;
                }
                System.out.println("Invalid choice. Try again.");
            }

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            results[game][0] = String.valueOf(game + 1);
            results[game][1] = userChoice;
            results[game][2] = computerChoice;
            results[game][3] = winner;
        }
        return results;
    }

    public static String[][] calculateStats(String[][] results) {
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;

        for (int row = 0; row < results.length; row++) {
            if (results[row][3].equals("user")) {
                userWins++;
            } else if (results[row][3].equals("computer")) {
                computerWins++;
            } else {
                ties++;
            }
        }

        String[][] stats = new String[3][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userWins * 100.0 / results.length);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerWins * 100.0 / results.length);
        stats[2][0] = "Tie";
        stats[2][1] = String.valueOf(ties);
        stats[2][2] = String.format("%.2f", ties * 100.0 / results.length);
        return stats;
    }

    public static void displayResults(String[][] results) {
        System.out.printf("%-8s %-12s %-12s %-10s%n", "Game", "User", "Computer", "Winner");
        System.out.println("--------------------------------------------");
        for (int row = 0; row < results.length; row++) {
            System.out.printf("%-8s %-12s %-12s %-10s%n",
                    results[row][0], results[row][1], results[row][2], results[row][3]);
        }
    }

    public static void displayStats(String[][] stats) {
        System.out.println();
        System.out.printf("%-12s %-8s %-12s%n", "Player", "Wins", "Win %");
        System.out.println("--------------------------------");
        for (int row = 0; row < stats.length; row++) {
            System.out.printf("%-12s %-8s %-12s%n", stats[row][0], stats[row][1], stats[row][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int numberOfGames = scanner.nextInt();
        if (numberOfGames < 1) {
            System.out.println("Number of games must be positive");
            scanner.close();
            return;
        }

        String[][] results = playGames(numberOfGames, scanner);
        String[][] stats = calculateStats(results);

        displayResults(results);
        displayStats(stats);

        scanner.close();
    }
}
