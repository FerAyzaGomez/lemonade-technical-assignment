package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",
				 glue={"StepDefinitions"},
				 monochrome=true,
				 plugin = { "pretty", "html:target/HtmlReport/report"}
				)
public class TestRunner {

}
