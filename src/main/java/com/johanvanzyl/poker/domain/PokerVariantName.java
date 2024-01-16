package com.johanvanzyl.poker.domain;

public enum PokerVariantName {
    FIVE_CARD_DRAW("com.johanvanzyl.poker.domain.FiveCardDrawPokerGameVariant"), BADUGI("Badugi"), TEXAS_HOLDEM("TexasHoldem");

    private final String variantClassName;

    PokerVariantName(String className) {
        this.variantClassName = className;
    }

    public Class<?> getVariantClass() throws ClassNotFoundException {
        return Class.forName(variantClassName);
    }
}
