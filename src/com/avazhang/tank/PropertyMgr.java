package com.avazhang.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();

    static{
        try {
            //config under dir src == under classpath
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(props == null)
            return null;
        return props.get(key);
    }
}
