package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\HP\\eclipse-workspace\\automation-assignment\\src\\main\\resources\\Features\\create_post.feature",
        glue = "stepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
