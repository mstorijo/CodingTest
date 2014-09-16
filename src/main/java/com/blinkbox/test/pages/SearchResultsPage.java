package com.blinkbox.test.pages;

import com.blinkbox.test.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }


    public String returnSearchTerm(){
        return driver.findElement(By.cssSelector("span[class=\"searched_term\"]")).getText();
    }


    public Boolean assertResultsDisplayed(){
        return driver.findElement(By.id("searchMatch")).isDisplayed();
    }
     public String getFirstTitle(){
        return driver.findElement(By.cssSelector("a[bo-text=\"book.title\"]")).getText().toLowerCase();
    }

    public String getFirstAuthor(){
        return driver.findElement(By.cssSelector("a[data-test=\"book-authors-0\"]")).getText().toLowerCase();
    }

    public String getFirstPrice(){
        return driver.findElement(By.cssSelector("span[data-test=\"book-price\"]")).getText();
    }

    public BookPage selectFirstBook(){
        driver.findElement(By.className("book")).click();
        WaitHelper.waitForPageLoad(driver);
        return new BookPage(driver);
    }

    public Boolean assertNoResultsDisplayed(){
        return driver.findElement(By.id("noResults")).isDisplayed();
    }


}
