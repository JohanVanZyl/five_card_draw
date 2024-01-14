package com.johanvanzyl.poker;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    //We encapsulate the fact that we use a List<Card> to store our deck
    //instead of leaking it. This allows us to change the implementation
    //later on.
    private List<Card> cards;

    public DeckOfCards() {
        initialiseDeck();
    }

    private void initialiseDeck() {
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public int size() {
        return cards.size();
    }

}

