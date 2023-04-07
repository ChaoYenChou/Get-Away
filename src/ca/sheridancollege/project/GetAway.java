package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;
import java.util.Scanner;

public class GetAway extends Game {
    
    private static ArrayList<GetAwayPlayer> getAwayPlayers;// the players of the game
    private static int currentPlayer;  //0 to (numberofplayer -1)
    private static int highestValuePlayer; //player who plays the highest value card this round
    private static Value highestValue; //highest value card this round
    
    public GetAway(String name){
        super(name);
    }

    public void clearTable() {
        // TODO - implement GetAway.clearTable
        
    }

    
    public static void play(int i) { //parameter not important fix later
        findStartPlayer();
        firstRound();
        followingRounds();
        
    }
    
    @Override
    public void play() {
        
    }

    @Override
    public void declareWinner() {

    }

    public static void createPlayerList() {
        //scanner enter number here
        System.out.println("How many players do you want to create:");
        Scanner scan = new Scanner(System.in);
        ArrayList<GetAwayPlayer> players = new ArrayList<>();
        int numberOfPlayer = scan.nextInt();
        for(int i = 0; i < numberOfPlayer ; i++){
            players.add(new GetAwayPlayer(Integer.toString(i),i));
        }
        setGetAwayPlayers(players);
    }

    private static void assignCards() {
        
    }
    
    public static void findStartPlayer(){
        findloop:
        for(GetAwayPlayer getAwayPlayer : getAwayPlayers){ //play for a round
            for(PokerCard pokerCard : getAwayPlayer.getPlayerHand()){
                if(pokerCard.getSuit().toString().equals("SPADES") && pokerCard.getValue().toString().equals("ACE")){
                    currentPlayer = getAwayPlayers.indexOf(getAwayPlayer);
                    break findloop;
                }
            }
        }
        System.out.println("The game starts with player: " + currentPlayer);
    }

    private static void firstRound() {
        for (GetAwayPlayer getAwayPlayer : getAwayPlayers) {
            //play for a round
            getAwayPlayers.get(currentPlayer).play(); //add card onto table
            currentPlayer++; //todo: force first play ace of spades
            currentPlayer = currentPlayer % getAwayPlayers.size(); //goes back to p1 if starts at p4
            
        }
        WastePile.addPokerCard(CardTable.getPokerCards()); //move cards to waste piles
        CardTable.removeRangeCards();
    }

    private static void followingRounds() {
        for (GetAwayPlayer getAwayPlayer : getAwayPlayers) {
            //play for a round
            getAwayPlayers.get(currentPlayer).play(); //add card onto table
            if(!isSameSuit()){
                addCardsFromTable();
                break;
            }
            currentPlayer++; //todo: force first play ace of spades
            currentPlayer = currentPlayer % getAwayPlayers.size(); //goes back to p1 if starts at p4
            
        }
        WastePile.addPokerCard(CardTable.getPokerCards()); //move cards to waste piles
        CardTable.removeRangeCards();
        
    }
    private static boolean isSameSuit(){
        //check if the last two cards are the same suit
        ArrayList<PokerCard> cardsOnTable =CardTable.getPokerCards();
        if(cardsOnTable.size()>1){
            if(cardsOnTable.get(cardsOnTable.size()-1).getSuit() == cardsOnTable.get(cardsOnTable.size()-2).getSuit()){
                return true;
            }
            return false;
        }
        else if(cardsOnTable.size()<= 1){
            return false;
        }
        return false;
    }
    
    private static void addCardsFromTable() {
        CardTable.getPokerCards();
    }
    
    private static void setGetAwayPlayers(ArrayList<GetAwayPlayer> players) {
        GetAway.getAwayPlayers = players;
    }
    
    private static ArrayList<GetAwayPlayer> getGetAwayPlayers() {
        return GetAway.getAwayPlayers;
    }

}
