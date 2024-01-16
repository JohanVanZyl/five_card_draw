package com.johanvanzyl.poker.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DeckOfCards {
    private List<Card> cards;
    private Shuffler shufflingAlgorithm;

    public DeckOfCards() {
        this(new DefaultShufflerImpl());
    }

    public DeckOfCards(Shuffler algorithm) {
        initialiseDeck();
        this.shufflingAlgorithm = algorithm;
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

    public boolean shuffle() {
        return shufflingAlgorithm.shuffle(cards);
    }

    /*
     * FIXME: This looks like a code smell. I don't need this method in my business logic, 
     * only in my tests to compare a shuffled vs unshuffled deck.
     * Find another way...
     */
    public List<Card> getCards() {
        return cards;
    }

    public Card drawCard() throws EmptyDeckException {
        try {
            return cards.removeFirst();
        } catch (NoSuchElementException e) {
            throw new EmptyDeckException("No more cards left to draw in deck.");
        }
    }

}

