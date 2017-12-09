package com.example.fitfourdesktop.group10_teacherspal;


import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import java.io.IOException;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */


public class VoiceChanger extends AppCompatActivity {

    MediaRecorder recorder;
    MediaPlayer player;
    boolean start = true;
    String LOG_TAG = "RecordTest";
    String fileName = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_changer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //microphone stuffs
        fileName += "../res/audiotest.3gp";

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            recorder.prepare();
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        //play back stuffs
        player = new MediaPlayer();
        try {
            player.setDataSource(fileName);
            player.prepare();

        }
        catch (IOException e){
            Log.e(LOG_TAG, "prepare() failed");
        }
    }


    public void onClickRecord(View view) {
        if(start && recorder == null) {
            start = false;
            recorder.start();
        }

        else {
            //recorder.stop();
            start = true;
        }
    }


    public void onClickPlay(View view) {
        if (start) {
            player.start();
            start = true;
        }
        else {
            player.stop();
            start = true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(recorder != null) {
            recorder.release();
            recorder = null;
        }
        if(player != null) {
            player.release();
            player = null;
        }
    }
}