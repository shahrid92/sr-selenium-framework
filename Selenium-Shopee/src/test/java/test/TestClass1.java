package test;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;

public class TestClass1 extends TestDriverClass {

    @Test
    public void testcase2(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts();

    }

}
