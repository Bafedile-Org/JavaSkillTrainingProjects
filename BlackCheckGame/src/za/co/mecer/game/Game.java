package za.co.mecer.game;

import java.util.ArrayList;
import za.co.mecer.cards.Cards;
import za.co.mecer.cards.suits.Suits;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Game {

    private Cards card;
    private final ArrayList<Cards> cards = new ArrayList<>();

    public Game() {

    }

    public void populateCardsArray() {
        Suits[] arr = Suits.values();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Cards(arr[i], (j + 1)));
            }
        }

    }
}
