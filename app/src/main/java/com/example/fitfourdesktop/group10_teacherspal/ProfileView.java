package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
    }

    public void onClickProfileEdit(View View) {
        Intent profileScreen = new Intent(this, Profile.class);
        startActivity(profileScreen);
    }
}
