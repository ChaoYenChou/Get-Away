package ca.sheridancollege.project;

public class PokerCard extends Card {
      
    private Suit suit;
    private Value value;

    PokerCard(Suit suit, Value rank) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return suit.toString() + value.toString();
    }

    public enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS
    };

    public enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
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
