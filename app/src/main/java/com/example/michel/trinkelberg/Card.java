package com.example.michel.trinkelberg;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Card {
    private String text;
    private int roundsFree;
    private ArrayList<Option> options;

    Card(String text, int roundsFree, ArrayList<Option> options) {
        this.text = text;
        this.roundsFree = roundsFree;
        this.options = options;
    }

    boolean checkOptions(ArrayList<Option> allowedOptions) {
        for (Option option : this.options) {
            if(!allowedOptions.contains(option)) {
                return false;
            }
        }
        return true;
    }

    String playCard(Player player) {
        player.setRoundsFree(player.getRoundsFree() + roundsFree);

        return this.text.replaceAll(Pattern.quote("$$"), player.getName());
    }
}
