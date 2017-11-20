package com.example.fitfourdesktop.group10_teacherspal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class VoiceChanger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_changer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onClickReturn() {}
}
