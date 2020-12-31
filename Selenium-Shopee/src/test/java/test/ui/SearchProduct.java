package test.ui;

import driverLifeCycle.TestDriverClass;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;

public class SearchProduct extends TestDriverClass {

    @Test
    public void SelectProduct(){

    }

    @Test
    public void RandomSelectProduct(){

    }

    @Test
    public void SearchAppleProduct(){
        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("Bahasa Malaysia")
                .adsModalDisplay()
                .searchProducts();
    }
}
