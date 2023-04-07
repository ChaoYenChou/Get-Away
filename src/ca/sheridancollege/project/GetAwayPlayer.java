package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GetAwayPlayer extends Player {

    private int playerID;
    private ArrayList<PokerCard> playerHand;

    public GetAwayPlayer(String name, int playerID) {
        super(name);
        this.playerID = playerID;
        this.playerHand = CardHands.showCardHand(this.playerID).getPokerCards();
    }

    @Override
    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Play a card in hand");
        String chosenCard = scan.nextLine();
        StringTokenizer tokenChosen = new StringTokenizer(chosenCard);
        String chosenSuit = tokenChosen.nextToken();
        String chosenValue = tokenChosen.nextToken();

        Boolean cardExistInHand = false;
        do {
            //todo: add play restrictions
            for (PokerCard pokerCard : playerHand) {
                if (pokerCard.getSuit().toString().equalsIgnoreCase(chosenSuit)
                        && pokerCard.getValue().toString().equalsIgnoreCase(chosenValue)) {
                    CardTable.addPokerCard(pokerCard);
                    playerHand.remove(pokerCard);
                    cardExistInHand = true;
                    System.out.println("You played: " + pokerCard.getSuit().toString() + " " + pokerCard.getValue().toString());
                }
            }
            if (cardExistInHand == false) {
                System.out.println("Choose a card that exist");
            }
        } while (!cardExistInHand);

    }

    public void lookCardsInHand() {
        System.out.println("Cards in hand: ");
        for (PokerCard pokerCard : playerHand) {
            System.out.print(pokerCard.toString() + " ");
        }
    }

    public ArrayList<PokerCard> getPlayerHand() {
        return playerHand;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

}
