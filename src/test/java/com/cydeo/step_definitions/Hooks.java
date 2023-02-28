package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
Hooks class is used to give pre- and post-conditions for all the scenarios or steps
within the project
 */

public class Hooks {
    // @After annotation will be executed after each step in current project
    // Choosing @After annotation that comes from io.cucumber
    @After //(order = 1, value = "@smoke")
    public void tearDownScenario(Scenario scenario) {
        /*
        Using TakesScreenshot interface which is coming from Selenium library in this method which will be executed
        after each scenario in current project. Since @After tag makes this method to run after each scenario, if the
        scenario is failed the screenshot will be taken and attached to html report or published on cucumber web site
        where we can access it by having link from console.
         */
        /**
         Steps to get a screenshot:

         1. Each time we run particular scenario the Scenario class object is being created by cucumber, which tracks
         status of current scenario that is running. We can use isFailed() method of Scenario class to check if our
         current scenario failed or not, we can use attach() method to attach something to this scenario. In this case
         we will attach screenshot to the scenario if it fails. And later on when we look at the reports related to
         the execution of this particular scenario we will see screenshots or any other attachments.

         2. Taking screenshot:
         2.1 Do ref typecasting, downcast driver instance to TakesScreenshot.
         2.2 Call getScreenshotAs() method and provide parameter, how we want to get that screenshot. In this case
         as a bytes. The screenshot will be provided in the form of small pixels.
         2.3 Store each byte as an element to Array of bytes for further usage.

         3. Attaching take screenshot to the reports. If the plugin option is enabled in cucumber.options in CukesRunner
         class, we can get report with the screenshot for the scenario that failed. Also, we will get a screenshot in
         published on cucumber website report if the publish option also enabled in cucumber.options.
         3.1 Calling attach() method from Scenario object and passing parameters:
         3.1.1 Ref variable of the Array that holds bytes (pixels)
         3.1.2 Media type / format of the screenshot
         3.1.3 Name for the image, we can assign the name of the scenario that is failed
         */

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
