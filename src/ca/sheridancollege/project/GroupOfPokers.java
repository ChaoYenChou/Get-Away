package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Chao Yen Chou
 */
public class GroupOfPokers extends GroupOfCards{
        //The group of cards, stored in an ArrayList
    private ArrayList<PokerCard> pokerCards;
    private int size;//the size of the grouping

    public GroupOfPokers(int size) {
        this.size = size;
    }
    

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    
    public ArrayList<PokerCard> getPokerCards() {
        return this.pokerCards;
    }
    public void removeRangeCards(int start, int end) {
        pokerCards.subList(start, end).clear();
    }

    public void setCards(ArrayList<PokerCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(pokerCards);
    }
  
}
