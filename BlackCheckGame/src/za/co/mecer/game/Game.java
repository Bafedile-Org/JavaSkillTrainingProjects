package za.co.mecer.game;

import java.util.Scanner;
import java.util.Stack;
import za.co.mecer.cards.Cards;
import za.co.mecer.cards.suits.Suits;
import za.co.mecer.dealer.Dealer;
import za.co.mecer.exceptions.CardException;
import za.co.mecer.interfaces.GameInterface;
import za.co.mecer.player.Player;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Game implements GameInterface {

    private final Stack<Cards> stackCards = new Stack<>();
    private Scanner input = new Scanner(System.in);
    private final Cards[] playerCards = new Cards[5];
    private final Cards dealerCards[] = new Cards[5];
    int cardCounter = 1;

    public Game() {

    }

    @Override
    public void populateCardsArray() {
        Suits[] arr = Suits.values();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 13; j++) {
                stackCards.push(new Cards(arr[i], (j + 1)));
            }
        }

    }

    @Override
    public void playGame() {
        String playerName, dealerName;
        int choice = 0;
        playerName = getName("Player");
        dealerName = getName("Dealer");

        // create player and dealer
        Player player = new Player(playerName);
        Dealer dealer = new Dealer(dealerName);
        populateCardsArray();
        do {
            try {
                if (cardCounter >= 1 && cardCounter < 2) {
                    playersCardsInitialization(player, dealer);
                    cardCounter += 1;
                } else if (cardCounter > 1 && cardCounter <= 5) {
                    choice = displayChoices();
                    choicePlays(choice, player, dealer);
                }

            } catch (CardException ex) {
                System.out.printf("ERROR: %s%n", ex.getMessage());
            }

        } while (choice != 1 && cardCounter < 5);
        if (cardCounter == 5) {
            try {
                dealer.flipCards(stackCards, dealerCards);
                getGameResults(player, dealer);
            } catch (CardException ex) {
                System.out.printf("ERROR: %s%n", ex.getMessage());
            }

        }

    }

    @Override
    public void playersCardsInitialization(Player player, Dealer dealer) throws CardException {
        player.addCards(playerCards, dealer.giveCard(stackCards));
        player.addCards(playerCards, dealer.giveCard(stackCards));
        player.viewCards(playerCards, "Player");

    }

    @Override
    public void choicePlays(int choice, Player player, Dealer dealer) throws CardException {
        switch (choice) {
            case 1:

                dealer.flipCards(stackCards, dealerCards);
                dealer.viewCards(dealerCards, "Dealer");
                getGameResults(player, dealer);
                break;
            default:
                dealer.shuffleCards(stackCards);
                player.addCards(playerCards, dealer.giveCard(stackCards));
                player.viewCards(playerCards, "Player");
                cardCounter += 1;

        }
    }

    @Override
    public boolean determineRoyalFlush() {
        boolean ace = false, royalCards = false;
        for (int cardNum = 0; cardNum < playerCards.length; cardNum++) {

            if (playerCards[cardNum] == null) {
                break;
            } else if (playerCards[cardNum].getCardNumber() == 1) {
                ace = true;
            }
            royalCards = getRoyalCards(playerCards[cardNum]);

        }
        return royalCards & ace;
    }

    @Override
    public boolean getRoyalCards(Cards card) {
        boolean jack = false, queen = false, king = false, ten = true;
        switch (card.getCardNumber()) {
            case 10:
                ten = true;
            case 11:
                jack = true;
                break;
            case 12:
                queen = true;
                break;
            case 13:
                king = true;
                break;
            default:
                break;
        }

        return jack && queen && king && ten;
    }

    @Override
    public void getGameResults(Player player, Dealer dealer) {

        if (player.getSumOfCards(playerCards) > dealer.getSumOfCards(dealerCards) || determineRoyalFlush()) {
            System.out.printf("%nPLAYER [%s]"
                    + "%n=================================%n"
                    + "Total Sum of Player Cards [%d]%n"
                    + "Total Sum of Dealer Cards [%d]%n"
                    + "You have WON!%n%n", player.getName(), player.getSumOfCards(playerCards), player.getSumOfCards(dealerCards));

        } else if ((player.getSumOfCards(playerCards) == dealer.getSumOfCards(dealerCards))
                || (player.getSumOfCards(playerCards) < dealer.getSumOfCards(dealerCards))) {

            System.out.printf("%nPLAYER [%s]%n"
                    + "%n=================================%n"
                    + "Total Sum of Player Cards [%d]%n"
                    + "Total Sum of Dealer Cards [%d]%n"
                    + "Black Check%nYou  LOSE!!%n%n", player.getName(), player.getSumOfCards(playerCards), player.getSumOfCards(dealerCards));
        }
    }

    @Override
    public String getName(String str) {
        String name;
        do {
            System.out.printf("Please enter a %s name: ", str);
            name = input.nextLine();
        } while (name == null);

        return name;
    }

    @Override
    public int displayChoices() {
        boolean isValid;
        int choice;
        do {
            System.out.printf("1 > Stick%n"
                    + "2 > Get Card%n"
                    + "Your choice: ");
            choice = input.nextInt();
            isValid = choice >= 1 || choice <= 2;

        } while (!isValid);

        return choice;
    }
}
