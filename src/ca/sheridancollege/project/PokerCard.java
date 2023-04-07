package ca.sheridancollege.project;

public class PokerCard extends Card implements Comparable<PokerCard>{

    private Suit suit;
    private Value value;

    @Override
    public String toString() {
        return suit.toString() + " " + value.toString();
    }

    public PokerCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
        
    }
    
    @Override
    public int compareTo(PokerCard pokerCard) {  //combine with Collections.sort
        if(this.suit.ordinal() > pokerCard.suit.ordinal()){
            return 1;
        }
        else if(this.suit.ordinal() < pokerCard.suit.ordinal()){
            return -1;
        }
        else if(this.suit.ordinal() == pokerCard.suit.ordinal()){
            if(this.value.ordinal() > pokerCard.value.ordinal()){
                return 1;
            }
            else if(this.value.ordinal() < pokerCard.value.ordinal()){
                return -1;
            }
            else if(this.value.ordinal() == pokerCard.value.ordinal()){
                return 0;
            }
        } 
        return 0;
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

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}
