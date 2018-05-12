package com.lbs.webservice;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.lbs.error.LBSException;
import com.lbs.model.MUser;

/**
 * Created by BenPa on 12/05/2018.
 */

public class LoginAuthenticationRequest extends AsyncTask<MUser, Void, MUser>{

        public MUser getAuthenticatedUser() {
            return authenticatedUser;
        }
        public boolean isComplete=false;
        private MUser authenticatedUser;


        protected MUser doInBackground(MUser... mUsers) {
            if (mUsers[0] == null){
                throw new LBSException("Passed user is null");
            }
            Log.e("USername", mUsers[0].getUsername());
            Log.e("Password", mUsers[0].getPassword());
            String authParams = (WebServiceRequest.AUTHENTICATE + "?username=" + mUsers[0].getUsername() + "&password=" + mUsers[0].getPassword());
            Log.e("REquestString",authParams);
            WebServiceConnection wsc = new WebServiceConnection(authParams,WebServiceRequest.GET_REQUEST );
            String jsonResp = wsc.makeRequest();
            if (jsonResp == null){
                isComplete = true;
                throw new LBSException("JSON Response returned null for authentication request");
            }
            else {

                Log.e("UserJSONResponse", jsonResp);
                /** Convert the json String to a MUser object **/
                authenticatedUser = new Gson().fromJson(jsonResp, MUser.class);
                isComplete = true;
            }
            return authenticatedUser;
        }
}
