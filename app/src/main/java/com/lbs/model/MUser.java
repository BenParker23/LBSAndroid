package com.lbs.model;

import com.google.gson.Gson;

/**
 * Created by BenPa on 12/05/2018.
 */

public class MUser extends DBObject {


    public String name;
    public int id;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public MUser(String name) {
        this.name = name;

    }

    public MUser(){

    }

    @Override
    public int save() {
        return 0;
    }

    @Override
    public int fromJson(String json) {
        Gson gson = new Gson();
        MUser user = gson.fromJson(json, MUser.class);
        this.name = user.getName();
        this.id = user.getId();
        return 1;
    }
}
