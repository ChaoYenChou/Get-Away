package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;
import java.util.Scanner;

public class GetAway extends Game {

    private static ArrayList<GetAwayPlayer> getAwayPlayers;// the players of the game
    private static int currentPlayer;  //0 to (numberofplayer -1)
    private static int highestValuePlayer = -1; //player who plays the highest value card this round
    private static Value highestValue = PokerCard.Value.TWO; //highest value card this round
    private static ArrayList<PokerCard> cardsOnTable;
    private static CardDeck cardDeck = new CardDeck();
    private static WastePile wastePile = new WastePile();
    private static CardTable cardTable = new CardTable();

    public GetAway(String name) {
        super(name);
    }

    public void clearTable() {
        // TODO - implement GetAway.clearTable
    }

    public void play(int numberOfPlayer) { //parameter not important fix later    
        cardDeck.distributeCards(numberOfPlayer); //useScanner
        CardHands.sortCardHands();
        createPlayerList(numberOfPlayer); //use Scanner
        findStartPlayer();
        firstRound();
        while (!endGame()) { // number of people with cards>1
            followingRounds();
            CardHands.sortCardHands();
        }
        declareLoser();

    }

    @Override
    public void play() {

    }

    @Override
    public void declareWinner() {

    }

    private void declareLoser() {
        int peopleWithCards = 0;
        for (CardHand cardHand : CardHands.getCardHands()) {
            if (cardHand.getPokerCards().size() > 0) {
                break;
            }
            peopleWithCards++;
        }
        System.out.println("The Loser is Player: " + peopleWithCards);
    }

    public void createPlayerList(int numberOfPlayer) {
        //scanner enter number here

        ArrayList<GetAwayPlayer> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayer; i++) {
            players.add(new GetAwayPlayer(Integer.toString(i), i));
        }
        setGetAwayPlayers(players);
    }

    public void findStartPlayer() {
        findloop:
        for (GetAwayPlayer getAwayPlayer : getAwayPlayers) { //play for a round
            for (PokerCard pokerCard : getAwayPlayer.getPlayerHand()) {
                if (pokerCard.getSuit().toString().equals("SPADES") && pokerCard.getValue().toString().equals("ACE")) {
                    currentPlayer = getAwayPlayers.indexOf(getAwayPlayer);
                    break findloop;
                }
            }
        }
        System.out.println("The game starts with player: " + currentPlayer);
    }

    private void firstRound() {
        for (GetAwayPlayer getAwayPlayer : getAwayPlayers) {
            //play for a round
            System.out.println("Current player is: " + currentPlayer);
            getAwayPlayers.get(currentPlayer).lookCardsInHand();
            getAwayPlayers.get(currentPlayer).play(cardTable); //add card onto table
            currentPlayer++; //todo: force first play ace of spades
            currentPlayer = currentPlayer % getAwayPlayers.size(); //goes back to p1 if starts at p4
        }
        wastePile.addPokerCard(cardTable.getPokerCards()); //move cards to waste piles
        cardTable.removeRangeCards();
        System.out.println("First Round Ends");
        System.out.println();
    }

    private void followingRounds() {
        for (GetAwayPlayer getAwayPlayer : getAwayPlayers) {
            //play for a round
            if (getAwayPlayers.get(currentPlayer).getPlayerHand().size() == 0) {
                currentPlayer++; //todo: force first play ace of spades
                currentPlayer = currentPlayer % getAwayPlayers.size(); //goes back to p1 if starts at p4
            } 
            else {
                System.out.println("Current player is: " + currentPlayer);
                getAwayPlayers.get(currentPlayer).lookCardsInHand();
                getAwayPlayers.get(currentPlayer).play(cardTable); //add card onto table

                if (!isSameSuit()) { //need to track who plays the highest value
                    playerTakeCards(cardTable);
                    currentPlayer = highestValuePlayer;
                    break; //end the round instantly
                } 
                else if (isSameSuit()) {
                    if (lastPlayedCard().getValue().ordinal() >= highestValue.ordinal()) {
                        highestValue = lastPlayedCard().getValue();
                        highestValuePlayer = getAwayPlayers.get(currentPlayer).getPlayerID();
                    }
                    currentPlayer++; //todo: force first play ace of spades
                    currentPlayer = currentPlayer % getAwayPlayers.size(); //goes back to p1 if starts at p4
                }
            }
        }
        highestValue = PokerCard.Value.TWO; //cleanup after each round
        highestValuePlayer = -1;
        wastePile.addPokerCard(cardTable.getPokerCards()); //move cards to waste piles
        cardTable.removeRangeCards();
        System.out.println("Round Ends");
        System.out.println();
    }

    private boolean isSameSuit() {
        //check if the last two cards are the same suit
        monitorTable();
        if (cardsOnTable.size() > 1) {
            if (lastPlayedCard().getSuit() != secondLastPlayedCard().getSuit()) {
                return false;
            }
        }
        return true;
    }

    private boolean endGame() {
        int peopleWithCards = 0;
        for (CardHand cardHand : CardHands.getCardHands()) {
            if (cardHand.getPokerCards().size() > 0) {
                peopleWithCards++;
            }
        }
        if (peopleWithCards == 1) {
            return true;
        }
        return false;

    }

    private void monitorTable() {
        cardsOnTable = cardTable.getPokerCards();
    }

    private PokerCard lastPlayedCard() {
        return cardsOnTable.get(cardsOnTable.size() - 1);
    }

    private PokerCard secondLastPlayedCard() {
        return cardsOnTable.get(cardsOnTable.size() - 2);
    }

    private void playerTakeCards(CardTable cardTable) {
        getAwayPlayers.get(highestValuePlayer).addCardsFromTable(cardTable);
    }

    private void setGetAwayPlayers(ArrayList<GetAwayPlayer> players) {
        getAwayPlayers = players;
    }

    private ArrayList<GetAwayPlayer> getGetAwayPlayers() {
        return GetAway.getAwayPlayers;
    }

}
