import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={""},
        plugin = {"pretty", "html:target/cucumber.html"},
        tags = "@Regressions1") // default tags if no pass parameter from cli
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
