package pageObjectRepo;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assert_;

public class ResultsPage extends PageObject {

    /*
    * Helper :
    * - wait
    * - js
    *
    */

    public ResultsPage(WebDriver driver){
        super(driver);
    }

    public ResultsPage VerifyProductHighlighted(){
        Reporter.log("Verifying search text highlight");
        wait.until(ExpectedConditions.visibilityOf(searchedProductTextHighlight));
        assert_().that(searchedProductTextHighlight.isDisplayed()).isTrue();
        return this;
    }

    public ResultsPage SearchProductionSelection(){
        js.scrollPageDown(4,0,1000);
        wait.until(ExpectedConditions.visibilityOf(productsList.get(49))); // Not working
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(productsTitle.get(49).getText());
        productsList.get(49).click();
        wait.withMessage("Not Found").until(ExpectedConditions.visibilityOf(productPage));
        return this;
    }

}
