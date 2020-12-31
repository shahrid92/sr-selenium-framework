
import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.ResultsPage;

public class TestClass extends TestDriverClass {

    @Test
    public void testcase1(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts();

    }
}
