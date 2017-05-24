package com.example.michel.trinkelberg;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

class Round {
    private Context context;
    private ArrayList<Player> players;
    private ArrayList<Card> cards;

    Round(Context context, ArrayList<Player> players, ArrayList<Option> options) {
        this.players = players;
        DeckFactory df = new DeckFactory(context, options);
        this.cards = df.createDeck();
    }

    private Player findMostSoberPlayer() {
        Player returnPlayer = players.get(new Random().nextInt(players.size()));
        int drunkCount = 0;
        for (Player player : players) {
            int playerDrunkCount = player.getSips();

            if(playerDrunkCount <= drunkCount) {
                drunkCount = playerDrunkCount;
                returnPlayer = player;
            }
        }
        return returnPlayer;
    }

    String drawCard() {
        if(cards.isEmpty()) {
            return "Alle Karten verbraucht.";
        }
        int randomCardNumber = new Random().nextInt(cards.size());
        return this.cards.remove(randomCardNumber).playCard(findMostSoberPlayer());
    }
}
