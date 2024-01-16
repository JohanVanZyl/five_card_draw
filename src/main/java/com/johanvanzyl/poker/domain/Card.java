package com.johanvanzyl.poker.domain;

public class Card {

    private final Rank rank;
    private final Suit suit;
    public enum Suit {
        HEARTS("H", "♥️"),DIAMONDS("D", "♦️"),CLUBS("C","♣"),SPADES("S", "♠️");

        private final String abbreviation;
        private final String character;

        Suit(String abbreviation, String character) {
            this.abbreviation = abbreviation;
            this.character = character;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public String getCharacter() {
            return character;
        }
    }
    public enum Rank {
        ACE("A"), 
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("T"),
        JACK("J"),
        QUEEN("Q"),
        KING("K");

        private final String abbreviation;
        
        Rank(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank.abbreviation + suit.abbreviation;
    }

    public String toUnicodeString() {
        return rank.abbreviation + suit.character;
    }

}
