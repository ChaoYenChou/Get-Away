package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardHands {
    private CardHand[] cardHands;

    public CardHand[] getCardHands() {
        return cardHands;
    }

    public void setCardHands(CardHand[] cardHands) {
        this.cardHands = cardHands;
    }
    public void sortCardHands(){
        CardHand  one = this.cardHands[0];
        ArrayList<PokerCard> two = new ArrayList();
        two = one.getPokerCards();
        Collections.sort(two);
    }
}
