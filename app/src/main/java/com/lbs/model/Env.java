package com.lbs.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by BenPa on 12/05/2018.
 */

public class Env {

    private Env () {}

    private static Env env;

    private static Map<String, Object> properties = new HashMap<>();

    public static Env getInstance() {
        if (env == null){
            env = new Env();
        }
        return env;
    }

    public static void addProperty(String name, Object value){
        properties.put(name, value);
    }

    public static Object getProperty(String name){
        return properties.get(name);
    }

    
}
