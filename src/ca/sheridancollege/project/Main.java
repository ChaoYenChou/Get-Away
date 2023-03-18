package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chou
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        GetAway game = new GetAway("GetAway");
        CardDeck cardDeck = new CardDeck(scan.nextInt()); //include size and generate
    
        CardHand[] cardHands = cardDeck.distributeCards(scan.nextInt());
        game.play(game.getPlayers(),cardHands);
    }
}
