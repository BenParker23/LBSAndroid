package com.lbs.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lbs.error.LBSException;
import com.lbs.model.MProduct;
import com.lbs.model.MUser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 12/05/18.
 */

public class ListedProductRequest extends AsyncTask<MUser, Void, List<MProduct>> {

    public List<MProduct> getProducts() {
        return products;
    }
    private List<MProduct> products;
    public boolean isComplete=false;

    @Override
    protected List<MProduct> doInBackground(MUser... mUsers) {
        if (mUsers[0] == null){
            throw new LBSException("Passed User is null ");
        }
        int mBPartner_ID = mUsers[0].getm_BPartner_ID();
        String str = WebServiceRequest.LISTED_PRODUCTS + mBPartner_ID;
        WebServiceConnection wsc = new WebServiceConnection((WebServiceRequest.LISTED_PRODUCTS + mBPartner_ID) ,WebServiceRequest.GET_REQUEST );
        String jsonResp = wsc.makeRequest();
        if (jsonResp == null){
            isComplete = false;
            throw new LBSException("JSON Response returned null for authentication request");
        }
        else {
            Type listedProductType = new TypeToken<ArrayList<MProduct>>(){}.getType();
            products = new Gson().fromJson(jsonResp, listedProductType);
            isComplete = true;
        }
        return products;
    }
}
