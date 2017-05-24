package com.example.michel.trinkelberg;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void karte() {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Option> options = new ArrayList<>();
        players.add(new Player("Michel"));
        Round round = new Round(players, options);
        assertEquals("test", round.drawCard());
    }
}