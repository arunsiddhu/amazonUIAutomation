package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","json:target/testReport.json","html:target/testReport.html"},
glue = "stepdefinitions", 
features = "src/test/resources/features",
dryRun = false,
tags="@ValidLogin",
monochrome=true,
publish=true)
public class RunTest {
};