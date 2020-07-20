package com.appline.testproject.tests;

import com.appline.testproject.framework.util.DriverManager;
import com.appline.testproject.framework.util.TestProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeAll
    public static void setUp() {
        //settings for all derived test cases
        baseUrl = properties.getProperty("app.url");
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterAll
    public static void tearDown() {
        //shut down the driver
        DriverManager.getDriver().quit();
    }
}
