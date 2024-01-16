package com.johanvanzyl.poker.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.johanvanzyl.poker.domain.Card.Rank;
import com.johanvanzyl.poker.domain.Card.Suit;

public class PlayerTest {
    
    @Test
    public void emptyHandTest() {
        Player player = new Player("Ace");
        List<Card> emptyHand = new ArrayList<Card>();
        assertEquals(emptyHand, player.showHand());
    }

    @Test
    public void playerNameTest() {
        Player player = new Player("Player 1");
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void receiveCardTest() {
        Player player = new Player("Ace");
        player.receiveCard(new Card(Rank.ACE, Suit.SPADES));
        player.receiveCard(new Card(Rank.KING, Suit.HEARTS));
        int CARDS_IN_HAND = 2;
        assertTrue(CARDS_IN_HAND == player.showHand().size());
    }


    @Test
    public void showHandTest() {
        Player player = new Player("Arthur");
        Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES);
        Card kingOfHearts = new Card(Rank.KING, Suit.HEARTS);
        player.receiveCard(aceOfSpades);
        player.receiveCard(kingOfHearts);

        List<Card> cardsInHand = player.showHand();
        assertTrue(cardsInHand.get(0) == aceOfSpades);
        assertTrue(cardsInHand.get(1) == kingOfHearts);

    }
}
