package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GamesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_screen);
    }


    public void clickedPuz(View view) {
        Intent intent = new Intent(this, Puzzle.class);
        startActivity(intent);
    }
    public void clickedMem(View view) {
        Intent intent = new Intent(this, Memory.class);
        startActivity(intent);
    }
    public void clickedChange(View view) {
        Intent intent = new Intent(this, Changer.class);
        startActivity(intent);
    }

}
