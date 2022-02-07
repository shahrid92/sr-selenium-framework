package test.ui.demo;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.demosqa.buttonPage;

public class clickButtonTest extends TestBase {

    @Test(enabled = false)
    public void clickButton(){

        new LandingPage(driver)
                .languageHomeSelection("English")
                .searchProducts("Samsung Galaxy");

    }

    @Test(enabled = false)
    public void clickButtonByIndex(){

    }

    @Test(enabled = false)
    public void clickButtonByCSS(){

    }

    @Test(enabled = false)
    public void doubleClickTestAction(){
        new buttonPage(driver)
                .doubleClickButtonAction()
                .verifyDoubleClickMsg("You have done a double click!");
    }

    @Test(enabled = true)
    public void rightClickTestAction(){
        new buttonPage(driver)
                .clickButtonAction("You have done a dynamic click");
    }


}
