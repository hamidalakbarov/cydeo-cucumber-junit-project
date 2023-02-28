package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoDropdownPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CydeoDropdown_StepDefinitions {

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> months) {
        Assert.assertEquals(months, CydeoDropdownPage.getMonthDropdown());
    }
}
