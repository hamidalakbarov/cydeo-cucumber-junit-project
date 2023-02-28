package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Driver {

    // Implementing Singleton Design Pattern
    // Implementing Encapsulation and Polymorphism principles of OOP
    // To restrict this class from being instantiated outside this class
    private Driver() {
    }

    //private static WebDriver driver; //this is for the only one driver instance

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>(); // for getting multiple drivers

    public static WebDriver getDriver() {

        /*
        If the driver has default value, new driver instance will be created and returned. If the driver instance is
        existing the existing one will be returned.
         */

        if (driverPool.get() == null) {

            // To read the value of the key browser from the configuration.properties file
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    /*
                    We are not using WebDriverManager to set up driver manager because in newer version of Selenium it
                    was taken care of by Selenium developers. That step is implemented already in Selenium library
                     */
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    driverPool.set(new SafariDriver());
            }
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverPool.get().manage().window().maximize();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        /*
        If we have default value for driver ref variable and trying to call quit() method from the object which is not
        exist we will get NullPointerException. To avoid this from happening, we will first check if the driver has
        default value.
         */
        if (driverPool.get()!=null) {
            // To close all the browser windows opened in current driver session
            driverPool.get().quit();
            // Assigning default value to the driver ref variable (according to Singleton Design Pattern)
            driverPool.remove();
        }
    }
}
