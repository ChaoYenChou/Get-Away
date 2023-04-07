package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfPokersStatic extends GroupOfCards{
    private static ArrayList<PokerCard> pokerCards;
    public GroupOfPokersStatic(int size) {
    }
    

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    
    public static ArrayList<PokerCard> getPokerCards() {
        return GroupOfPokersStatic.pokerCards;
    }
    public static void removeRangeCards(int start, int end) {
        pokerCards.subList(start, end).clear();
    }
    public static void removeRangeCards(){
        pokerCards.clear();
    }

    public static void setCards(ArrayList<PokerCard> pokerCards) {
        GroupOfPokersStatic.pokerCards = pokerCards;
    }
    
    public static void addPokerCard(PokerCard pokerCard){
        GroupOfPokersStatic.pokerCards.add(pokerCard);
    }
    public static void addPokerCard(ArrayList<PokerCard> cards){
        GroupOfPokersStatic.pokerCards.addAll(cards);
    }
    

    @Override
    public void shuffle() {
        Collections.shuffle(pokerCards);
    }
}
