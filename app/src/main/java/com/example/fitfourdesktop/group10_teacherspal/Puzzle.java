package com.example.fitfourdesktop.group10_teacherspal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class Puzzle extends AppCompatActivity {

    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public Integer getScore() {
        Log.i("Teachers_Pal", "getScore: " + score);
        return score;
    }

    public void setScore() {}
}
