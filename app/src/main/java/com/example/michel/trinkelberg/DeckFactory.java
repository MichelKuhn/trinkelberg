package com.example.michel.trinkelberg;


import java.util.ArrayList;

class DeckFactory {
    private ArrayList<Option> options;

    DeckFactory(ArrayList<Option> options) {
        this.options = options;
    }

    ArrayList<Card> createDeck() {
        ArrayList<Option> nsfw = new ArrayList<>();
        nsfw.add(Option.NSFW);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("$$ trinkt einen Schluck.", 1, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt zwei Schlücke.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt drei Schlücke.", 3, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt aus.", 5, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ muss die Mutter jedes Spielers beleidigen oder sein Glas leeren.", 3, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt einen Schluck pro Brillenträger in der Runde.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ muss jedem Spieler ein Kompliment machen oder drei Schlücke trinken.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("Wer noch nichts getrunken hat, trinkt sein GLas leer.", 0, false, false, new ArrayList<Option>()));

        cards.add(new Card("Das Penisspiel: Jeder muss lauter \"Penis\" lauter rufen als sein Vorgänger. $$ beginnt.", 1, false, false, nsfw));
        ArrayList<Card> deck = new ArrayList<>();
        for (Card card : cards) {
            if(card.checkOptions(options)) {
                deck.add(card);
            }
        }

        return deck;
    }
}