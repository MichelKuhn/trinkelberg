package com.example.michel.trinkelberg;

import java.util.ArrayList;
import java.util.regex.Pattern;

class Card {
    private String text;
    private int sips;
    private boolean virus;
    private boolean cure;
    private ArrayList<Option> options;

    Card(String text, int sips, boolean virus, boolean cure, ArrayList<Option> options) {
        this.text = text;
        this.sips = sips;
        this.virus = virus;
        this.cure = cure;
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
        player.addSips(this.sips);
        if(this.virus) {
            player.infect();
        } else if (this.cure) {
            player.cure();
        }

        return this.text.replaceAll(Pattern.quote("$$"), player.getName());
    }
}
