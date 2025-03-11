package main.java.edu.canisius.csc213.project1;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents a playing card with a suit and rank.
 */
public class Hand {

    // TODO: Define private fields for suit and rank.

    private ArrayList<Card> cards;

    // TODO: Implement the constructor.
    public Hand(){
        cards = new ArrayList<>();
    }


    public Hand(ArrayList<Card> al){
        cards = al;
    }

    // TODO: Implement getters for suit and rank.

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void add(Card c){
        cards.add(c);
    }

    public void remove(int i){
        cards.remove(i);
    }

    public Card get(int i){
        return cards.get(i);
    }


    public void sort(){
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.toString().compareTo(c2.toString());
            }
        });
    }


    // TODO: Override toString() to return a readable format.
    @Override
    public String toString() {
        String toReturn = "Hand: ";

        for(Card c : cards){
            toReturn += c.getRank() + " of " + c.getSuit() + ", ";
        }

        return toReturn.substring(0, toReturn.length() - 2);
    }

    // TODO: Override equals() and hashCode() for comparisons.

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }

        Hand hand = (Hand) obj;


        if(cards.size() != hand.cards.size()){
            return false;
        }
        
        for(int i = 0; i < hand.cards.size(); i++){

            if(cards.get(i).getSuit() != hand.cards.get(i).getSuit() || cards.get(i).getRank() != hand.cards.get(i).getRank()){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}