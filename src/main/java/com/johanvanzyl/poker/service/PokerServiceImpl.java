package com.johanvanzyl.poker.service;

import com.johanvanzyl.poker.domain.FiveCardDrawPokerGameVariant;
import com.johanvanzyl.poker.domain.Player;
import com.johanvanzyl.poker.domain.PokerGame;
import com.johanvanzyl.poker.domain.PokerVariantName;

public class PokerServiceImpl implements PokerService {

    private PokerGame pokerGame;

    /**
     * This method uses reflection to determine at runtime
     * which variant of poker to load.
     * It gets the class name field of the associated variant name that
     * was passed in.
     */
    @Override
    public void startGame(PokerVariantName name) {
        try {
            Class<?> pokerVariantClass = name.getVariantClass();
            // Instantiate the class
            Object pokerVariantInstance = pokerVariantClass.getDeclaredConstructor().newInstance();
            this.pokerGame = new PokerGame(pokerVariantInstance);

        } catch (ReflectiveOperationException e) {
            System.out.println(String.format("The requested poker game '%s' could not be started.", name));
            System.exit(-1);
        }
    }

    @Override
    public boolean shuffleDeck() {
        return pokerGame.shuffleDeck();
    }

    @Override
    public String joinGame(String playerName) {
        Player player = pokerGame.addPlayer(playerName);
        return String.format("%s joined the game", player.getName());
    }

    @Override
    public String dealCards() {
        String dealtCards = "";
        for (Player player: pokerGame.getPlayers()) {
            pokerGame.dealHand(player);
            dealtCards += String.format("%s's hand: %s\n", player.getName(), pokerGame.displayPlayerHand(player));
        }
        return dealtCards;
    }

    @Override
    public String evaluateHands() {
        String hands = "";
        for (Player player: pokerGame.getPlayers()) {
            hands += String.format("%s has a %s\n", player.getName(), pokerGame.evaluateHand(player));
        }
        return hands;
    }

    @Override
    public String endGame() {
        return "Goodbye"; 
    }
    
}
