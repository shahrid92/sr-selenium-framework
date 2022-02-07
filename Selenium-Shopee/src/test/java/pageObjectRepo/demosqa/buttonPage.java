package pageObjectRepo.demosqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjectRepo.PageObject;

import java.util.List;

import static com.google.common.truth.Truth.assert_;

public class buttonPage extends PageObject {

    public buttonPage(WebDriver driver){
        super(driver);
    }

    public buttonPage doubleClickButtonAction(){
        actions.doubleClick(doubleClickButton).perform();
        return this;
    }

    public buttonPage verifyDoubleClickMsg(String msg){
        assert_().withMessage("Double click message should be same").that(doubleClickButtonMessage.getText()).contains(msg);
        return this;
    }

    public buttonPage rightClickButtonAction(){
        actions.contextClick(rightClickButton).perform();
        return this;
    }

    public buttonPage verifyrightClickMsg(String msg){
        assert_().withMessage("right click message should be same").that(rightClickButtonMessage.getText()).contains(msg);
        return this;
    }

    public buttonPage dynamicClickButtonAction(String msg){
        dynamicClickButton.get(3).click();
        assert_().withMessage("dynamic click message should be same").that(dynamicClickButtonMessage.getText()).contains(msg);
        return this;
    }



}
