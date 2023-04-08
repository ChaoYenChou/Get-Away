package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Suit;
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
            String chosenSuit;
            String chosenValue;
            do {
                System.out.println("\nPlay a card in hand: ");
                String chosenCard = scan.nextLine();
                StringTokenizer tokenChosen = new StringTokenizer(chosenCard);
                chosenSuit = tokenChosen.nextToken();
                chosenValue = tokenChosen.nextToken();
                if(!playableCard(cardTable, chosenSuit)){
                    System.out.println("Please select a playable card (same suit)");
                }
            } while (!playableCard(cardTable, chosenSuit));  //loop if you have same suit in hand

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

    private boolean playableCard(CardTable cardTable, String chosenSuit) {
        boolean sameSuitInHand = false;
        ArrayList<PokerCard> cardsOnTable = cardTable.getPokerCards();
        if (cardsOnTable.size() > 0) {
            Suit cardSuit = cardsOnTable.get(0).getSuit();
            for (PokerCard pokerCard : playerHand) {
                if (cardSuit == pokerCard.getSuit()) { //same suit exist
                    sameSuitInHand = true;
                    break;
                }
            }
            if (sameSuitInHand && !cardSuit.toString().equalsIgnoreCase(chosenSuit)) {
                return false;
            }
        }
        return true;
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
