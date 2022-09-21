package za.co.mecer.interfaces;

import za.co.mecer.cards.Cards;
import za.co.mecer.dealer.Dealer;
import za.co.mecer.exceptions.CardException;
import za.co.mecer.player.Player;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface GameInterface {

    void populateCardsArray();

    void playGame();

    void playersCardsInitialization(Player player, Dealer dealer) throws CardException;

    void choicePlays(int choice, Player player, Dealer dealer) throws CardException;

    boolean determineRoyalFlush();

    boolean getRoyalCards(Cards card);

    void getGameResults(Player player, Dealer dealer);

    String getName(String str);

    int displayChoices();
}
