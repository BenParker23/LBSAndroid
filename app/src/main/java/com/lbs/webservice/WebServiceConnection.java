package com.lbs.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.lbs.model.DBObject;
import com.lbs.model.MUser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by BenPa on 12/05/2018.
 */

public class WebServiceConnection {

    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private static String requestType;
    private static String urlToSend = BASE_URL;


    /** The public interface method
     *  Returns a JSON String of the object **/
    public static String makeRequest()
    {
        if (requestType == null){
            Log.e("WebServiceConnection", "RequestType is not set");
            return null;
        }
        String output = "";
        HttpURLConnection connection = null;
        try
        {
            URL serverUrl = new URL(urlToSend);
            connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(connection.getInputStream());
            output = readStream(in);
        }
        catch (Exception e) {
            Log.d("Minimap", e.toString());
        }
        finally {
            connection.disconnect();
        }
        urlToSend = BASE_URL;
        requestType = null;
        return output;
    }


    public WebServiceConnection(String urlParams, String requestType){
        this.requestType = requestType;
        if (urlParams == null){
            Log.e("WebServiceConnection", "Please specify a parameter for the request");
            return;
        }
        else {
            urlToSend += urlParams;
        }
    }

    private static String readStream(InputStream in)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            String output = line;

            while((line = reader.readLine()) != null)
                output += line;
            return output;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "";
        }
    }

}
