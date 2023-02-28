package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        /*
        In this second runner class by use glue option to provide path of step definitions and feature to provide the
        feature file that needs to be executed. In this case we are connecting same step definitions with the failed
        tests that are noted in the rerun.txt file. Basically we will be rerunning same step definitions that previously
        failed.
        The difference between 2 classes is which Feature file they are executing. The first one will be accessing feature
        files directory that has all the feature files.
        The second one will be accessing rerun.txt file which will have only failed scenarios.
        Both classes will be accessing same step definitions class since step definitions both for passed and failed
        scenarios are same.
         */
        features = "@target/rerun.txt",
        glue = "com/cydeo/step_definitions"
        /*
        In CukesRunner class we are running all the scenarios from the feature files with their step definitions
        In FailedTestRunner class we are running only failed scenarios that are recorded in the rerun.txt file after
        initial execution.
        In CukesRunner class we are connecting Step Definitions with the Feature Files directory
        In FailedTestRunner we are connecting Step Definitions with the rerun.txt file that is stored inside the target
        folder that has failed tests/scenarios recorded. We have to provide rerun.txt file path to the Feature option:
         */
        /**
        "@target/rerun.txt"
        */
)

public class FailedTestRunner {
}
