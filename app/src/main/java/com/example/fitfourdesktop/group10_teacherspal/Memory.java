package com.example.fitfourdesktop.group10_teacherspal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Memory extends AppCompatActivity {

    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void draw() {}

    public void getScore() {}

    public void setScore() {}
}
