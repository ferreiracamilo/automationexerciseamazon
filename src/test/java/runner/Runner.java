package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports.json"},
    monochrome = true
    //tags = {"@Grid","@Smoke"} -> in case is wanted to specified which tag needs to be executed without passing a tag through terminal with gradle
)

public class Runner{
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}