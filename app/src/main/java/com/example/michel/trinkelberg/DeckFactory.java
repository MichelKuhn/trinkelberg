package com.example.michel.trinkelberg;


import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

class DeckFactory {
    private Context context;
    private ArrayList<Option> options;

    DeckFactory(Context context, ArrayList<Option> options) {
        this.context = context;
        this.options = options;
    }

    private ArrayList<Card> getBasicCards() {
        ArrayList<Card> basicCards = new ArrayList<>();
        basicCards.add(new Card("$$ trinkt einen Schluck.", 1, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ trinkt zwei Schlücke.", 2, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ trinkt drei Schlücke.", 3, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ verteilt einen Schluck.", 0, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ verteilt zwei Schlücke.", 0, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ verteilt drei Schlücke.", 0, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("$$ trinkt aus.", 7, false, false, new ArrayList<Option>()));
        basicCards.add(new Card("Wer noch nichts getrunken hat, leert sein Glas.", 0, false, false, new ArrayList<Option>()));

        return basicCards;
    }

    private Card generateScreamCard() {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.screamMe)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.screamMeNsfw)));
        }
        String template = "$$ trinkt einen Schluck und schreit danach \"[W1]\"";
        String returnString = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 1, false, false, options);
    }

    private Card generateGroupCard() {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.groups)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.groupsNsfw)));
        }
        String template = "Alle [W1] genehmigen sich einen Schluck.";
        String returnString = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 1, false, false, options);
    }

    private Card generateThreeQuoteCard() {
        List<String> words = Arrays.asList(context.getResources().getStringArray(R.array.threeQuoteChallenge));
        String template = "$$ muss mehrere Zeilen aus einem [W1] oder drei Schlücke trinken.";
        String returnString = template.replace("[W1]", words.get(new Random().nextInt(words.size())));

        return new Card(returnString, 3, false, false, options);
    }

    private Card generateSplitFourCard() {
        List<String> words = Arrays.asList(context.getResources().getStringArray(R.array.splitFour));
        String template = "$$ verteilt vier Schlücke auf alle [W1] in der Runde.";
        String returnString = template.replace("[W1]", words.get(new Random().nextInt(words.size())));

        return new Card(returnString, 0, false, false, options);
    }

    private Card generateStuffTodayCard() {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.didStuffToday)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.didStuffTodayNsfw)));
        }
        String template = "Wer heute abend [W1] hat, trinkt einen Schluck.";
        String returnString = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 0, false, false, options);
    }

    private Card generateNameFourCard() {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.nameFour)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.nameFourNsfw)));
        }
        String template = "$$ verteilt zwei Schlücke, wenn er vier [W1] nennen kann.";
        String returnString = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 0, false, false, options);
    }

    private Card generateNoLikeCard() {
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.noLike)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.noLikeNsfw)));
        }
        String template = "Alle Spieler, die [W1] mögen, trinken einen Schluck.";
        String returnString = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 0, false, false, options);
    }

    private Card generateSocialCard() {
        List<String> templates = Arrays.asList(context.getResources().getStringArray(R.array.socialMediaTemplates));
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(R.array.socialMedia)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(R.array.socialMediaNsfw)));
        }
        String template = templates.get(new Random().nextInt(templates.size()));

        String temp1 = template.replaceAll(Pattern.quote("[W1]"), words.remove(new Random().nextInt(words.size())));
        String temp2 = temp1.replaceAll(Pattern.quote("[W2]"), words.remove(new Random().nextInt(words.size())));
        String returnString = temp2.replaceAll(Pattern.quote("[W3]"), words.remove(new Random().nextInt(words.size())));

        return new Card(returnString, 2, false, false, options);
    }

    ArrayList<Card> createDeck() {
        ArrayList<Option> nsfw = new ArrayList<>();
        nsfw.add(Option.NSFW);
        ArrayList<Option> hetero = new ArrayList<>();
        hetero.add(Option.HETERO);

        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card("$$ muss die Mutter jedes Spielers beleidigen oder sein Glas leeren.", 3, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ trinkt einen Schluck pro Brillenträger in der Runde.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ muss jedem Spieler ein Kompliment machen oder drei Schlücke trinken.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("Alle Spieler nennen nacheinander Herr der Ringe Charaktere. Wer keinen nennen kann trinkt sein Glas aus. $$ beginnt.", 1, false, false, new ArrayList<Option>()));
        cards.add(new Card("Alle Spieler nennen nacheinander Harry Potter Charaktere. Wer keinen nennen kann trinkt sein Glas aus. $$ beginnt.", 1, false, false, new ArrayList<Option>()));
        cards.add(new Card("Alle Spieler nennen nacheinander Star Wars Charaktere. Wer keinen nennen kann trinkt sein Glas aus. $$ beginnt.", 1, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ sagt fehlerfrei \"Acht alte Ameisen aßen am Abend Ananas.\" oder trinkt zwei Schlücke.", 4, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ sagt fehlerfrei \"Brauchbare Bierbrauerburschen brauen brausendes Braunbier. \" oder trinkt zwei Schlücke.", 4, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ sagt fehlerfrei \"Gibst Du Opi Opium, bringt Opium Opi um.\" oder leert sein Glas.", 2, false, false, new ArrayList<Option>()));
        cards.add(new Card("$$ verteilt zwei Schlücke, wenn er fünfzehn Sekunden auf einem Bein stehen kann.", 0, false, false, new ArrayList<Option>()));
        cards.add(new Card("Wer dieses Jahr Geburtstag hatte, trinkt die Nummer des Monats als Schlücke.", 0, false, false, new ArrayList<Option>()));

        cards.add(new Card("Das Penisspiel: Jeder muss lauter \"Penis\" lauter rufen als sein Vorgänger. $$ beginnt.", 1, false, false, nsfw));
        cards.add(new Card("Alle Spieler nennen nacheinander Pornokategorien. Wer keine nennen kann trinkt sein Glas aus. $$ beginnt.", 2, false, false, nsfw));
        cards.add(new Card("$$ sagt dreimal \"Ich bin ein Hurensohn.\" oder trinkt einen Schluck.", 1, false, false, nsfw));
        cards.add(new Card("$$ sagt dreimal \"Ich mag Schwänze.\" oder trinkt einen Schluck.", 1, false, false, nsfw));
        cards.add(new Card("$$ sagt dreimal \"Ich bin ein Eichelschmuser.\" oder trinkt einen Schluck.", 1, false, false, nsfw));

        cards.add(new Card("$$ verteilt drei Schlücke auf alle Personen des anderen Geschlechts in der Runde.", 0, false, false, hetero));
        cards.add(new Card("$$ macht jeder Person des anderen Geschlechts ein Kompliment oder leert sein Glas.", 1, false, false, hetero));

        ArrayList<Card> deck = new ArrayList<>();
        for (Card card : cards) {
            if(card.checkOptions(options)) {
                deck.add(card);
            }
        }

        deck.addAll(getBasicCards());
        for(int i = 0; i < 6; i++) {
            deck.add(generateScreamCard());
            deck.add(generateGroupCard());
        }
        for(int i = 0; i < 3; i++) {
            deck.add(generateThreeQuoteCard());
            deck.add(generateStuffTodayCard());
            deck.add(generateNameFourCard());
            deck.add(generateSplitFourCard());
            deck.add(generateNoLikeCard());
        }
        if(options.contains(Option.SOCIALMEDIA)) {
            for(int i = 0; i < 6; i++) {
                deck.add(generateSocialCard());
            }
        }

        return deck;
    }
}