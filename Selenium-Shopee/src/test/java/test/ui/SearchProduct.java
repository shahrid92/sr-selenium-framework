package test.ui;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.ResultsPage;

public class SearchProduct extends TestDriverClass {

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
    public void SearchAppleProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts("Apple Iphone 12 Pro Max");
    }
}
