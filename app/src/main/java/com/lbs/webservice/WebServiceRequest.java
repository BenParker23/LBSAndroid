package com.lbs.webservice;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lbs.error.LBSException;
import com.lbs.model.Env;
import com.lbs.model.MProduct;
import com.lbs.model.MUser;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by BenPa on 12/05/2018.
 */

public class WebServiceRequest {

    public static String AUTHENTICATE = "authenticate";
    public static String LISTED_PRODUCTS = "listedProducts?M_BPartner_ID=";
    public static final String GET_REQUEST = "GET";
    private WebServiceConnection wsc;
    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private String requestType;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

}
