package ca.sheridancollege.project;

public class PokerCard extends Card {
      
    private Suit suit;
    private Value value;

    public PokerCard(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }        
    
    @Override
    public String toString() {
        return suit.toString() + value.toString();
    }
    
    public enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS
    };

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    };

    
    public Suit getSuit() {
        return this.suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

}
