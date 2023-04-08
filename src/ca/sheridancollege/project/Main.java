package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chou
 */
public class Main {

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);

        GetAway game = new GetAway("GetAway");
        // CardDeck cardDeck = new CardDeck(scan.nextInt()); //include size and generate
        // CardHand[] cardHands = cardDeck.distributeCards(scan.nextInt());
        // game.play(game.getPlayers(),cardHands);
        System.out.println("How many players do you want to create:");
        Scanner scan = new Scanner(System.in);
        int numberOfPlayer = scan.nextInt();
        game.play(numberOfPlayer);
        
        
//       for (CardHand cardHand : CardHands.getCardHands()) {
//            for (PokerCard pokerCard : cardHand.getPokerCards()) {
//                System.out.println(pokerCard.toString());
//            }
//            System.out.println();
//        }
       
//       GetAway.findStartPlayer();
//        GetAwayPlayer player1 = new GetAwayPlayer("0", 0);
//        player1.lookCardsInHand();
//        player1.play();

        

    }
}
