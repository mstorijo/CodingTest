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
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by ToriJohanne on 16/09/2014.
 */
public class SearchSteps {

    private PageHelper pageHelper;
    private WebDriver driver;
    FrontPage frontPage;
    SearchResultsPage searchResultsPage;
    BookPage bookPage;
    String searchTerm;
    String firstResultTitle;
    String firstResultAuthor;
    String firstResultPrice;

    @Before
    public void beforeScenario() throws Exception {
        driver = WebDriverFactory.createWebDriver();
        pageHelper = new PageHelper(driver);
    }

    @Given("^Customer is viewing the front page$")
    public void Customer_is_viewing_the_front_page() throws Throwable {
        frontPage = pageHelper.goToFrontPage();
    }

    @When("^she searches for \"([^\"]*)\"$")
    public void she_searches_for(String title) throws Throwable {
        searchTerm = title;
        searchResultsPage = frontPage.searchForTerm(searchTerm);
        String displayedSearchTerm = searchResultsPage.returnSearchTerm();
        Assert.assertTrue("Displayed Search Term does not match", displayedSearchTerm.contains(searchTerm));
    }

    @And("^she selects a book$")
    public void she_selects_a_book() throws Throwable {
        firstResultTitle = searchResultsPage.getFirstTitle();
        firstResultAuthor = searchResultsPage.getFirstAuthor();
        firstResultPrice = searchResultsPage.getFirstPrice();
        bookPage = searchResultsPage.selectFirstBook();
    }

    @Then("^she gets no results$")
    public void the_customer_gets_no_results() throws Throwable {
        Assert.assertTrue(searchResultsPage.assertNoResultsDisplayed());
    }

    @Then("^the first result matches the search term$")
    public void the_first_result_matches_the_search_term() throws Throwable {
        Assert.assertTrue("Search results not loaded", searchResultsPage.assertResultsDisplayed());
        String firstResultTerm = searchResultsPage.getFirstTitle();
        Assert.assertTrue("Displayed Book Title Term does not match", firstResultTerm.contentEquals(searchTerm));
    }

    @Then("^all book attributes match the clicked search result$")
    public void all_book_attributes_match_the_clicked_search_result() throws Throwable {
        String bookTitle = bookPage.getBookTitle();
        String bookAuthor = bookPage.getAuthor();
        String bookPrice = bookPage.getPrice();
        Assert.assertTrue("Book Title Doesn't Match Search Result", bookTitle.contentEquals(firstResultTitle));
        Assert.assertTrue("Book Author Doesn't Match Search Result", bookAuthor.contentEquals(firstResultAuthor));
        Assert.assertTrue("Book Price Doesn't Match Search Result", bookPrice.contentEquals(firstResultPrice));
    }


    @After
    public void afterScenario() {
        pageHelper.endTest();
    }


}
