package test.ui.demo;


import BaseClass.TestBase;
import org.testng.annotations.Test;
import pageObjectRepo.demosqa.checkboxPage;

public class checkBoxTreeTest extends TestBase {

    @Test(enabled=true)
    public void randomSelectCheckboxAction(){
        new checkboxPage(driver)
                .randomSelectCheckbox();
    }



}
