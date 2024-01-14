package com.johanvanzyl.poker;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckOfCardsTest {
    
    public static final int DECK_SIZE = 52;

    @Test
    public void initialiseDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(DECK_SIZE, deck.size()); 
    }

    @Test
    public void getCardsTest() {
        DeckOfCards deck = new DeckOfCards();
        List<Card> allCards = deck.getCards();
       
        assertEquals(DECK_SIZE, allCards.size());
    }

    @Test
    public void shuffleDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        List<Card> originalOrder = List.copyOf(deck.getCards());

        deck.shuffle();
        List<Card> shuffledOrder = List.copyOf(deck.getCards());

        // Ensure that the order changed after shuffling the deck 
        assertNotEquals(originalOrder, shuffledOrder);

        // Ensure both decks are the same size
        assertEquals(originalOrder.size(), shuffledOrder.size());

        // Ensure all cards from original deck are still present after shuffling
        Set<Card> originalSet = new HashSet<>(originalOrder);
        Set<Card> shuffledSet = new HashSet<>(shuffledOrder);
        assertEquals(originalSet, shuffledSet);

    }

    @Test
    public void drawCardTest() {
        DeckOfCards deck = new DeckOfCards();
        Card undrawnTopCard = List.copyOf(deck.getCards()).get(0);

        Card drawnCard = deck.drawCard();

        assertEquals(undrawnTopCard, drawnCard);

        assertEquals(deck.size(), DECK_SIZE - 1); 
    }

    @Test(expected = EmptyDeckException.class)
    public void drawCardFromEmptyDeckRaisesExceptionTest() {
        DeckOfCards deck = new DeckOfCards();

        for(int i = 1; i <= DECK_SIZE + 1;i++) {
            deck.drawCard();
        }
    }
}
