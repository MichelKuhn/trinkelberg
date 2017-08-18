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

    private Card generateCard(int templateArray, int wordArray, int wordNsfwArray) {
        List<String> templates = Arrays.asList(context.getResources().getStringArray(templateArray));
        LinkedList<String> words = new LinkedList<>(Arrays.asList(context.getResources().getStringArray(wordArray)));
        if(options.contains(Option.NSFW)) {
            words.addAll(Arrays.asList(context.getResources().getStringArray(wordNsfwArray)));
        }
        String template = templates.get(new Random().nextInt(templates.size()));
        while(template.contains("[W1]")) {
            template = template.replace("[W1]", words.remove(new Random().nextInt(words.size())));
        }

        return new Card(template, 1, options);
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

        return new Card(returnString, 2, options);
    }

    ArrayList<Card> createDeck() {
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card("$$ muss die Mutter jedes Spielers beleidigen oder sein Glas leeren.", 3, new ArrayList<Option>()));
        for(int i = 0; i < 4; i++) {
            cards.add(this.generateCard(R.array.scremMeTemplates, R.array.screamMe, R.array.screamMeNsfw));
            cards.add(this.generateCard(R.array.groupsTemplates, R.array.groups, R.array.groupsNsfw));
            cards.add(this.generateCard(R.array.threeQuoteChallengeTemplates, R.array.threeQuoteChallenge, R.array.threeQuoteChallengeNSFW));
            cards.add(this.generateCard(R.array.didStuffTodayTemplates, R.array.didStuffToday, R.array.didStuffTodayNsfw));
            cards.add(this.generateCard(R.array.nameFourTemplates, R.array.nameFour, R.array.nameFourNsfw));
            cards.add(this.generateCard(R.array.noLikeTemplates, R.array.noLike, R.array.noLikeNsfw));
            cards.add(this.generateCard(R.array.getPhysicalTemplates, R.array.getPhysical, R.array.getPhysicalNsfw));
            cards.add(this.generateCard(R.array.ttTemplates, R.array.tt, R.array.ttNsfw));
            cards.add(this.generateCard(R.array.boringTemplates, R.array.boring, R.array.boringNsfw));
        }

        if(options.contains(Option.SOCIALMEDIA)) {
            for(int i = 0; i < 6; i++) {
                cards.add(generateSocialCard());
            }
        }

        return cards;
    }
}