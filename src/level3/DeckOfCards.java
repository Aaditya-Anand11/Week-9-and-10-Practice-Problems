import java.util.Scanner;

public class DeckOfCards {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        int numberOfCards = suits.length * ranks.length;
        String[] deck = new String[numberOfCards];
        int index = 0;

        for (int suit = 0; suit < suits.length; suit++) {
            for (int rank = 0; rank < ranks.length; rank++) {
                deck[index] = ranks[rank] + " of " + suits[suit];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        for (int index = 0; index < deck.length; index++) {
            int randomCardNumber = index + (int) (Math.random() * (deck.length - index));
            String temporary = deck[index];
            deck[index] = deck[randomCardNumber];
            deck[randomCardNumber] = temporary;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numberOfCards, int numberOfPlayers) {
        if (numberOfCards < 1 || numberOfCards > deck.length || numberOfPlayers < 1
                || numberOfCards % numberOfPlayers != 0) {
            return new String[0][0];
        }

        int cardsPerPlayer = numberOfCards / numberOfPlayers;
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int deckIndex = 0;

        for (int player = 0; player < numberOfPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                players[player][card] = deck[deckIndex];
                deckIndex++;
            }
        }

        return players;
    }

    public static void printPlayersCards(String[][] players) {
        if (players.length == 0) {
            System.out.println("Cards cannot be distributed equally with the given inputs.");
            return;
        }

        for (int player = 0; player < players.length; player++) {
            System.out.println("Player " + (player + 1) + ":");
            for (int card = 0; card < players[player].length; card++) {
                System.out.println("  " + players[player][card]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int numberOfCards = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();

        String[][] players = distributeCards(deck, numberOfCards, numberOfPlayers);
        printPlayersCards(players);

        scanner.close();
    }
}
