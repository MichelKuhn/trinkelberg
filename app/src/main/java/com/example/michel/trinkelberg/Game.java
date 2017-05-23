package com.example.michel.trinkelberg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    private ArrayList<Player> players;
    private ArrayList<Option> options;
    private Round round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        players = new ArrayList<>();
        options = new ArrayList<>();

        ArrayList<String> playerNames = extras.getStringArrayList("PLAYERS");
        for (String playerName: playerNames) {
            players.add(new Player(playerName));
        }

        ArrayList<String> optionStrings = extras.getStringArrayList("OPTIONS");
        for (String option: optionStrings) {
            switch (option) {
                case "SOCIALMEDIA": options.add(Option.SOCIALMEDIA); break;
                case "NSFW": options.add(Option.NSFW); break;
                case "HETERO": options.add(Option.HETERO); break;
            }
        }

        round = new Round(players, options);
        TextView textView = (TextView)findViewById(R.id.cardView);
        textView.setTextSize(32);
        textView.setText(round.drawCard());
    }

    public void onNext(View view) {
        TextView textView = (TextView)findViewById(R.id.cardView);
        textView.setTextSize(32);
        textView.setText(round.drawCard());
    }
}
