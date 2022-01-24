package pageObjectRepo;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assert_;

public class ResultsPage extends PageObject {

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
       // wait.until(ExpectedConditions.visibilityOf(productsList.get(49))); // Not working
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //System.out.println(productsTitle.get(49).getAttribute("outerText"));
        productsList.get(49).click();
        wait.withMessage("Not Found").until(ExpectedConditions.visibilityOf(productPage));
        return this;
    }

    public ResultsPage SelectRandomProduct(){

        int min = 0;
        int max = 49;

        js.scrollPageDown(4,0,1000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        productsList.get(random_int).click();

        MainProductPage mpp = new MainProductPage(driver);

        mpp.VerifyMainProductTitle();

        return this;
    }



}
