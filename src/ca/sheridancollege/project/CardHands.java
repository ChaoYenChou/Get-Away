package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class CardHands {
    
    private static CardHand[] cardHands;

    public static CardHand[] getCardHands() {
        return CardHands.cardHands;
    }

    public static void setCardHands(CardHand[] cardHands) {
        CardHands.cardHands = cardHands;
    }

    public static void sortCardHands() {
        CardHand one = CardHands.cardHands[0];
        ArrayList<PokerCard> two = one.getPokerCards();     
        Collections.sort(two);
    }
    public static CardHand showCardHand(int playerID){
        return CardHands.cardHands[playerID];
    }
}
