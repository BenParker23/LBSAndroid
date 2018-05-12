package com.lbs.model;

import java.util.Properties;

/**
 * Created by BenPa on 12/05/2018.
 */

public class Env {

    private Env () {}

    private static Env env;

    public static Env getInstance() {
        if (env == null){
            env = new Env();
        }
        if (props == null){
            props = new Properties();
        }
        return env;
    }

    private static Properties props;

    public static void addProperty(String name, String value){
        props.setProperty(name, value);
    }

    public static String getProperty(String name){
        return props.getProperty(name);
    }

    
}
