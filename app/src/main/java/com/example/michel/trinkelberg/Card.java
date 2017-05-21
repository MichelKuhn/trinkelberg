package com.example.michel.trinkelberg;

import java.util.ArrayList;

/**
 * Created by michel on 21.05.17.
 */

public class Card {
    private String text;
    private int sips;
    private boolean glass;
    private boolean virus;
    private ArrayList<String> attributes;

    public Card(String text, int sips, boolean glass, boolean virus, ArrayList<String> attributes) {
        this.text = text;
        this.sips = sips;
        this.glass = glass;
        this.virus = virus;
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
}
