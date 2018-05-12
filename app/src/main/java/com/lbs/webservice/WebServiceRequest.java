package com.lbs.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lbs.error.LBSException;
import com.lbs.model.DBObject;
import com.lbs.model.Env;
import com.lbs.model.MListedProduct;
import com.lbs.model.MProduct;
import com.lbs.model.MUser;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by BenPa on 12/05/2018.
 */

public class WebServiceRequest {

    public static String AUTHENTICATE = "authenticate";
    public static String LISTED_PRODUCTS = "listedProduct?M_BPartner_ID=";
    public static final String GET_REQUEST = "GET";
    private WebServiceConnection wsc;
    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private String requestType;

    public List<MProduct> getListedProducts(){
        MUser currUser = null;
        if (Env.getProperty("LoggedInUser") != null){
            //currUser = (MUser)Env.getProperty("LoggedInUser");
        }
        else {
            throw new LBSException("There is no current logged in user in ENV");
        }
        ListedProductRequest lpr = new ListedProductRequest();
        lpr.execute(currUser);
        List<MProduct> products = lpr.getProducts();
        return products;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }




    private class ListedProductRequest extends AsyncTask<MUser, Void, List<MProduct>> {

        public List<MProduct> getProducts() {
            return products;
        }

        private List<MProduct> products;

        @Override
        protected List<MProduct> doInBackground(MUser... mUsers) {
            if (mUsers[0] == null){
                throw new LBSException("Passed User is null ");
            }
            int mBPartner_ID = mUsers[0].getM_BPartner_ID();
            WebServiceConnection wsc = new WebServiceConnection((LISTED_PRODUCTS += mBPartner_ID) ,GET_REQUEST );
            String jsonResp = wsc.makeRequest();
            if (jsonResp == null){
                throw new LBSException("JSON Response returned null for authentication request");
            }
            else {
                /** Convert the json String to a MUser object **/
                Type listedProductType = new TypeToken<List<MProduct>>(){}.getType();
                products = new Gson().fromJson(jsonResp, listedProductType);
            }
            return null;
        }
    }

}
