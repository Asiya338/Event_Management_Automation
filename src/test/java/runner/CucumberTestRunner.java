package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features="src/test/resources/features/"	,
	glue = {"stepdefinitions" , "utils"},
    tags = "(@BookingPage or @ContactUsPage) and (not @ignore)",   // Execute scenarios with this tag
    plugin = {
        "pretty",
        "html:target/cucumber-reports/Cucumber.html",
        "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml"
    },
    monochrome = true
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {}
