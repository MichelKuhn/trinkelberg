package com.example.michel.trinkelberg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;
import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Menu extends AppCompatActivity {
    private ArrayList<String> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        players = intent.getStringArrayListExtra(EXTRA_MESSAGE);
    }

    public void onStart(View view) {
        ArrayList<String> options = new ArrayList<>();

        ToggleButton social = (ToggleButton) findViewById(R.id.socialButton);
        ToggleButton nsfw = (ToggleButton) findViewById(R.id.nsfwButton);
        ToggleButton hetero = (ToggleButton) findViewById(R.id.heteroButton);

        if(social.isActivated()) {options.add("SOCIALMEDIA");}
        if(nsfw.isActivated()) {options.add("NSFW");}
        if(hetero.isActivated()) {options.add("HETERO");}

        Intent intent = new Intent(this, Game.class);
        Bundle extras = new Bundle();
        extras.putStringArrayList("PLAYERS", players);
        extras.putStringArrayList("OPTIONS", options);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
