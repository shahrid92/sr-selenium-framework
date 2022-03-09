package cucumber.stepdefinition;



import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue={"cucumber.stepdefinition"},
        monochrome = true,
        publish = true,
        plugin = {"pretty","html:target/cucumber_reports/HtmlReports.html",
                "json:target/cucumber_reports/HtmlReports.json",
                "junit:target/cucumber_reports/HtmlReports.xml",
                "timeline:target/cucumber_reports/"
        }
        )
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
