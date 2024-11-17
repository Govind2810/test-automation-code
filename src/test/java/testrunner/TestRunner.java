package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:/VISHAL/eclipse-workspace/selenium-automation/src/test/resources/Features", 
				 glue = {"stepdefinitions"},
				 monochrome = true,
				 plugin = {"pretty", "html:target/reports/cucumber-html"}
//				 tags = "@SmokeTest"
				 )
public class TestRunner {

}
