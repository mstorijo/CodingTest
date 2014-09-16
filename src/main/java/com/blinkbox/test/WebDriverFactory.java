package com.blinkbox.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class WebDriverFactory {

    public static WebDriver createWebDriver() throws Exception {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


}
