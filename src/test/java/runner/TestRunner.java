package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CucumberOptions(plugin = {
        "pretty", "html:target/SeleniumHackathon.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
        "rerun:target/failedrerun.txt"

},
        monochrome = true,

        features = {"src/test/resources/features/"},
        //tags = "@loginfeature",
        glue ={"stepdefinition"} )


public class TestRunner extends AbstractTestNGCucumberTests {
    public static ThreadLocal<String> browserName = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);


    @Parameters("browserName")
    @BeforeClass
    public void setBrowser(@Optional("chrome") String browser) {
        logger.info("TestRunner: Setting browser parameter: {}", browser);
        browserName.set(browser);
        logger.info("TestRunner: Browser set to ThreadLocal: {}", browser);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
