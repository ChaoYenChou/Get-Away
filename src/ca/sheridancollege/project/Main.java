package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chou
 */
public class Main {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        
        //GetAway game = new GetAway("GetAway");
        //CardDeck cardDeck = new CardDeck(scan.nextInt()); //include size and generate
    
        //CardHand[] cardHands = cardDeck.distributeCards(scan.nextInt());
        //game.play(game.getPlayers(),cardHands);
        
        CardDeck cardDeck = new CardDeck();    
        CardHands cardHands = new CardHands();
        cardHands.setCardHands(cardDeck.distributeCards(3));
        cardHands.sortCardHands();
        CardHand[] test =cardHands.getCardHands();
        for(PokerCard pokerCard:test[0].getPokerCards()){
            System.out.println(pokerCard.toString());
        }
            
        
//        for(CardHand cardHand :cardHands.getCardHands()){
//            for(PokerCard pokerCard:cardHand.getPokerCards()){
//                System.out.println(pokerCard.toString());
//            }
//            System.out.println();
//        }

    }
}
