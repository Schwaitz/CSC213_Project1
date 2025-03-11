package main.java.edu.canisius.csc213.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

import java.lang.IllegalArgumentException;

/**
 * Represents a deck of playing cards with a configurable size.
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    int size;

    /**
     * Creates a deck with a given size.
     * The size must be a multiple of 4 and at most 52.
     * 
     * @param size The number of cards in the deck.
     * @throws IllegalArgumentException if size is invalid.
     */
    public Deck(int size) {

        // TODO: Validate size (must be a multiple of 4 and at most 52).
        if (size % 4 != 0 || size == 0) {
            throw new IllegalArgumentException("Invalid deck size");
        }

        this.size = size;

        // TODO: Initialize the deck with the correct cards.

        int ranksToMake = size / 4;

        for (int i = 14; i > 14 - ranksToMake; i--) {
            cards.add(new Card(Card.Suit.HEARTS, Card.intRanks.get(i)));
            cards.add(new Card(Card.Suit.DIAMONDS, Card.intRanks.get(i)));
            cards.add(new Card(Card.Suit.CLUBS, Card.intRanks.get(i)));
            cards.add(new Card(Card.Suit.SPADES, Card.intRanks.get(i)));
        }

    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        // TODO: Implement shuffle logic.
        Collections.shuffle(cards);
    }

    public void add(Card c){
        cards.add(c);

    }

    public void add(Hand h){
        for(Card c : h.getCards()){
            cards.add(c);
        }
    }


    /**
     * Draws the top card from the deck.
     * 
     * @return The drawn card.
     * @throws NoSuchElementException if the deck is empty.
     */
    public Card draw() {
        // TODO: Implement draw logic.

        if (size() == 0) {
            throw new NoSuchElementException("Deck is empty");
        }

        Card toReturn = cards.get(0);
        cards.remove(toReturn);

        return toReturn;
    }

    public Hand drawHand(int i) {
        Hand toReturn = new Hand();
        for (int j = 0; j < i; j++) {
            if (size() == 0) {
                throw new NoSuchElementException("Deck is empty");
            }

            Card c = cards.get(0);
            toReturn.add(c);
            cards.remove(c);
        }

        return toReturn;
    }

    /**
     * Gets the number of remaining cards in the deck.
     *
     * @return The number of cards left.
     */
    public int size() {
        // TODO: Implement size method.
        return cards.size();
    }

    // TODO: Override toString() to return a readable format.
    @Override
    public String toString() {
        ArrayList<Card> hearts = new ArrayList<Card>();
        ArrayList<Card> diamonds = new ArrayList<Card>();
        ArrayList<Card> clubs = new ArrayList<Card>();
        ArrayList<Card> spades = new ArrayList<Card>();

        for (Card c : cards) {
            if (c.getSuit() == Card.Suit.HEARTS) {
                hearts.add(c);
            }
            if (c.getSuit() == Card.Suit.DIAMONDS) {
                diamonds.add(c);
            }
            if (c.getSuit() == Card.Suit.CLUBS) {
                clubs.add(c);
            }
            if (c.getSuit() == Card.Suit.SPADES) {
                spades.add(c);
            }
        }

        String toReturn = "";
        toReturn += "Hearts: " + hearts + "\n";
        toReturn += "Diamonds: " + diamonds + "\n";
        toReturn += "Clubs: " + clubs + "\n";
        toReturn += "Spades: " + spades;

        return toReturn;
    }

}