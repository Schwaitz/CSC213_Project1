package main.java.edu.canisius.csc213.project1;

import java.io.File;
import java.io.PrintWriter;
import java.lang.System;
import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.IntegerSyntax;

import main.java.edu.canisius.csc213.project1.Card.Rank;
import main.java.edu.canisius.csc213.project1.Card.Suit;

/**
 * UniqueHands class to analyze how long it takes to see every possible hand
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {

    public static void main(String[] args) {
        int[] deckSizes = { 24, 28 }; // Deck sizes to test
        int[] handSizes = { 6, 7 }; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");

        ArrayList<String> toWrite = new ArrayList<>();
        toWrite.add("Deck Size,Hand Size,Trial,Attempts,Time (sec)");

        // long time = measureTime(() -> {
        // countAttemptsToSeeAllHands(24, 6, true);
        // });

        // Deck Size,Hand Size,Trial,Attempts,Time (sec)
        // 24,6,1,1803213,3.990
        // 24,6,2,1463649,2.936

        // TODO: Implement nested loops
        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute
        // averages. Which is probably another loop!



        for (int i = 0; i < deckSizes.length; i++) {
            for (int j = 0; j < handSizes.length; j++) {
                for (int k = 0; k < trials; k++) {
                    int fi = deckSizes[i];
                    int fj = handSizes[j];

                    System.out.printf("Trial %d: Computing for (%d, %d)\n", k, fi, fj);

                    int attempts = 0;

                    long startTime = System.nanoTime();
                    attempts = countAttemptsToSeeAllHands(fi, fj, true);
                    long delta = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

                    String time = (double) delta / 1000 + " seconds";

                    toWrite.add(fi + "," + fj + "," + k + "," + attempts + "," + time);
                }
            }
        }

        writeToCSV("./csv/test.csv", toWrite);

    }

    interface Operation {
        void execute();
    }

    static long measureTime(Operation operation) {
        long startTime = System.nanoTime();
        operation.execute();
        return TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
    }

    public static void writeToCSV(String fileName, ArrayList<String> toWrite) {

        try {
            File f = new File(fileName);
            PrintWriter pw = new PrintWriter(f);

            for (String s : toWrite) {
                pw.println(s);
            }

            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToCSVAlt(String fileName, ArrayList<ArrayList<String>> toWrite) {

        try {
            File f = new File(fileName);
            PrintWriter pw = new PrintWriter(f);

            for (ArrayList<String> al : toWrite) {
                String s = String.join(",", al);
                pw.println(s);
            }

            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int calculateFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * calculateFactorial(n - 1);
    }

    public static int countAttemptsToSeeAllHands(int deckSize, int numCards) {
        return countAttemptsToSeeAllHands(deckSize, numCards, false);
    }

    // TODO: Implement countAttemptsToSeeAllHands()
    public static int countAttemptsToSeeAllHands(int deckSize, int numCards, boolean verbose) {

        int uniqueHands = calculateTotalUniqueHands(deckSize, numCards);
        Set<Hand> unique = new HashSet<>();

        int timesNonUnique = 0;
        int attempts = 0;

        Deck d = new Deck(deckSize);

        while (unique.size() < uniqueHands) {
            d.shuffle();
            Hand h = d.drawHand(numCards);
            h.sort();

            if (unique.add(h) == false) {
                timesNonUnique++;
            }

            d.add(h);

            double percentDone = (double) unique.size() / (double) uniqueHands * 100;
            if (verbose) {
                if (attempts % 100000 == 0) {
                    System.out.printf(
                            "%.3f%% coverage reached after %,d attempts (Unique Hands: %,d / %,d | Needed: %,d)\n",
                            percentDone, attempts, unique.size(), uniqueHands, uniqueHands - unique.size());
                }
            }
            attempts++;
        }

        return attempts;
    }

    // TODO: Implement calculateTotalUniqueHands()
    public static int calculateTotalUniqueHands(int deckSize, int numCards) {

        long df = deckSize;

        //System.out.print(df + " ");
        for (int i = deckSize - 1; i > (deckSize - numCards); i--) {
            //System.out.print(i + " ");
            df = df * i;
        }

        //System.out.println(": " + df);

        long nf = numCards;
        //ystem.out.print(nf + " ");
        for (int i = numCards - 1; i >= 1; i--) {
            //System.out.print(i + " ");
            nf = nf * i;
        }

        //System.out.println(": " + nf);

        return (int) (df / nf);
    }
}