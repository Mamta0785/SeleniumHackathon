package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import utils.ReadConfig;
import utils.TestContext;

@CucumberOptions(plugin = {
        "pretty", "html:target/SeleniumHackathon.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"

},
        monochrome = true,
        features = {"src/test/resources/features/"},
        //tags = "@loginfeature",
        glue ={"stepdefinition"} )


public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @BeforeClass
    @Parameters({"browserName"})
    public void setBrowserName(@Optional("chrome") String browserName) {
        System.out.println("Setting browser for thread {}: {}"+ Thread.currentThread().getId()+ browserName);
        if (browserName != null && !browserName.isEmpty()) {
            System.out.println("Browser parameter successfully set to: {}"+ browserName);
            //System.setProperty("browserName", browserName);
//            ReadConfig readConfig = new ReadConfig();
//            readConfig.setBrowserFromTestNG(browserName);
            TestContext testContext = new TestContext();
            testContext.setBrowserFromTestNG(browserName);

//            System.setProperty("browserName", browserName); //setting a JVM‑wide global property, NOT a thread‑specific value.
            System.out.println("Browser parameter successfully set to for: {}"+ browserName);
        }
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
