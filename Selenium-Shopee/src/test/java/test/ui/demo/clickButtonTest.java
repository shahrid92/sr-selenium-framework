package test.ui.demo;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;

public class clickButtonTest extends TestBase {

    @Test(enabled = true)
    public void clickButton(){

        new LandingPage(driver)
                .languageHomeSelection("English")
                .searchProducts("Samsung Galaxy");

    }

    @Test(enabled = true)
    public void clickButtonByIndex(){

    }

    @Test(enabled = true)
    public void clickButtonByCSS(){

    }


}
