package com.example.michel.trinkelberg;


import java.util.ArrayList;

class DeckFactory {
    static ArrayList<Card> createDeck(ArrayList<Option> options) {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("$$ trinkt einen Schluck.", 1, false, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt zwei Schlücke.", 2, false, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt drei Schlücke.", 3, false, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt aus.", 0, true, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ muss die Mutter jedes Spielers beleidigen oder sein Glas leeren.", 0, true, false, false, new ArrayList<Option>()));
        ArrayList<Card> deck = new ArrayList<>();
        for (Card card : cards) {
            if(card.checkOptions(options)) {
                deck.add(card);
            }
        }

        return deck;
    }
}