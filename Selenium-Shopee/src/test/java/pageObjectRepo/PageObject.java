package pageObjectRepo;

import common.helper.JsExecuteHelper;
import driverLifeCycle.TestDriverClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObject extends TestDriverClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JsExecuteHelper js;

    public PageObject(WebDriver driver){
        this.driver = driver;
        js = new JsExecuteHelper(this.driver);
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    //Search Results Page
    //--------------------------------------------------------------------------------------------
    @FindBy(css = ".shopee-search-result-header__text-highlight")
    protected WebElement searchedProductTextHighlight;

    @FindBy(css = ".row > div")

    protected List<WebElement> productsList;

    @FindBy(css = ".shopee-search-item-result__item > a > div > div > div + div > div:nth-child(1) > div:nth-child(1)")
    protected List<WebElement> productsTitle;
    //--------------------------------------------------------------------------------------------

    //Product Page
    //--------------------------------------------------------------------------------------------
    @FindBy(css = ".page-product")
    protected WebElement productPage;

    //--------------------------------------------------------------------------------------------

}
