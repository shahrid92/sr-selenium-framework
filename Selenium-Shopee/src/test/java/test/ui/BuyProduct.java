package test.ui;

import driverLifeCycle.TestBase;

import org.testng.annotations.Test;
import pageObjectRepo.*;

public class BuyProduct extends TestBase {


    @Test(enabled = false)
    public void buyProduct_Test(){

        LandingPage lp = new LandingPage(driver);
        lp
                .languageHomeSelection("English")
                .adsModalDisplay()
                .searchProducts("Thule");

        ResultsPage rp = new ResultsPage(driver);
        rp
                .SearchProductionSelection();

        MainProductPage mpp = new MainProductPage(driver);
        mpp
                .addToCartProduct();

        LoginPage lgnp = new LoginPage(driver);
        lgnp
                .loginByGoogle();

    }



}
