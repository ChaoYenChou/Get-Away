package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GetAway extends Game {
    
    public GetAway(String name){
        super(name);
    }

    public void clearTable() {
        // TODO - implement GetAway.clearTable
        
    }

    
    public void play(ArrayList<Player> players, CardHand[] cardHands) {
        firstRound(players, cardHands);
        followingRounds();
        
    }
    
    @Override
    public void play() {
        
    }

    @Override
    public void declareWinner() {

    }

    public void createPlayerList() {
        //scanner enter number here
        Scanner scan = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i < scan.nextInt() ; i++){
            players.add(new GetAwayPlayer(Integer.toString(i)));
        }
        super.setPlayers(players);
    }

    private void assignCards() {
        
    }

    private void firstRound(ArrayList<Player> players, CardHand[] cardHands) {
        //sample play
        players.get(0).play();
    }

    private void followingRounds() {
        
    }

}
