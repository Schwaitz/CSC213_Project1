package main.java.edu.canisius.csc213.project1;


import java.lang.System;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.IntegerSyntax;
/**
 * UniqueHands class to analyze how long it takes to see every possible hand 
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {
    public static void main(String[] args) {
        int[] deckSizes = {24, 28}; // Deck sizes to test
        int[] handSizes = {6, 7}; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");


        long time = measureTime(() -> {

            for(int i = 0; i < 100000; i++){
                Deck d = new Deck(24);
                d.shuffle();
            }

        });

        System.out.println(time);

       // Deck d = new Deck(24);

       // System.out.println(d);

        // TODO: Implement nested loops
        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

        for(int i = deckSizes[0]; i <= deckSizes[1]; i++){
            for(int j = handSizes[0]; j <= handSizes[1]; j++){

            }
        }

    }

    interface Operation {
        void execute();
    }

    static long measureTime(Operation operation) {
        long startTime = System.nanoTime();
        operation.execute();
        return TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
    }

   

    // TODO: Implement countAttemptsToSeeAllHands()
    public static int countAttemptsToSeeAllHands(int i1, int i2){

        return -1;
    }

    // TODO: Implement calculateTotalUniqueHands()
    public static int calculateTotalUniqueHands(int i1, int i2){

        return -1;
    }
}