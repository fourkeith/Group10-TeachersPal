package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

// time to make a project
public class MainActivity extends AppCompatActivity {

    int puzAScore;
    int puzRScore;
    int memAScore;
    int memRScore;
    int changerUsed;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGameMenu(View view){
       Intent gameScreen = new Intent(this, Games.class);
       startActivity(gameScreen);
    }

    public void onClickScoreList(View view) {
        Intent scoreScreen = new Intent(this, Scores.class);
        startActivity(scoreScreen);
    }

    public void onClickProfile(View View) {
        Intent profileScreen = new Intent(this, Profile.class);
        startActivity(profileScreen);
    }

    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences settings = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Name", PREFS_NAME);

        editor.apply();
    }
}
