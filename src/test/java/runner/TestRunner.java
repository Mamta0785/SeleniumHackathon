package runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin={
        "pretty","html:target/SeleniumHackathon.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"


},
        monochrome = true,
        features = {"src/test/resources/features/"},
        //tags = "@loginfeature",
        glue = "stepdefinition")


public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }

}
