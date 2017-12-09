package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class MainActivity extends AppCompatActivity {

    private static final String tag = "Teachers_Pal";
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Sends the app to the Game Menu screen
     * @param view
     */
    public void onClickGameMenu(View view){
       Intent gameScreen = new Intent(this, Games.class);
       startActivity(gameScreen);
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
        Log.i(tag, "onPause: set SharedPreferences");

        editor.apply();
    }
}
