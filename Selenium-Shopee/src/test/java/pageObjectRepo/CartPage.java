package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.google.common.truth.Truth.assert_;


public class CartPage extends PageObject {



    @FindBy(css=".cart-drawer")
    private WebElement cartPage;

    @FindBy(css=".shopee-input-quantity > button")
    private List<WebElement> quantityProduct_AddRemoveButton;

    @FindBy(css=".shopee-input-quantity > input")
    private WebElement quantityProduct_InputQuantity;

    @FindBy(css=".cart-page-logo__page-name")
    private WebElement shoppingCartTitlePage;



    public CartPage(WebDriver driver){
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
