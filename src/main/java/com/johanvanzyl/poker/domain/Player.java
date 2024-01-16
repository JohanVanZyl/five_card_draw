package com.johanvanzyl.poker.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a 
 * Player in the game.
 */
public class Player {

    private List<Card> hand;
    private String name;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> showHand() {
        return hand;
    }
   
    public void receiveCard(Card card) {
        hand.add(card);
    }
}
