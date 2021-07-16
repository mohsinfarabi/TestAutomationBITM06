package com.Cucumber;

//import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "./src/main/java/com/Cucumber/LoginStep.java",
                glue = {"com.Cucumber.LoginStep"},
                plugin = {
                        "pretty","html:target/CucumberReport.html"
                }
)


public class Runner {
}
