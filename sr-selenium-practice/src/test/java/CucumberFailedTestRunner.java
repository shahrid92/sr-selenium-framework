import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="@target/failedScenarios.txt",
        glue={""},
        plugin = {"pretty", "html:target/cucumber.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@Sanity-1") // default tags if no pass parameter from cli
public class CucumberFailedTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

