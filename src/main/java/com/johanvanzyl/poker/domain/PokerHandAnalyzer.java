package com.johanvanzyl.poker.domain;

import java.util.Arrays;
import java.util.HashSet;

/**
 * This class is used with minor modifications from https://rosettacode.org/wiki/Poker_hand_analyser#Java
 */
public class PokerHandAnalyzer {

    final static String faces = "AKQJT98765432";
    final static String suits = "HDSC";
    final static String[] deck = buildDeck();

    public static void main(String[] args) {
        System.out.println("Regular hands:\n");
        for (String input : new String[]{"2H 2D 2S KS QD",
            "2H 5H 7D 8S 9D",
            "AH 2D 3S 4S 5S",
            "2H 3H 2D 3S 3D",
            "2H 7H 2D 3S 3D",
            "2H 7H 7D 7S 7C",
            "TH JH QH KH AH",
            "4H 4C KC 5D TC",
            "QC TC 7C 6C 4C",
            "QC TC 7C 7C TD"}) {
            System.out.println(analyzeHand(input.split(" ")));
        }
    }

    public static String evaluateHand(final String[] hand) {
        return analyzeHand(hand).toString();
    }
    private static Score analyzeHand(final String[] hand) {
        if (hand.length != 5)
            return new Score("invalid hand: wrong number of cards", -1, hand);

        if (new HashSet<>(Arrays.asList(hand)).size() != hand.length)
            return new Score("invalid hand: duplicates", -1, hand);

        int[] faceCount = new int[faces.length()];
        long straight = 0, flush = 0;
        for (String card : hand) {

            int face = faces.indexOf(card.charAt(0));
            if (face == -1)
                return new Score("invalid hand: non existing face", -1, hand);
            straight |= (1 << face);

            faceCount[face]++;

            if (suits.indexOf(card.charAt(1)) == -1)
                return new Score("invalid hand: non-existing suit", -1, hand);
            flush |= (1 << card.charAt(1));
        }

        // shift the bit pattern to the right as far as possible
        while (straight % 2 == 0)
            straight >>= 1;

        // straight is 00011111; A-2-3-4-5 is 1111000000001
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;

        // unsets right-most 1-bit, which may be the only one set
        boolean hasFlush = (flush & (flush - 1)) == 0;

        if (hasStraight && hasFlush)
            return new Score("Straight flush", 9, hand);

        int total = 0;
        for (int count : faceCount) {
            if (count == 4)
                return new Score("Four of a kind", 8, hand);
            if (count == 3)
                total += 3;
            else if (count == 2)
                total += 2;
        }

        if (total == 5)
            return new Score("Full house", 7, hand);

        if (hasFlush)
            return new Score("Flush", 6, hand);

        if (hasStraight)
            return new Score("Straight", 5, hand);

        if (total == 3)
            return new Score("Three of a kind", 4, hand);

        if (total == 4)
            return new Score("Two pair", 3, hand);

        if (total == 2)
            return new Score("One pair", 2, hand);

        return new Score("High card", 1, hand);
    }


    private static String[] buildDeck() {
        String[] dck = new String[suits.length() * faces.length()];
        int i = 0;
        for (char s : suits.toCharArray()) {
            for (char f : faces.toCharArray()) {
                dck[i] = "" + f + s;
                i++;
            }
        }
        return dck;
    }

    private static class Score {
        final int weight;
        final String name;
        final String[] hand;

        Score(String n, int w, String[] h) {
            weight = w;
            name = n;
            hand = h != null ? h.clone() : h;
        }

        @Override
        public String toString() {
            return name;
        }

    }

}