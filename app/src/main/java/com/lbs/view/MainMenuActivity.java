package com.lbs.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lbs.R;
import com.lbs.webservice.WebServiceConnection;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_menu);
        WebServiceConnection wsc = new WebServiceConnection();
        wsc.execute();
    }
}
