package com.johanvanzyl.poker;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private List<Card> cards;
    private ShufflingAlgorithm shufflingAlgorithm;

    public DeckOfCards() {
        initialiseDeck();
        this.shufflingAlgorithm = new DefaultShuffingAlgorithmImpl();
    }

    public DeckOfCards(ShufflingAlgorithm algorithm) {
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

    public void shuffle() {
        shufflingAlgorithm.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

}

