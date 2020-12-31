package pageObjectRepo;

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

    @FindBy(css =".language-selection")
    private WebElement LanguageBox;

    @FindBy(css = ".language-selection__list-item")
    private List<WebElement> languageSelection;

    @FindBy(css = ".shopee-popup__container")
    private WebElement adsModal;

    @FindBy(css = ".header-with-search__logo-section")
    private WebElement logoHeader;

    @FindBy(css = ".shopee-searchbar-input > input")
    private WebElement searchBar;

    @FindBy(css = ".btn")
    private WebElement searchBtn;

    @FindBy(css = ".shopee-popup__close-btn")
    private WebElement adsModalCloseBtn;

    @FindBy(css = ".shopee-popup__overlay")
    private WebElement overlay;

    /*

    @FindBy(css = "")
    private WebElement ;

    * */

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public LandingPage languageHomeSelection(String lang){
        Reporter.log("Select Language : "+ lang);
        for(int i=0;i<languageSelection.size()-1;i++) {
            if (languageSelection.get(i).getText().equals(lang)) {
                languageSelection.get(i).click();
            }
        }
        return this;
    }

    public LandingPage adsModalDisplay(){
        Reporter.log("Verify Ads Modal");
        wait.until(ExpectedConditions.visibilityOf(adsModal));
        assert_().withMessage("Ads Modal should be displayed").that(adsModal.isDisplayed()).isTrue();
        adsModalCloseBtn.click();
        return this;
    }
    
    public LandingPage searchProducts() {
        Reporter.log("Search Product");
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        Reporter.log("Click Search Bar");
        searchBar.click();
        Reporter.log("Enter Search Queries");
        searchBar.sendKeys("Apple IPhone 12 Pro Max");
        Reporter.log("Click Search Button");
        searchBtn.click();

        ResultsPage rp = new ResultsPage(driver);
        rp.VerifyProductHighlighted();

        return this;
    }

}

