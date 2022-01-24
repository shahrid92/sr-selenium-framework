package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import static com.google.common.truth.Truth.assert_;

public class MainProductPage extends PageObject {

    public MainProductPage (WebDriver driver){
        super(driver);
    }


    public MainProductPage VerifyMainProductTitle(){
        assert_().that(main_product_title.getAttribute("outerText")).isNotEmpty();
        System.out.println(main_product_title.getAttribute("outerText"));
        return this;
    }

    public MainProductPage addToCartProduct(){
        addToCartButton.click();
        return this;
    }


}
