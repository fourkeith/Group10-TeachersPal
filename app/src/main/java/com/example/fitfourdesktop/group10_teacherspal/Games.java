package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
    }

    public void onClickPuzzleGame(View view) {
        Intent puzzleScreen = new Intent(this, Puzzle.class);
        startActivity(puzzleScreen);
    }

    public void onClickMemoryGame(View view) {
        Intent MemoryScreen = new Intent(this, Memory.class);
        startActivity(MemoryScreen);
    }

    public void onClickVoiceChanger(View view) {
        Intent voiceScreen = new Intent(this, VoiceChanger.class);
        startActivity(voiceScreen);
    }
    public void onClickReturn() {

    }
}
