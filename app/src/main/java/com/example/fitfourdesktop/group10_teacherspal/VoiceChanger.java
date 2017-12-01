package com.example.fitfourdesktop.group10_teacherspal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.IOException;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class VoiceChanger extends AppCompatActivity {

    audioRecord recorder;
    boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_changer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recorder = new audioRecord();
    }

    public void onClickRecord(View view) {
        recorder.onRecord(start);
        if (start)
            start = false;
        else
            start = true;
    }

    public void onClickPlay(View view) {
        recorder.onPlay(start);
        if (start)
            start = false;
        else
            start = true;
    }

    public void onClickReturn() {}

}
