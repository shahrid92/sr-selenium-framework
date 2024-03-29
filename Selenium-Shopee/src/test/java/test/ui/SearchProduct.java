package test.ui;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.ResultsPage;

public class SearchProduct extends TestBase {

    @Test(enabled = true)
    public void SelectProduct(){

        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Melayu")
                // .adsModalDisplay()
                .searchProducts("Samsung Galaxy");

        ResultsPage rp = new ResultsPage(driver);
        rp
                .SearchProductionSelection();
    }

    @Test(enabled = false)
    public void RandomSelectProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Melayu")
                .adsModalDisplay()
                .searchProducts("Samsung Galaxy");
        ResultsPage rp = new ResultsPage(driver);
        rp
                .SelectRandomProduct();
    }

    @Test(enabled = false)
    public void SearchAppleProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Melayu")
                .adsModalDisplay()
                .searchProducts("Apple Iphone 12 Pro Max");
    }
}
