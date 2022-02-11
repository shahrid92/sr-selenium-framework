package pageObjectRepo.demosqa;

import org.openqa.selenium.WebDriver;
import pageObjectRepo.PageObject;

import static com.google.common.truth.Truth.assert_;

public class textBoxPage extends PageObject {

    public textBoxPage(WebDriver driver){
        super(driver);
    }

    public textBoxPage enterTextFieldFullName(String str){
        textBoxFullname.sendKeys(str);
        String value = textBoxFullname.getAttribute("value");
        assert_().withMessage("Full name text field should have value").that(value).contains(str);
        LOG.info("Enter text field Full Name Passed!");
        return this;
    }

    public textBoxPage enterTextFieldEmail(String str){

        textBoxEmail.sendKeys(str);
        String value = textBoxEmail.getAttribute("value");
        assert_().withMessage("Email text field should have value").that(value).contains(str);
        LOG.info("Enter text field Email Passed!");
     return this;
    }

    public textBoxPage enterTextFieldCurAddress(String str){

        textBoxCurrentAdd.sendKeys(str);
        String value = textBoxCurrentAdd.getAttribute("value");
        assert_().withMessage("Current Address text field should have value").that(value).contains(str);
        LOG.info("Enter text field Current Address Passed!");
        return this;
    }



}
