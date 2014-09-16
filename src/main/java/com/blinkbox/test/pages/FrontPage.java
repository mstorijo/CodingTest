package com.blinkbox.test.pages;

import com.blinkbox.test.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class FrontPage {
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage searchForTerm(String searchString){
        driver.findElement(By.cssSelector("[data-test=\"search-input\"]")).sendKeys(searchString);
        driver.findElement(By.cssSelector("[data-test=\"search-button\"]")).click();
        WaitHelper.waitForPageLoad(driver);
        return new SearchResultsPage(driver);
    }
}
