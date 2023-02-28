package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {

    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }


    @When("user searches for given keyword")
    public void userSearchesForGivenKeyword() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBox.sendKeys(ConfigurationReader.getProperty("googleSearchKeyword"));
        googleSearchPage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("user should see keyword in title of the page")
    public void userShouldSeeKeywordInTitleOfThePage() {
        String keyword = ConfigurationReader.getProperty("googleSearchKeyword");
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(keyword + " - Google Search"));
    }
}
/*
@When("user searches for given keyword")
    public void user_searches_for_given_keyword() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBox.sendKeys(ConfigurationReader.getProperty("googleSearchKeyword"));
        googleSearchPage.searchBox.sendKeys(Keys.ENTER);
    }
    @Then("user should see keyword in title of the page")
    public void user_should_see_keyword_in_title_of_the_page() {
        String keyword = ConfigurationReader.getProperty("googleSearchKeyword");
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(keyword + " - Google Search"));
    }
 */