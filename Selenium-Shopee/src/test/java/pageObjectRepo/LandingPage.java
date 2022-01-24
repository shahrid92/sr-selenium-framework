package pageObjectRepo;

import common.listener.testListener;
import common.reports.ExtentReportClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.google.common.truth.Truth.assert_;
import static com.google.common.truth.Truth.assertWithMessage;
import org.testng.Reporter;

import java.util.List;

public class LandingPage extends PageObject {

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public LandingPage languageHomeSelection(String lang){

       // LOG.info("Seleting language..");
        Reporter.log("Select Language : "+ lang + "<br>");
        for(int i=0;i<languageSelection.size();i++) {
            if (languageSelection.get(i).getText().equals(lang)) {
                languageSelection.get(i).click();
            }
        }
     //   LOG.info("Clossing modal banner...");
       // wait.until(ExpectedConditions.visibilityOf(shadowElements.get(0)));
        js.clickElement(shadowElements);
        return this;
    }

    public LandingPage adsModalDisplay(){
        Reporter.log("Verify Ads Modal <br>");
        wait.until(ExpectedConditions.visibilityOf(adsModal));
        assert_().withMessage("Ads Modal should be displayed <br>").that(adsModal.isDisplayed()).isTrue();
        adsModalCloseBtn.click();
        return this;
    }
    
    public LandingPage searchProducts(String product) {
        //LOG.info("Search Product "+product);
        Reporter.log("Search Product <br>");
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        Reporter.log("Click Search Bar <br>");
       // LOG.info("Click search bar");
        searchBar.click();
        Reporter.log("Enter Search Queries <br>");
     //   LOG.info("Enter search query...");
        searchBar.sendKeys(product);
      //  LOG.info("Click search button...");
        Reporter.log("Click Search Button <br>");
        searchBtn.click();

        ResultsPage rp = new ResultsPage(driver);
        rp
                .VerifyProductHighlighted();

        return this;
    }

}

