package test.ui;

import driverLifeCycle.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjectRepo.LandingPage;
import pageObjectRepo.SearchFilterSection;

public class SearchFilter extends TestBase {

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void Filter_ShippedFrom_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Roadbike");
        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .shippedFrom();
    }

    @Test(enabled = false)
    public void Filter_ByCatergory_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Router");

        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .byCatergory(20,31);
        softAssert.assertAll();

    }

    @Test(enabled = false)
    public void Filter_priceRange_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Battery");

        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .priceRange(2,3);
    }

    @Test(enabled = false)
    public void Filter_byBrands_Test(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("food");

        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .byBrands("IKEA");
    }

    @Test(enabled = false)
    public void Filter_byShopType(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("toys");
        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .byShopType();
    }

    @Test(enabled = true)
    public void Filter_SortBy(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("perodua");
        SearchFilterSection sfs = new SearchFilterSection(driver);
        sfs
                .SortBy_Test();
    }

}
