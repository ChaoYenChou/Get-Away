package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Suit;
import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;

public class CardDeck extends GroupOfCards {

    public CardDeck() {
        super(52);
        generateDeck();
        //shuffle();
    }

    public CardDeck(int size) {
        super(size);
        generateDeck(size);
    }

    private void generateDeck(int size) {
        // TODO - implement CardDeck.generateDeck
    }

    private void generateDeck() {
        ArrayList cardDeck = new ArrayList();
        for (Suit suit : PokerCard.Suit.values()) {
            for (Value value : PokerCard.Value.values()) {
                super.addCard(new PokerCard(value, suit));
            }
        }
    }

    public CardHand[] distributeCards(int numberOfPlayer) {
        // TODO - implement CardDeck.distributeCards
        CardHand[] cardHands = new CardHand[numberOfPlayer];
        return cardHands;
    }
}
