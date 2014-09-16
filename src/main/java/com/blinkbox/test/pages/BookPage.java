package com.blinkbox.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class BookPage {

    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getBookTitle(){
        return driver.findElement(By.cssSelector("span[bo-text=\"book.title\"]")).getText().toLowerCase();
    }


    public String getAuthor(){
        return driver.findElement(By.cssSelector("a[data-test=\"book-authors-0\"]")).getText().toLowerCase();
    }

    public String getPrice(){
        return driver.findElement(By.cssSelector("span[data-test=\"book-price\"]")).getText();
    }

    public void clickSampleFullscreenButton() {
        driver.findElement(By.className("full-screen")).click();

    }
}
