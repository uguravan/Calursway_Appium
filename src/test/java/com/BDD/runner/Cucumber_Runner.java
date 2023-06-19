package com.BDD.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                plugin = {
                        "json:target/cucumber.json",
                        "html:target/cucumber-report.html",
                        "rerun:target/rerun.txt",
                        "me.jvt.cucumber.report.PrettyReports:target/cucumber"
                },
                features = "src/test/resources",
                glue = "com/BDD/step_Definition"
         //   tags = "@dnm"
        )
public class Cucumber_Runner extends AbstractTestNGCucumberTests {


}
