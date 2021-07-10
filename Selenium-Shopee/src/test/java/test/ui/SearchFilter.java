package test.ui;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectRepo.LandingPage;
import pageObjectRepo.SearchFilterSection;

public class SearchFilter extends TestDriverClass {

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void Filter_ShippedFrom_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Roadbike");
        SearchFilterSection sfs = new SearchFilterSection(driver,softAssert);
        sfs
                .shippedFrom();
    }

    @Test(enabled = true)
    public void Filter_ByCatergory_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Router");

        SearchFilterSection sfs = new SearchFilterSection(driver,softAssert);
        sfs
                .byCatergory();
        softAssert.assertAll();

    }

}
