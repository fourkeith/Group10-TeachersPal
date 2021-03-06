package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class Profile extends AppCompatActivity {

    String _child;
    String _father;
    String _mother;
    String _specialist;
    String _phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        displayProfile();
    }

    public void checkBoxes() {
        TextView text = findViewById(R.id.Child);
        _child = text.getText().toString();

        text = findViewById(R.id.Mother);
        _mother =text.getText().toString();

        text = findViewById(R.id.Father);
        _father = text.getText().toString();

        text = findViewById(R.id.Specialist);
        _specialist = text.getText().toString();

        text = findViewById(R.id.Phone);
        _phone = text.getText().toString();
    }

    public void displayProfile() {
        SharedPreferences sP = this.getPreferences(Context.MODE_PRIVATE);

        setChild(sP.getString("childName", ""));
        setMother(sP.getString("motherName", ""));
        setFather(sP.getString( "fatherName", ""));
        setSpecialist(sP.getString("specName", ""));
        setPhone(sP.getString("phoneNum", ""));

        TextView text = findViewById(R.id.Child);
        text.setText(getChild());

        text = findViewById(R.id.Mother);
        text.setText(getMother());

        text = findViewById(R.id.Father);
        text.setText(getFather());

        text = findViewById(R.id.Specialist);
        text.setText(getSpecialist());

        text = findViewById(R.id.Phone);
        text.setText(getPhone());
    }

    public void saveProfile() {
        checkBoxes();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("childName", _child);
        editor.putString("motherName", _mother);
        editor.putString("fatherName", _father);
        editor.putString("specName", _specialist);
        editor.putString("phoneNum", _phone);
        editor.apply();
    }

    public void onClickSaveProfile(View view) {
        saveProfile();
        displayProfile();
    }

    //getters
    public String getChild()            { return _child;      }
    public String getFather()           { return _father;     }
    public String getMother()           { return _mother;     }
    public String getSpecialist()       { return _specialist; }
    public String getPhone()            { return _phone;      }

    //setters
    public void setChild(String name)       { _child = name;      }
    public void setMother(String name)      { _mother = name;     }
    public void setSpecialist(String name)  { _specialist = name;}
    public void setPhone(String phone)      { _phone = phone;     }
    public void setFather(String name)      { _father = name;     }

    @Override
    protected void onDestroy() {
        saveProfile();
        super.onDestroy();
    }
}
