package test.ui.demo;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.LandingPage;
import pageObjectRepo.demosqa.buttonPage;

public class clickButtonTest extends TestBase {

    @Test(enabled = true)
    public void clickButton(){
        new LandingPage(driver)
                .languageHomeSelection("English")
                .searchProducts("Samsung Galaxy");
    }

    @Test(enabled = true)
    public void doubleClickTestAction(){
        new buttonPage(driver)
                .doubleClickButtonAction()
                .verifyDoubleClickMsg("You have done a double click!");
    }

    @Test(enabled = true)
    public void rightClickTestAction(){
        new buttonPage(driver)
                .rightClickButtonAction()
                .verifyrightClickMsg("You have done a right click");
    }

    @Test(enabled = true)
    public void dynamicClickTestAction(){
        new buttonPage(driver)
                .dynamicClickButtonAction("You have done a dynamic click");
    }


}
