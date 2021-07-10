package pageObjectRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.testng.asserts.SoftAssert;


import static com.google.common.truth.Truth.assert_;

public class SearchFilterSection extends PageObject{

    private static final Logger LOGGER = LogManager.getLogger(SearchFilterSection.class);
    private SoftAssert softAssert;

    @FindBy(css =".shopee-checkbox__label")
    private List<WebElement> shippedFromElements;

    @FindBy(css =".shopee-filter-group__toggle-btn")
    private List<WebElement> filterMoreButton;

    public SearchFilterSection(WebDriver driver,SoftAssert softAssert){
        super(driver);
        this.softAssert = softAssert;
    }

    public SearchFilterSection shippedFrom(){



        String[] state = {
                "East Malaysia",
                "Local",
                "Overseas",
                "West Malaysia",
                "Selangor",
                "Kuala Lumpur",
                "Penang",
                "Johor",
                "Kedah",
                "Perak",
                "Melaka",
                "Pahang",
                "Negeri Sembilan",
                "Terengganu",
                "Sarawak",
                "Kelantan",
                "Perlis",
                "Sabah",
                "Putrajaya",
                "Labuan"
        };

        filterMoreButton.get(0).click();

        for(int i=0;i<state.length-1;i++){
            shippedFromElements.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));
            assert_().withMessage("Test Placeholder").that(productsListPlaceholder.isDisplayed()).isTrue();
            shippedFromElements.get(i).click();
        }

        return this;
    }

    public SearchFilterSection byCatergory(){



        String[] cat = {
                "Modems & Wireless Routers (55k+)",
                "Tools & Home Improvement (11k+)",
                "Mobile & Gadgets (7k+)",
                "Furniture (5k+)",
                "Home Organizers (3k+)",
                "Repeaters (2k+)",
                "Network Cables & Connectors (2k+)",
                "Desktop & Laptop Components (2k+)",
                "Home & Living / Others (2k+)",
                "Powerline Adapters (2k+)",
                "Home Appliances (1k+)",
                "Kitchenwares (1k+)"
        };

        int byCatIndexStart = 20;
        int byCatIndexEnd = 32;

        filterMoreButton.get(1).click();

        for(int i=byCatIndexStart;i<byCatIndexEnd;i++){
            shippedFromElements.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));

            softAssert.assertEquals(shippedFromElements.get(i).getAttribute("outerText"),cat[i-byCatIndexStart]);
            //assert_().withMessage("Test Placeholder").that(shippedFromElements.get(i).getAttribute("outerText")).contains(cat[i-byCatIndexStart]);
            LOGGER.info(cat[i-byCatIndexStart] +"Verified");
            shippedFromElements.get(i).click();

        }

        //LOGGER.info("Test : byCatergory Pass");

        return this;
    }

}
