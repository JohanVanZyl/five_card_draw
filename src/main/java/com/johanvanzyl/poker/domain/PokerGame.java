package com.johanvanzyl.poker.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the core (simplified) logic for  
 * playing a game of poker. 
 */
public class PokerGame {
    
    private List<Player> players = new ArrayList<>();
    private PokerGameVariant pokerGameVariant;

    public PokerGame(Object variantInstance) {
        this.pokerGameVariant = (PokerGameVariant) variantInstance;
    }

    public String getVariantName() {
        return pokerGameVariant.getVariantName();
    }

   public Player addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        return player;
   }

    public boolean shuffleDeck() {
        return pokerGameVariant.getDeck().shuffle();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void dealHand(Player player) {
        for (int i = 0; i < pokerGameVariant.getHandSize(); i++) {
            player.receiveCard(pokerGameVariant.getDeck().drawCard());
        }
    }

    public String displayPlayerHand(Player player) {
        String hand = "";
        for (Card card : player.showHand()) {
            hand += " " + card.toUnicodeString();
        }
        return hand;
    }

    public String evaluateHand(Player player) {
        List<String> hand = new ArrayList<>();
        for (Card card : player.showHand()) {
            hand.add(card.toString());
        }
        return PokerHandAnalyzer.evaluateHand(hand.toArray(new String[0])).toString();
    }
}

