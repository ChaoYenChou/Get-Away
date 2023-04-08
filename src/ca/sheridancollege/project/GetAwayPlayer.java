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

    public void play(CardTable cardTable) {
        Scanner scan = new Scanner(System.in);

        Boolean cardExistInHand = false;
        do {
            System.out.println();
            System.out.println("Play a card in hand");
            String chosenCard = scan.nextLine();
            StringTokenizer tokenChosen = new StringTokenizer(chosenCard);
            String chosenSuit = tokenChosen.nextToken();
            String chosenValue = tokenChosen.nextToken();
            //todo: add play restrictions
            for (PokerCard pokerCard : playerHand) {
                if (pokerCard.getSuit().toString().equalsIgnoreCase(chosenSuit)
                        && pokerCard.getValue().toString().equalsIgnoreCase(chosenValue)) {
                    cardTable.addPokerCard(pokerCard);
                    playerHand.remove(pokerCard);
                    cardExistInHand = true;
                    System.out.println("You played: " + pokerCard.getSuit().toString() + " " + pokerCard.getValue().toString());
                    break;
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
            System.out.print(pokerCard.toString() + ", ");
        }
    }

    public void addCardsFromTable(CardTable cardTable) {
        playerHand.addAll(cardTable.getPokerCards());
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

    @Override
    public void play() {
    
    }

}
