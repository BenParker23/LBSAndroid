package com.lbs.model;

import java.util.Properties;

/**
 * Created by BenPa on 12/05/2018.
 */

public class Env {


    private static Properties props;

    public static void addProperty(String name, Object value){
        props.put(name, value);
    }

    public static Object getProperty(String name){
        return props.getProperty(name);
    }

    
}
