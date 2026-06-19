package com.apps.quantitymeasurement.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ApplicationConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // System property overrides file property
        String sysProp = System.getProperty(key);
        if (sysProp != null) {
            return sysProp;
        }
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        String val = getProperty(key);
        return val != null ? val : defaultValue;
    }
}
