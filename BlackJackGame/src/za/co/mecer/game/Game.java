package za.co.mecer.game;

import java.util.Scanner;
import java.util.Stack;
import za.co.mecer.cards.Cards;
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
    Cards[] playerCards;
    Cards[] dealerCards;
    Player player;
    Dealer dealer;
    int cardCounter;

    public Game() {
        getPlayers();
    }

    public void getPlayers() {
        String playerName, dealerName;

        playerName = getName("Player");
        dealerName = getName("Dealer");
        // create player and dealer
        player = new Player(playerName);
        dealer = new Dealer(dealerName);
    }

    @Override
    public void playGame() {
        playerCards = new Cards[5];
        dealerCards = new Cards[5];
        int choice = 0, contChoice;
        populateCardsArray(stackCards);
        dealer.shuffleCards(stackCards);
        cardCounter = 0;
        do {
            try {
                if (cardCounter < 2) {
                    player.addCards(playerCards, dealer.giveCard(stackCards));
                    if (cardCounter == 1) {
                        player.viewCards(playerCards, "[PLAYER] ".concat(player.getName()));
                    }
                    cardCounter += 1;
                } else if (cardCounter < 5) {
                    choice = displayChoices();
                    choicePlays(choice, player, dealer);
                }

            } catch (CardException ex) {
                System.out.printf("%nERROR: %s%n", ex.getMessage());
            }

        } while (choice != 1 && cardCounter < 5);
        if (cardCounter == 5) {
            try {
                dealer.flipCards(stackCards, dealerCards);
                getGameResults(player, dealer);
            } catch (CardException ex) {
                System.out.printf("%nERROR: %s%n", ex.getMessage());
            }

        }
        try {
            contChoice = getPlayChoice();
            if (contChoice == 1) {
                playGame();
            } else {
                System.out.printf("\n==========================================\n"
                        + "\tTHANK YOU FOR PLAYING\n"
                        + "\n==========================================\n");
            }
        } catch (CardException ex) {
            System.out.printf("%nERROR: %s%n", ex.getMessage());
        }
    }

    public int getPlayChoice() throws CardException {
        boolean isValid = true;
        int choice = 0;
        do {
            System.out.print("Press [1] to Play or [2] to exit the Game: ");
            choice = input.nextInt();
            if (choice < 0 && choice > 2) {
                isValid = false;
                throw new CardException("\nEnter either 1 or 2\n");

            }
        } while (!isValid);

        return choice;
    }

    @Override
    public void choicePlays(int choice, Player player, Dealer dealer) throws CardException {
        switch (choice) {
            case 1:
                dealer.flipCards(stackCards, dealerCards);
                dealer.viewCards(dealerCards, "[DEALER] ".concat(dealer.getName()));
                getGameResults(player, dealer);
                break;
            default:

                player.addCards(playerCards, dealer.giveCard(stackCards));
                player.viewCards(playerCards, "[PLAYER] ".concat(player.getName()));
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
            System.out.printf("%n%nPLAYER [%s]"
                    + "%n=================================%n"
                    + "Total Sum of Player Cards [%d]%n"
                    + "Total Sum of Dealer Cards [%d]%n"
                    + "You WIN!%n%n", player.getName(), player.getSumOfCards(playerCards), player.getSumOfCards(dealerCards));

        } else if ((player.getSumOfCards(playerCards) == dealer.getSumOfCards(dealerCards))
                || (player.getSumOfCards(playerCards) < dealer.getSumOfCards(dealerCards))) {

            System.out.printf("%n%nPLAYER [%s]%n"
                    + "%n=================================%n"
                    + "Total Sum of Player Cards [%d]%n"
                    + "Total Sum of Dealer Cards [%d]%n"
                    + "Black Jack%nYou  LOSE!!%n%n", player.getName(), player.getSumOfCards(playerCards), player.getSumOfCards(dealerCards));
        }
    }

    @Override
    public String getName(String str) {
        String name;
        do {
            System.out.printf("\nPlease enter a %s name: ", str);
            name = input.next();
        } while (name.isEmpty());

        return name;
    }

    @Override
    public int displayChoices() {
        boolean isValid;
        int choice;
        do {
            System.out.printf("%n1 > Stick%n"
                    + "2 > Get Card%n"
                    + "Your choice: ");
            choice = input.nextInt();
            isValid = choice >= 1 || choice <= 2;

        } while (!isValid);

        return choice;
    }
}
