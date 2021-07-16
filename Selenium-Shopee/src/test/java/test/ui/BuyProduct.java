package test.ui;

import driverLifeCycle.TestDriverClass;

import org.testng.annotations.Test;
import pageObjectRepo.*;

public class BuyProduct extends TestDriverClass  {


    @Test(enabled = true)
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

//        CartPage cp = new CartPage(driver);
//        cp
//                .verifyShoppingCartPage();

        LoginPage lgnp = new LoginPage(driver);
        lgnp
                .loginByGoogle();

    }



}
