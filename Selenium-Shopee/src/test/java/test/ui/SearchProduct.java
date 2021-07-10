package test.ui;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.ResultsPage;

public class SearchProduct extends TestDriverClass {

    @Test(enabled = true, priority = 1)
    public void SelectProduct(){

        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts("Samsung Galaxy");

        ResultsPage rp = new ResultsPage(driver);
        rp
                .SearchProductionSelection();
    }

    @Test(enabled = true, priority =2)
    public void RandomSelectProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts("Samsung Galaxy");
        ResultsPage rp = new ResultsPage(driver);
        rp
                .SelectRandomProduct();
    }

    @Test(enabled = true, priority = 3)
    public void SearchAppleProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts("Apple Iphone 12 Pro Max");
    }
}
