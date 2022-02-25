package cucumber.stepdefinition;


import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue={"cucumber.stepdefinition"},
        monochrome = true,
        publish = true,
        plugin = {"pretty","html:target/cucumber_reports/HtmlReports.html",
                "json:target/cucumber_reports/HtmlReports.json",
                "junit:target/cucumber_reports/HtmlReports.xml"},
        tags="@smoketest"
        )
public class TestRunner {
}
