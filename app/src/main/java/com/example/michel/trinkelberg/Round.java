package com.example.michel.trinkelberg;

import java.util.ArrayList;

public class Round {
    private ArrayList<Player> players;
    private ArrayList<Card> cards;

    public Round(ArrayList<Player> players, ArrayList<Card> cards) {
        this.players = players;
        this.cards = cards;
    }

    private Player findMostSoberPlayer() {
        int drunkCount = 0;
        Player returnPlayer = players.get(2);
        for (Player player : players) {
            int playerDrunkCount = player.getSips() + player.getGlasses() * 4;

            if(playerDrunkCount > drunkCount) {
                drunkCount = playerDrunkCount;
                returnPlayer = player;
            }
        }
        return returnPlayer;
    }

    public void drawCard() {
        Card card = cards.get(1);
        card.playCard(findMostSoberPlayer());
    }
}
