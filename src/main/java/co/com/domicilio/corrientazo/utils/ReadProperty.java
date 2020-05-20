package co.com.domicilio.corrientazo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

    public static String getProperty (String key) {
        Properties prop = null;
        try {
            InputStream input = ReadProperty.class.getClassLoader().getResourceAsStream("config.properties");
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(key);
    }
}