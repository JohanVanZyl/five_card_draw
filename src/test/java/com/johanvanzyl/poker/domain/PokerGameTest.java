package com.johanvanzyl.poker.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PokerGameTest {

   @Test
   public void returnRequestedGameVariantTest() {
        PokerGame game = new PokerGame(new FiveCardDrawPokerGameVariant());
        assertTrue(PokerVariantName.FIVE_CARD_DRAW.toString() == game.getVariantName());
   }

  @Test
  public void addPlayerToGameTest() {
       PokerGame game = new PokerGame(new FiveCardDrawPokerGameVariant());

       String playerName = "Player_1";
       Player player_1 = game.addPlayer(playerName);

       assertTrue(playerName == player_1.getName());
  }

  @Test
  public void getGamePlayersTest() {
       PokerGame game = new PokerGame(new FiveCardDrawPokerGameVariant());

       List<Player> expectedPlayers = new ArrayList<>();
       Player player_1 = game.addPlayer("Player_1");
       Player player_2 = game.addPlayer("Player_2");
       Player player_3 = game.addPlayer("Player_3");
       expectedPlayers.add(player_1);
       expectedPlayers.add(player_2);
       expectedPlayers.add(player_3);

       assertEquals(expectedPlayers, game.getPlayers());
  }

}
