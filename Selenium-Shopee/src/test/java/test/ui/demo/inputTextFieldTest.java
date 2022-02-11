package test.ui.demo;

import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.demosqa.textBoxPage;

public class inputTextFieldTest extends TestBase {

    @Test(enabled = false)
    public void inputTexFullNametFieldAction(){
        new textBoxPage(driver)
                .enterTextFieldFullName("Shah Ridzuan Bin Abdul");
    }

    @Test(enabled = true)
    public void inputTextEmailFieldAction(){
        new textBoxPage(driver)
                .enterTextFieldEmail("shah@test.com");
    }

    @Test(enabled = true)
    public void inputTextCurrAddressFieldAction(){
       new textBoxPage(driver)
            .enterTextFieldCurAddress("Kuala Selangor,Selangor");

    }

}
