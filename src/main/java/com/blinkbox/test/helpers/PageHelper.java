package com.blinkbox.test.helpers;

import com.blinkbox.test.pages.BookPage;
import com.blinkbox.test.pages.FrontPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class PageHelper {
    private WebDriver driver;
    protected final String BASE_URL = "http://www.blinkboxbooks.com";
    protected final String TEST_BOOK_PAGE = "https://www.blinkboxbooks.com/#!/book/9780141345642/the-fault-in-our-stars";

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public FrontPage goToFrontPage(){
        driver.get(BASE_URL);
        WaitHelper.waitForPageLoad(driver);
        return new FrontPage(driver);
    }

    public void endTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    public BookPage goToSpecificBook() {
        driver.get(TEST_BOOK_PAGE);
        WaitHelper.waitForPageLoad(driver);
        return new BookPage(driver);
    }
}
