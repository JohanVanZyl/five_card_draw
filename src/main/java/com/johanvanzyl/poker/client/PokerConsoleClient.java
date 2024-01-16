package com.johanvanzyl.poker.client;

import com.johanvanzyl.poker.domain.PokerVariantName;
import com.johanvanzyl.poker.service.*;

/**
 * This class represents a console client user interface 
 * It calls our PokerService, which is independent of 
 * the user interface.
 */
public class PokerConsoleClient {

    private PokerService pokerService;

    public PokerConsoleClient(PokerService pokerService) {
        this.pokerService = pokerService; 
    }

    public void playGame() {
        pokerService.startGame(PokerVariantName.FIVE_CARD_DRAW);
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        pokerService.shuffleDeck();
        pokerService.joinGame("Player 1");
        pokerService.joinGame("Player 2");
        String handsDealt = pokerService.dealCards();
        System.out.println(handsDealt); 
        String evaluatedHands = pokerService.evaluateHands();
        System.out.println(evaluatedHands);
        pokerService.endGame();
    }

    public static void main(String args[]) {
        PokerService pokerService = new PokerServiceImpl();
        PokerConsoleClient console = new PokerConsoleClient(pokerService);
        console.playGame();
    }
   
}
