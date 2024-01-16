package com.johanvanzyl.poker.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PokerGameVariantTest {
    
    @Test
    public void FiveCardDrawPokerGameVariantTest() {
        PokerGameVariant variant = new FiveCardDrawPokerGameVariant();
        assertTrue(FiveCardDrawPokerGameVariant.HAND_SIZE == variant.getHandSize());
    }
}
