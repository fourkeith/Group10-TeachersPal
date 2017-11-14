package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
        TextView text = (TextView)findViewById(R.id.child);
        _child = text.getText().toString();

        text = (TextView)findViewById(R.id.Mother);
        _mother =text.getText().toString();

        text = (TextView)findViewById(R.id.Father);
        _father = text.getText().toString();

        text = (TextView)findViewById(R.id.Specialist);
        _specialist = text.getText().toString();

        text = (TextView)findViewById(R.id.Phone);
        _phone = text.getText().toString();
    }

    public void displayProfile() {
        SharedPreferences sP = this.getPreferences(Context.MODE_PRIVATE);

        setChild(sP.getString("", ""));
        setMother(sP.getString("", ""));
        setFather(sP.getString( "", ""));
        setSpecialist(sP.getString("", ""));
        setPhone(sP.getString("", ""));

        TextView text = (TextView)findViewById(R.id.child);
        text.setText(getChild());

        text = (TextView)findViewById(R.id.Mother);
        text.setText(getMother());

        text = (TextView)findViewById(R.id.Father);
        text.setText(getFather());

        text = (TextView)findViewById(R.id.Specialist);
        text.setText(getSpecialist());

        text = (TextView)findViewById(R.id.Phone);
        text.setText(getPhone());
    }

    public void saveProfile() {
        checkBoxes();

        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putString(getString(R.string.childName), _child);
        //editor.putString(getString(R.string.motherName), _mother);
        //editor.putString(getString(R.string.fatherName), _father);
        //editor.putString(getString(R.string.specName), _specialist);
        //editor.putString(getString(R.string.phoneNum), _phone);
        //editor.apply();
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
