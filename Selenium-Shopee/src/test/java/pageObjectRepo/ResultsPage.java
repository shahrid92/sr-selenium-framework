package pageObjectRepo;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import static com.google.common.truth.Truth.assert_;

public class ResultsPage extends PageObject {

    @FindBy(css = ".shopee-search-result-header__text-highlight")
    private WebElement searchedProductTextHighlight;

    public ResultsPage(WebDriver driver){
        super(driver);
    }

    public ResultsPage VerifyProductHighlighted(){
        Reporter.log("Verifying search text hilight");
        wait.until(ExpectedConditions.visibilityOf(searchedProductTextHighlight));
        assert_().that(searchedProductTextHighlight.isDisplayed()).isTrue();
        return this;
    }

}
