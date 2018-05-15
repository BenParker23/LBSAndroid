package com.lbs.model;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by BenPa on 12/05/2018.
 */

public class MUser extends DBObject {

    private String username;
    private String name;
    private String email;
    private String password;
    private int m_BPartner_ID;
    private int m_user_id;


    public int getM_user_id() {
        return m_user_id;
    }

    public void setM_user_id(int m_user_id) {
        this.m_user_id = m_user_id;
    }

    public int getm_BPartner_ID() {
        return m_BPartner_ID;
    }

    public void setm_BPartner_ID(int m_BPartner_ID) {
        this.m_BPartner_ID = m_BPartner_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int save() {
        return 0;
    }


    @Override
    public int fromJson(String json) {
        MUser user = gson.fromJson(json, MUser.class);
        this.name = user.getName();
        this.m_user_id = user.getM_user_id();
        this.email = user.getEmail();
        this.m_BPartner_ID = user.getm_BPartner_ID();
        this.username = user.getUsername();
        this.password = user.getPassword();
        return 1;
    }
}
