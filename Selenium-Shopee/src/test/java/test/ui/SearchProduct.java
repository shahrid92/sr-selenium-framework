package test.ui;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.ResultsPage;

public class SearchProduct extends TestDriverClass {

    @Test
    public void SelectProduct(){

        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts();

        ResultsPage rp = new ResultsPage(driver);
        rp
                .SearchProductionSelection();
    }

    @Test(enabled = false)
    public void RandomSelectProduct(){

    }

    @Test(enabled = false)
    public void SearchAppleProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts();
    }
}
