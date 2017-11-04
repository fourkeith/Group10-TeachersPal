package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


// time to make a project
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void clicked1(View view) {
        Intent intent = new Intent(this, GamesScreen.class);
        startActivity(intent);
    }
    public void clicked2(View view) {
        Intent intent = new Intent(this, ProgressScreen.class);
        startActivity(intent);
    }
    public void clicked3(View view) {
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }

}