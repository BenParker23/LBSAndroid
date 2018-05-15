package com.lbs.model;

import com.google.gson.Gson;

/**
 * Created by BenPa on 12/05/2018.
 */

public abstract class DBObject implements I_Saveable {

    protected Gson gson = new Gson();
    public abstract int fromJson(String json);
}
