package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Bing_StepDefinitions {

    BingSearchPage bingSearchPage = new BingSearchPage();

    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com/");
    }
    @When("user searches for orange on Bing search box")
    public void user_searches_for_orange_on_bing_search_box() {
        bingSearchPage.bingSearchBox.sendKeys("orange");
        bingSearchPage.bingSearchBox.sendKeys(Keys.ENTER);
    }
    @Then("user should see title as a orange - Search")
    public void user_should_see_title_as_a() {
        BrowserUtils.verifyTitle("orange - Search");
    }

    @When("user searches for {string} on Bing search box")
    public void userSearchesForOnBingSearchBox(String arg0) {
        bingSearchPage.bingSearchBox.sendKeys(arg0);
        bingSearchPage.bingSearchBox.sendKeys(Keys.ENTER);
    }

    @Then("user should see title as a {string}")
    public void userShouldSeeTitleAsA(String arg0) {
        BrowserUtils.verifyTitle(arg0);
    }
}
