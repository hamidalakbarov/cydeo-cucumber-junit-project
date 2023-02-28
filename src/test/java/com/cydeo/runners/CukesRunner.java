package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = true,
        plugin = {
                "pretty",
                "html:target/CydeoDropdown.html",
                "rerun:target/rerun.txt",
                // First plugin will be storing html reports for execution of scenarios in target folder
                // Second plugin will be storing failed scenarios/test in the rerun.txt file inside the target folder
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                // the plugin for Maven Cucumber Report
                "json:target/cucumber.json"
        }


)
public class CukesRunner {
}
