package com.blinkbox.test.Search;

import com.blinkbox.test.WebDriverFactory;
import com.blinkbox.test.helpers.PageHelper;
import com.blinkbox.test.pages.BookPage;
import com.blinkbox.test.pages.FrontPage;
import com.blinkbox.test.pages.SearchResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class BookSampleSteps {

    private PageHelper pageHelper;
    private WebDriver driver;
    BookPage bookPage;


    @Before
    public void beforeScenario() throws Exception {
        driver = WebDriverFactory.createWebDriver();
        pageHelper = new PageHelper(driver);

    }

    @Given("^Customer is viewing a book page$")
    public void Customer_is_viewing_a_book_page() throws Throwable {
        bookPage = pageHelper.goToSpecificBook();
    }

    @And("^She clicks on view book sample in full screen$")
    public void She_clicks_on_view_book_sample_in_full_screen() throws Throwable {
        bookPage.clickSampleFullscreenButton();
    }

    @Then("^the book sample loads in full screen$")
    public void the_book_sample_loads_in_full_screen() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("cpr-iframe")).isDisplayed());
    }

    @After
    public void afterScenario(){
        pageHelper.endTest();
    }



}
