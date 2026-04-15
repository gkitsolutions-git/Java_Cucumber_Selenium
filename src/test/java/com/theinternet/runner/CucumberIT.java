package com.theinternet.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.theinternet.stepdefinitions",
    tags = "@smoke",
    plugin = {
        "pretty",
        "json:target/cucumber.json",
        "html:target/cucumber-reports/index.html"
    },
    monochrome = true
)
public class CucumberIT {
    // Entry point for Maven Failsafe (matches *IT.java convention)
}
