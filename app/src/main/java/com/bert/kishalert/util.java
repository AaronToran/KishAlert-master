package com.bert.kishalert;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Aaron on 11/17/2015.
 */
public class util extends Activity  {
    public void test() {
        setContentView(R.layout.activity_login);
    }/*
}
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                System.out.println("Clicked the button");
                ViewGroup parent = (ViewGroup) view.getParent();
                int index = parent.indexOfChild(view);
                parent.removeView(view);
                view = getLayoutInflater().inflate(R.layout.activity_login,parent,false);
                setContentView(R.layout.activity_login);
                parent.addView(view,index);
            }
    public void start(View v){
        setContentView(R.layout.activity_login);
    }
    */
}
