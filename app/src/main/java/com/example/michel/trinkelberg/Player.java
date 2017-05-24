package com.example.michel.trinkelberg;

class Player {
    private String name;
    private int sips;
    private boolean virus;

    Player(String name) {
        this.name = name;
        this.sips = 0;
        this.virus = false;
    }

    String getName() {
        return name;
    }

    int getSips() {
        return sips;
    }

    public boolean isVirus() {
        return virus;
    }

    void addSips(int amount) {
        this.sips += amount;
    }

    void infect() {
        this.virus = true;
    }

    void cure() {
        this.virus = false;
    }
}
