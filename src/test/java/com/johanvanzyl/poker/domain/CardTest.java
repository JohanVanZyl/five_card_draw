package com.johanvanzyl.poker.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
    @Test
    public void cardToStringTest() {
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        assertEquals("AS", card.toString()); 
    }

}
