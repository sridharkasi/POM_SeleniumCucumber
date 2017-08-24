package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
//@CucumberOptions(features = createcontact "features", glue={"stepDefinition"})

@CucumberOptions(features = "features/createcontact.feature", glue={"stepDefinition"})

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
