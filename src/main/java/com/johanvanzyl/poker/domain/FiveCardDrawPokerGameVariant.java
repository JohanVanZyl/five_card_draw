package com.johanvanzyl.poker.domain;

/**
 * Implementation of the Five card draw poker variant
 */
public class FiveCardDrawPokerGameVariant extends PokerGameVariant {

    public static final int HAND_SIZE = 5;

    public FiveCardDrawPokerGameVariant() {
        super(new DeckOfCards(), HAND_SIZE, PokerVariantName.FIVE_CARD_DRAW);
    }
    
}
