package com.bert.kishalert.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bert.kishalert.R;
import com.bert.kishalert.login;

public class Tab4Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.tab4fragment, container, false);
        //setting up the button and adding the onclick event using the v fragment object
        Button button = (Button)v.findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("IT got Clicked");
                Intent myIntent = new Intent(getActivity(), login.class);
                startActivity(myIntent);

            }
        });
		return v;
	}
}
