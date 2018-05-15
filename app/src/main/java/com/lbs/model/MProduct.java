package com.lbs.model;

/**
 * Created by BenPa on 12/05/2018.
 */

public class MProduct extends DBObject{

    private String name;
    private String imageURL;
    private int m_Product_ID;
    private boolean isActive;
    private String description;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getM_Product_ID() {
        return m_Product_ID;
    }
    public void setM_Product_ID(int m_Product_ID) {
        this.m_Product_ID = m_Product_ID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }



    @Override
    public int save() {
        return 0;
    }

    @Override
    public int fromJson(String json) {
        MProduct prod = gson.fromJson(json, MProduct.class);
        m_Product_ID = prod.getM_Product_ID();
        name = prod.getName();
        description = prod.getDescription();
        isActive  = prod.isActive();
        imageURL = prod.getImageURL();
        return 1;
    }
}
