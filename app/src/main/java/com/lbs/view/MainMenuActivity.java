package com.lbs.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lbs.R;
import com.lbs.model.Env;
import com.lbs.model.MUser;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Object obj = Env.getInstance().getProperty("LoggedInUser");
        //if (obj)
      //  Log.d("ReturnTYpe", Env.getInstance().getProperty("LoggedInUser"));
        //MUser user = (MUser) Env.getInstance().getProperty("LoggedInUser");
        //Log.d("User", user.getName());
    }
}
