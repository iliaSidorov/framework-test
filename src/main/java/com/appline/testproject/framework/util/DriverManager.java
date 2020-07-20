
package com.appline.testproject.framework.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class DriverManager {

    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    //Singleton
    private DriverManager() {
    }

    private static void initDriver() {
        if (driver == null) {
            switch (properties.getProperty("browser")) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            }
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }


}

