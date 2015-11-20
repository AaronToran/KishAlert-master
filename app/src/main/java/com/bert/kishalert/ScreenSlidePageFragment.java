package com.bert.kishalert;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ScreenSlidePageFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        View view  = inflater.inflate(R.layout.activity_main, container,false);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            
        }
        return view;
    }
}