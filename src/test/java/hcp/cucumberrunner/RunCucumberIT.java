package hcp.cucumberrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"hcp.steps"},
        plugin = { "pretty", "json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunCucumberIT {
}

