package za.co.mecer.interfaces;

import java.util.Stack;
import za.co.mecer.cards.Cards;
import za.co.mecer.cards.suits.Suits;
import za.co.mecer.dealer.Dealer;
import za.co.mecer.exceptions.CardException;
import za.co.mecer.player.Player;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface GameInterface {

    default void populateCardsArray(Stack<Cards> stackCards) {
        stackCards.clear();
        Suits[] arr = Suits.values();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 13; j++) {
                stackCards.push(new Cards(arr[i], (j + 1)));
            }
        }
    }

    void playGame();

    // void playersCardsInitialization(Player player, Dealer dealer) throws CardException;
    void choicePlays(int choice, Player player, Dealer dealer) throws CardException;

    boolean determineRoyalFlush();

    boolean getRoyalCards(Cards card);

    void getGameResults(Player player, Dealer dealer);

    String getName(String str);

    int displayChoices();
}
