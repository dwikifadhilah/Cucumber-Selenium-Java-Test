package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			tags = "@RunAll",
			features = {"classpath:features"},
			glue = {"classpath:stepdef"},
			plugin = {"pretty", "html:target/html-reports.html"},
			dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
