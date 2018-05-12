package com.lbs.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
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

public class WebServiceConnection extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] objects) {
        getMapsJson();
        return null;
    }

    public String getMapsJson()
    {
        String output = "";
        HttpURLConnection connection = null;
        try
        {
            URL serverUrl = new URL("http://10.0.2.2:8080/login");
            connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(connection.getInputStream());
            output = readStream(in);
            Gson gson = new Gson();
            MUser user = new MUser();
            user.fromJson(output);
            Log.d("Name", user.name);
        }
        catch (Exception e)
        {
            Log.d("Minimap", e.toString());
        }
        finally
        {
            connection.disconnect();
        }
        Log.d("Minimap", "JSON: " + output);
        return output;
    }

    private String readStream(InputStream in)
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
