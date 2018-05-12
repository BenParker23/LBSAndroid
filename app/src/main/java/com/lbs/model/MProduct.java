package com.lbs.model;

/**
 * Created by BenPa on 12/05/2018.
 */

public class MProduct extends DBObject{

    private String name;
    private String imageURL;
    private String M_Product_ID;
    private boolean isActive;
    private String description;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getM_Product_ID() {
        return M_Product_ID;
    }
    public void setM_Product_ID(String m_Product_ID) {
        M_Product_ID = m_Product_ID;
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
        return 0;
    }
}
