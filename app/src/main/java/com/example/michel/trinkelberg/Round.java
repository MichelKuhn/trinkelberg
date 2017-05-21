package com.example.michel.trinkelberg;

import java.util.ArrayList;
import java.util.Random;

public class Round {
    private ArrayList<Player> players;
    private ArrayList<Card> cards;

    public Round(ArrayList<Player> players, ArrayList<Card> cards) {
        this.players = players;
        this.cards = cards;
    }

    //Nicht immer, manchmal sucht der Zufall auch den Spieler aus
    private Player findMostSoberPlayer() {
        Player returnPlayer = players.get(new Random().nextInt(players.size()));
        if(new Random().nextInt(players.size()) != 1)  {
            int drunkCount = 0;
            for (Player player : players) {
                int playerDrunkCount = player.getSips() + player.getGlasses() * 4;

                if(playerDrunkCount > drunkCount) {
                    drunkCount = playerDrunkCount;
                    returnPlayer = player;
                }
            }
        }
        return returnPlayer;
    }

    private void end() {
        //TODO
    }

    public void drawCard() {
        if(cards.isEmpty()) {
            end();
        }
        int randomCardNumber = new Random().nextInt(cards.size());
        Card card = cards.get(randomCardNumber);
        card.playCard(findMostSoberPlayer());
        this.cards.remove(randomCardNumber);
    }
}
