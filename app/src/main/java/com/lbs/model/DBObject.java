package com.lbs.model;

/**
 * Created by BenPa on 12/05/2018.
 */

public abstract class DBObject implements I_Saveable {

    public abstract int fromJson(String json);
}
