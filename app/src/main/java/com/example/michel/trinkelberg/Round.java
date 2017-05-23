package com.example.michel.trinkelberg;

import java.util.ArrayList;
import java.util.Random;

class Round {
    private ArrayList<Player> players;
    private ArrayList<Card> cards;

    Round(ArrayList<Player> players, ArrayList<Option> options) {
        this.players = players;
        DeckFactory df = new DeckFactory(options);
        this.cards = df.createDeck();
    }

    //Nicht immer, manchmal sucht der Zufall auch den Spieler aus
    private Player findMostSoberPlayer() {
        Player returnPlayer = players.get(new Random().nextInt(players.size()));
        if(new Random().nextInt(players.size() + 3) != 1)  {
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

    String drawCard() {
        if(cards.isEmpty()) {
            return "Alle Karten verbraucht";
        }
        int randomCardNumber = new Random().nextInt(cards.size());
        Card card = cards.get(randomCardNumber);
        this.cards.remove(randomCardNumber);
        return card.playCard(findMostSoberPlayer());
    }
}
