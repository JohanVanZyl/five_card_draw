package com.johanvanzyl.poker.service;

import com.johanvanzyl.poker.domain.PokerVariantName;

/**
 * The PokerService interface contains
 * the basic poker services available
 * to a client.
 * 
 */
public interface PokerService {
    
    void startGame(PokerVariantName name);
    String joinGame(String playerName);
    boolean shuffleDeck();
    String dealCards();
    String evaluateHands();
    String endGame();
}