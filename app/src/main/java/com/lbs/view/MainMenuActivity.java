package com.lbs.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lbs.R;
import com.lbs.model.Env;
import com.lbs.model.MProduct;
import com.lbs.model.MUser;
import com.lbs.webservice.ListedProductRequest;

import java.util.List;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{


    private Button manageProdsBut;
    private Button storeTrafficBut;
    private Button marketInfoBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        manageProdsBut = findViewById(R.id.manageProdsBut);
        manageProdsBut.setOnClickListener(this);
        storeTrafficBut = findViewById(R.id.storeTrafficBut);
        storeTrafficBut.setOnClickListener(this);
        marketInfoBut = findViewById(R.id.marketInfoBut);
        marketInfoBut.setOnClickListener(this);
    }
















    @Override
    public void onClick(View view) {
        if (view.getId() == marketInfoBut.getId()){
            Log.d("Working", "MarketingInfo");
        }
        else if (view.getId() == storeTrafficBut.getId()){

        }
        else if (view.getId() == manageProdsBut.getId()){
            Intent intent = new Intent(this.getApplicationContext(), ManageProductActivity.class);
            startActivity(intent);
        }
    }
}
