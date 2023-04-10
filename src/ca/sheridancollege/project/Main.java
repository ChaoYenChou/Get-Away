package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jivesh
 */
public class Main {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    GetAway game = new GetAway("GetAway");
    
    String input;
    boolean validInput = false;
    do {
        System.out.println("How many players do you want to create:");
        input = scan.nextLine();
        if (isInteger(input)) {
            validInput = true;
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
    } while (!validInput);
    
    int numberOfPlayers = Integer.parseInt(input);
    game.play(numberOfPlayers);
}

public static boolean isInteger(String input) {
    try {
        Integer.parseInt(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
}
        
        
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

        

