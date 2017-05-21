package com.example.michel.trinkelberg;

/**
 * Created by michel on 21.05.17.
 */

public class Player {
    private String name;
    private int sips;
    private int glasses;
    private boolean virus;

    public Player(String name) {
        this.name = name;
        this.sips = 0;
        this.glasses = 0;
        this.virus = false;
    }

    public String getName() {
        return name;
    }

    public int getSips() {
        return sips;
    }

    public int getGlasses() {
        return glasses;
    }

    public boolean isVirus() {
        return virus;
    }

    public void addSips(int amount) {
        this.sips += amount;
    }

    public void addGlass() {
        this.glasses++;
    }

    public void infect() {
        this.virus = true;
    }

    public void cure() {
        this.virus = false;
    }
}
