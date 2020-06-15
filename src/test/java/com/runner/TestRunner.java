package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"/src/test/resources/Features/"} , plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "steps")
public class TestRunner  {



}