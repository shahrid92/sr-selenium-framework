package pageObjectRepo.demosqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjectRepo.PageObject;

import static com.google.common.truth.Truth.assert_;

public class buttonPage extends PageObject {

    public buttonPage(WebDriver driver){
        super(driver);
    }

    public buttonPage doubleClickButtonAction(){

        doubleClickButton.click();
        actions.doubleClick(doubleClickButton).perform();
        return this;
    }

    public buttonPage verifyDoubleClickMsg(String msg){
        assert_().withMessage("Double click message should be same").that(doubleClickButtonMessage.getText()).contains(msg);
        return this;
    }


}
