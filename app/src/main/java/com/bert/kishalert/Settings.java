package com.bert.kishalert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    //Settings button method for click event takes user to the setup activity
    public void settingsOnClick(View v) {
        Button button=(Button) v;
        //((Button) v).setText("Clicked");
        startActivity(new Intent(Settings.this, Setup.class));
    }

    public void logOutOnClick(View v){
        finish();
        System.exit(0);
    }

}
