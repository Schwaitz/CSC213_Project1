package main.java.edu.canisius.csc213.project1;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * Represents a playing card with a suit and rank.
 */
public class Card {

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    public enum Rank { 
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE 
    }

    public static Map<Rank, Integer> rankInts = new HashMap<Rank, Integer>(){{
        put(Rank.TWO, 2);
        put(Rank.THREE, 3);
        put(Rank.FOUR, 4);
        put(Rank.FIVE, 5);
        put(Rank.SIX, 6);
        put(Rank.SEVEN, 7);
        put(Rank.EIGHT, 8);
        put(Rank.NINE, 9);
        put(Rank.TEN, 10);
        put(Rank.JACK, 11);
        put(Rank.QUEEN, 12);
        put(Rank.KING, 13);
        put(Rank.ACE, 14);
    }};

    public static Map<Integer, Rank> intRanks = new HashMap<Integer, Rank>(){{
        put(2, Rank.TWO);
        put(3, Rank.THREE);
        put(4, Rank.FOUR);
        put(5, Rank.FIVE);
        put(6, Rank.SIX);
        put(7, Rank.SEVEN);
        put(8, Rank.EIGHT);
        put(9, Rank.NINE);
        put(10, Rank.TEN);
        put(11, Rank.JACK);
        put(12, Rank.QUEEN);
        put(13, Rank.KING);
        put(14, Rank.ACE);
    }};

    // TODO: Define private fields for suit and rank.

    private Suit suit;
    private Rank rank;

    // TODO: Implement the constructor.
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    // TODO: Implement getters for suit and rank.

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public int getRankInt(){
        return rankInts.get(rank);
    }


    // TODO: Override toString() to return a readable format.
    @Override
    public String toString() {
        return rank + " of " + suit;
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

        Card card = (Card) obj;
        return suit == card.getSuit() && rank == card.getRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}