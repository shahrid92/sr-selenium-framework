package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.google.common.truth.Truth.assert_;

public class MainProductPage extends PageObject {

    @FindBy(css =".flex-auto .flex-column > div > span")
    private WebElement main_product_title;

    @FindBy(css=".btn-tinted.btn--l")
    private WebElement addToCartButton;

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
