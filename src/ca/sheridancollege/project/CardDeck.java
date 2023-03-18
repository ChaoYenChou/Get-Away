package ca.sheridancollege.project;

import java.util.ArrayList;

public class CardDeck extends GroupOfCards {

    public CardDeck(int size) {
        super(size);
        generateDeck(size);
    }

    private void generateDeck(int size) {
        // TODO - implement CardDeck.generateDeck
    }

    public CardHand[] distributeCards(int numberOfPlayer) {
        // TODO - implement CardDeck.distributeCards
        CardHand[] cardHands = new CardHand[numberOfPlayer];
        return cardHands;
    }
}
