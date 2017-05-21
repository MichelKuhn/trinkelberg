package com.example.michel.trinkelberg;

import java.util.ArrayList;

public class Card {
    private String text;
    private int sips;
    private boolean glass;
    private boolean virus;
    private boolean cure;
    private ArrayList<String> attributes;

    public Card(String text, int sips, boolean glass, boolean virus, boolean cure, ArrayList<String> attributes) {
        this.text = text;
        this.sips = sips;
        this.glass = glass;
        this.virus = virus;
        this.cure = cure;
        this.attributes = attributes;
    }

    public boolean checkAttributes(ArrayList<String> allowedAttributes) {
        for (String attribute : this.attributes) {
            if(!allowedAttributes.contains(attribute)) {
                return false;
            }
        }
        return true;
    }

    public String playCard(Player player) {
        player.addSips(this.sips);
        if(this.glass) { player.addGlass(); }
        if(this.virus) {
            player.infect();
        } else if (this.cure) {
            player.cure();
        }

        return this.text + player.getName();
    }
}
