package com.example.michel.trinkelberg;


import java.util.ArrayList;

public class DeckFactory {
    public static ArrayList<Card> createDeck(ArrayList<Card> cards, ArrayList<Option> options) {
        ArrayList<Card> deck = new ArrayList<>();
        for (Card card : cards) {
            if(card.checkOptions(options)) {
                deck.add(card);
            }
        }

        return deck;
    }
}
