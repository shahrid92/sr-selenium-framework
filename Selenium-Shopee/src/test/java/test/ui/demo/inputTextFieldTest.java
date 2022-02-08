package test.ui.demo;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.demosqa.buttonPage;
import pageObjectRepo.demosqa.textBoxPage;

public class inputTextFieldTest extends TestBase {

    @Test(enabled = true)
    public void inputTextFieldAction(){
        new textBoxPage(driver)
                .enterTextFieldFullName("Shah Ridzuan Bin Abdul");
    }

}
