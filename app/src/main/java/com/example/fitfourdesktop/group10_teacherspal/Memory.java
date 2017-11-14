package com.example.fitfourdesktop.group10_teacherspal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Memory extends AppCompatActivity {

    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void draw() {}

    public Integer getScore() {
        Log.i("Teachers_Pal", "getScore: " + score);
        return score;
    }

    public void setScore() {}
}
