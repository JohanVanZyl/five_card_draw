package com.johanvanzyl.poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckOfCardsTest {
    
    public static final int DECK_SIZE = 52;

    @Test
    public void initialiseDeckTest() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(DECK_SIZE, deck.size()); 
    }
}
