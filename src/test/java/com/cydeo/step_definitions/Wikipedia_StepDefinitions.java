package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaHomePage;
import com.cydeo.pages.WikipediaResultPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_StepDefinitions {

    WikipediaHomePage wikipediaHomePage = new WikipediaHomePage();
    WikipediaResultPage wikipediaResultPage = new WikipediaResultPage();

    @Given("user is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipediaURL"));
    }

    @When("user types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String keyword) {
        wikipediaHomePage.searchBox.sendKeys(keyword);
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaHomePage.searchButton.click();
    }

    @Then("user sees {string} is in the {string}")
    public void user_sees_is_in_the(String keyword, String arg) {
        switch (arg) {
            case "wiki title":
                BrowserUtils.verifyTitleContains(keyword);
                break;
            case "main header":
                Assert.assertTrue(wikipediaResultPage.mainHeader.getText().equals(keyword));
                break;
            case "image header":
                Assert.assertTrue(wikipediaResultPage.imageHeader.getText().equals(keyword));
                break;
            default:
                throw new NotImplementedException(arg + " is not yet implemented");
        }
    }
}

class NotImplementedException extends RuntimeException {
    NotImplementedException(String msg) {
        super(msg);
    }
}