package com.example.michel.trinkelberg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> players=new ArrayList<>();

    Button startButton;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                players);
        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(adapter);
        startButton = (Button)findViewById(R.id.start);
        startButton.setEnabled(false);
    }

    public void addItems(View v) {
        TextView tv = (TextView)findViewById(R.id.editText);
        players.add(tv.getText().toString());
        adapter.notifyDataSetChanged();
        tv.setText("");
        startButton.setEnabled(true);

    }

    public void onStart(View view) {
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(EXTRA_MESSAGE, players);
        startActivity(intent);
    }
}
