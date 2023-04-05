package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Suit;
import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck extends GroupOfCards {

    private List<Card> cards;

    public CardDeck() {
        for (PokerCard.Suit suit : PokerCard.Suit.values()) {
            for (PokerCard.Value rank : PokerCard.Value.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
        shuffle();
    }
    
    public CardDeck(int size){
        
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

    private void generateDeck(int size) {

        // TODO - implement CardDeck.generateDeck
        for (Suit suit : PokerCard.Suit.values()) {
            for (Value value : PokerCard.Value.values()) {
                super.addCards(new PokerCard(suit, value));
            }
        }
    }

    public CardHand[] distributeCards(int numberOfPlayer) {
        // TODO - implement CardDeck.distributeCards
        CardHand[] cardHands = new CardHand[numberOfPlayer];
        return cardHands;
    }
}
