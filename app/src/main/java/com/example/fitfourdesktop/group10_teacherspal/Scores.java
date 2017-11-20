package com.example.fitfourdesktop.group10_teacherspal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void displayScores() {}

    public void onClickReturn() {
        Log.i("Teachers_Pal", "onClickReturn: Returned to Game Menu");
    }
}
