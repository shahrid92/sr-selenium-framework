package pageObjectRepo;

import common.helper.JsExecuteHelper;
import common.listener.testListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.Remote;
import java.util.List;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static JsExecuteHelper js;
    protected static final Logger LOG = LogManager.getLogger(PageObject.class);
    protected Actions actions;

    public PageObject(WebDriver driver){
        this.driver = driver;
        js = new JsExecuteHelper( this.driver);
        wait = new WebDriverWait( this.driver,60);
        PageFactory.initElements( this.driver, this);
        this.actions = new Actions(driver);
    }

    //Search Results Page
    @FindBy(css = ".shopee-search-result-header__text-highlight")
    protected WebElement searchedProductTextHighlight;

    @FindBy(css = ".row > div")
    protected List<WebElement> productsList;

    @FindBy(css = ".shopee-search-item-result__item > a > div > div > div + div > div:nth-child(1) > div:nth-child(1)")
    protected List<WebElement> productsTitle;

    @FindBy(css = ".shopee-search-item-result__items")
    protected WebElement productsListPlaceholder;

    //Product Page
    @FindBy(css = ".page-product")
    protected WebElement productPage;

    @FindBy(css = "div[data-sqe='name'] > div:nth-child(1) > div")
    protected List<WebElement> productListTitles;

    //Shopping Cart Page
    @FindBy(css=".cart-drawer")
    protected WebElement cartPage;

    @FindBy(css=".shopee-input-quantity > button")
    protected List<WebElement> quantityProduct_AddRemoveButton;

    @FindBy(css=".shopee-input-quantity > input")
    protected WebElement quantityProduct_InputQuantity;

    @FindBy(css=".cart-page-logo__page-name")
    protected WebElement shoppingCartTitlePage;

    //Landing Page
    @FindBy(css =".language-selection")
    protected WebElement LanguageBox;

    @FindBy(css = ".language-selection__list-item")
    protected static List<WebElement> languageSelection;

    @FindBy(css = "shopee-banner-popup-stateful")
    protected WebElement adsModal;

    @FindBy(css = ".header-with-search__logo-section")
    protected WebElement logoHeader;

    @FindBy(css = ".shopee-searchbar-input > input")
    protected WebElement searchBar;

    @FindBy(css = ".btn")
    protected WebElement searchBtn;

    @FindBy(css = ".shopee-popup__close-btn")
    protected WebElement adsModalCloseBtn;

    @FindBy(css = ".shopee-popup__overlay")
    protected WebElement overlay;

    //Login Page
    @FindBy(css = "button")
    protected List<WebElement> login;

    @FindBy(css = "[data-authuser]")
    protected List<WebElement> gmailAccLists;

    @FindBy(css = "input[type='email']")
    protected WebElement inputEmail;

    @FindBy(css = "button")
    protected WebElement login2;

    @FindBy(css = ".RveJvd")
    protected List<WebElement> GotItButton;

    @FindBy(css = ".RveJvd")
    protected WebElement UnknownElements;

    @FindBy(css=".stardust-toast__container")
    protected WebElement googleFailedToast;

    //Main Product Page
    @FindBy(css =".flex-auto .flex-column > div > span")
    protected WebElement main_product_title;

    @FindBy(css=".btn-tinted.btn--l")
    protected WebElement addToCartButton;

    //Search filter section
    @FindBy(css =".shopee-checkbox__label")
    protected List<WebElement> shippedFromElements;

    @FindBy(css =".shopee-filter-group__toggle-btn")
    protected List<WebElement> filterMoreButton;

    @FindBy(css =".shopee-price-range-filter__input")
    protected List<WebElement> priceRangeFields;

    @FindBy(css =".shopee-button-solid--primary")
    protected List<WebElement> filterPrimaryButton;

    @FindBy(css ="div[data-sqe=item] > a > div > div > div:nth-child(2) > div:nth-child(2) > div > span:nth-child(2)")
    protected List<WebElement> productPrice;

    @FindAll({
            @FindBy(css =".shopee-brands-filter > div:nth-child(2) > div.shopee-checkbox-filter > div > label"),
            @FindBy(css =".shopee-brands-filter > div:nth-child(2) > div:nth-child(5) > .stardust-dropdown__item-body > div > div > div > label")
    })
    protected List<WebElement> brandListALL;

    @FindBy(css =".shopee-filter-group:nth-child(7) > div:nth-child(2) > div > div > label")
    protected List<WebElement> shopType;

    @FindBy(css =".shopee-sort-by-options > div")
    protected List<WebElement> sortByElements;

    @FindBy(css ="shopee-banner-popup-stateful")
    protected static List<WebElement> shadowElements;

    // demosqa

    @FindBy(css = "#doubleClickBtn")
    protected WebElement doubleClickButton;

    @FindBy(css = "#doubleClickMessage")
    protected WebElement doubleClickButtonMessage;

    @FindBy(css = "button")
    protected List<WebElement> dynamicClickButton;

    @FindBy(css = "#rightClickBtn")
    protected WebElement rightClickButton;

    @FindBy(css = "#rightClickMessage")
    protected WebElement rightClickButtonMessage;

    @FindBy(css = "#dynamicClickMessage")
    protected WebElement dynamicClickButtonMessage;


}
