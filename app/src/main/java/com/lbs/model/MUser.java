package com.lbs.model;

import com.google.gson.Gson;

/**
 * Created by BenPa on 12/05/2018.
 */

public class MUser extends DBObject {

    private String username;
    private String name;
    private String email;
    private String password;
    private int M_User_ID;
    private int M_BPartner_ID;

    public int getM_User_ID() {
        return M_User_ID;
    }

    public void setM_User_ID(int m_User_ID) {
        M_User_ID = m_User_ID;
    }

    public int getM_BPartner_ID() {
        return M_BPartner_ID;
    }

    public void setM_BPartner_ID(int m_BPartner_ID) {
        M_BPartner_ID = m_BPartner_ID;
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
        Gson gson = new Gson();
        MUser user = gson.fromJson(json, MUser.class);
        this.name = user.getName();
        this.M_User_ID = user.getM_User_ID();
        return 1;
    }
}
