package com.johanvanzyl.poker.domain;

public abstract class PokerGameVariant {

   private PokerVariantName variantName;
   private DeckOfCards deck;
   private int handSize;
   
   public PokerGameVariant(DeckOfCards deck, int handSize,  PokerVariantName variantName) {
      this.deck = deck;
      this.handSize = handSize;
      this.variantName = variantName;
   } 

   public DeckOfCards getDeck() {
      return this.deck;
   }

   public int getHandSize() {
      return this.handSize;
   }

   public String getVariantName() {
      return variantName.name();
   }
}
