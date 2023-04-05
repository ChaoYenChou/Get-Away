package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck extends GroupOfCards {
    private List<Card> cards;

    public CardDeck() 
    {
        cards = new ArrayList<Card>();
        for (PokerCard.Suit suit : PokerCard.Suit.values()) {
            for (PokerCard.Value rank : PokerCard.Value.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

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
