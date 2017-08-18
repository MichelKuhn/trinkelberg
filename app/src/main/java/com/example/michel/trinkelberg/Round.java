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

    private Player choosePlayer() {
        ArrayList<Player> playersToChooseFrom = new ArrayList<>();
        for (Player player : this.players) {
            if(player.getRoundsFree() == 0) {
                playersToChooseFrom.add(player);
            }
        }

        if(playersToChooseFrom.isEmpty()) {
            playersToChooseFrom = this.players;
        }

        return playersToChooseFrom.get(new Random().nextInt(playersToChooseFrom.size()));
    }

    String drawCard() {
        if(cards.isEmpty()) {
            return "Alle Karten verbraucht.";
        }
        int randomCardNumber = new Random().nextInt(cards.size());
        return this.cards.remove(randomCardNumber).playCard(choosePlayer());
    }
}
