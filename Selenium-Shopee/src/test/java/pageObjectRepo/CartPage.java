package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.google.common.truth.Truth.assert_;


public class CartPage extends PageObject {

    public CartPage(RemoteWebDriver driver){
        super(driver);
    }

    public CartPage plusProduct(int add){
        for(int i=0;i<add;i++){
            quantityProduct_AddRemoveButton.get(1).click();
        }
        return this;
    }

    public CartPage minusProduct(int remove){
        for(int i=0;i<remove;i++){
            quantityProduct_AddRemoveButton.get(0).click();
        }
        return this;
    }

    public CartPage inputProduct(int quantity){
        quantityProduct_InputQuantity.sendKeys(String.valueOf(quantity));
        return this;
    }

    public CartPage verifyShoppingCartPage(){
        assert_().withMessage("Failed Test").that(shoppingCartTitlePage.getAttribute("outerText")).contains("shopping cart");
        return this;
    }





}
