package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // Instance of Properties class to load test data into java memory and read it
    // Private AM to restrict instantiation outside this class
    // Static specifier to make it accessible from static method
    private static Properties properties = new Properties();

    // Static block to run the load() method for loading test data into Java memory
    // Loading data into the Java memory by using load() from Properties instance
    static {
        try {
            // Instance of FileInputStream to open the Configuration.properties file
            // Declaring variable as a static to be able to access from the static block
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("File not found in given path");
            e.printStackTrace();
        }
    }

    /*
     To be able to call by class name, creating static method which will take String parameter as key, read the value
     of key and return as a String
     */
    public static String getProperty(String key) {
        // Calling getProperty() method from Properties class to read value of the given key
        return properties.getProperty(key);
    }
}
