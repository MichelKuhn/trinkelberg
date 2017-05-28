package com.example.michel.trinkelberg;

class Player {
    private String name;
    private int roundsFree;

    Player(String name) {
        this.name = name;
        this.roundsFree = 0;
    }

    String getName() {
        return name;
    }

    int getRoundsFree() {
        return roundsFree;
    }

    void setRoundsFree(int amount) {
        this.roundsFree = amount;
        if(this.roundsFree < 0) {
            this.roundsFree = 0;
        }
    }
}
