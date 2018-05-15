package com.lbs.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lbs.R;
import com.lbs.model.Env;
import com.lbs.model.MUser;
import com.lbs.webservice.LoginAuthenticationRequest;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBut;
    private Button signupBut;
    private EditText username;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** Initialise variables **/
        loginBut = (Button)findViewById(R.id.loginBut);
        signupBut = (Button)findViewById(R.id.signupBut);
        username = (EditText) findViewById(R.id.username);
        loginBut.setOnClickListener(this);
        pass = (EditText)findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onClick(View view) {

        /** Handle all login button clicks **/
        if (view.getId() == loginBut.getId()){
            if (username.getText() != null && pass.getText() != null){
                MUser user = new MUser();
                user.setUsername(username.getText().toString());
                user.setPassword(pass.getText().toString());
                LoginAuthenticationRequest lar = new LoginAuthenticationRequest();
                lar.execute(user);

                /** Horrible disgusting hack **/
                while (lar.getStatus().equals(AsyncTask.Status.RUNNING) && lar.isComplete == false){}

                if (lar.getAuthenticatedUser() == null){
                    Toast.makeText(this.getApplicationContext(), "Authentication Failed. Please try again", Toast.LENGTH_LONG).show();
                }
                else {
                    Env.getInstance().addProperty("LoggedInUser", lar.getAuthenticatedUser());
                    Env.getInstance().addProperty("LoggedInUserActive", true);
                    Intent mainMenu = new Intent(this.getApplicationContext(), MainMenuActivity.class);
                    startActivity(mainMenu);
                }
            }
        }
    }
}
