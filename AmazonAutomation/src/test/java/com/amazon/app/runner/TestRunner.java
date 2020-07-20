package com.amazon.app.runner;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "res/features", glue = "com.amazon.app.steps", monochrome = true, plugin = { "pretty",
		"json:target/cucumber-jvm-report/cucumber.json" })
public class TestRunner {

}