package pageObjectRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;


import static com.google.common.truth.Truth.assert_;

public class SearchFilterSection extends PageObject{

    private static final Logger LOGGER = LogManager.getLogger(SearchFilterSection.class);

    public SearchFilterSection(WebDriver driver){
        super(driver);
    }

    public SearchFilterSection shippedFrom(){

        String[] state = {
                "Local",
                "Overseas",
                "West Malaysia",
                "East Malaysia",
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

            wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));
            assert_().withMessage("Test Placeholder").that(shippedFromElements.get(i).getAttribute("outerText")).contains(state[i]);
        }

        return this;
    }

    public SearchFilterSection byCatergory(int byCatIndexStart,int byCatIndexEnd){

        SoftAssert softAssert = new SoftAssert();

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

        filterMoreButton.get(1).click();

        for(int i=byCatIndexStart;i<byCatIndexEnd;i++){
            shippedFromElements.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));
            softAssert.assertEquals(shippedFromElements.get(i).getAttribute("outerText"),cat[i-byCatIndexStart]);
            shippedFromElements.get(i).click();
        }

        softAssert.assertAll();

        return this;
    }

    public SearchFilterSection priceRange(int priceFrom, int priceTo ){

        ArrayList<Double> proPrice = new ArrayList<Double>();

        js.scrollPageDown(4,1000,0);

        priceRangeFields.get(0).sendKeys("");
        priceRangeFields.get(1).sendKeys("");
        priceRangeFields.get(0).sendKeys(String.valueOf(priceFrom));
        priceRangeFields.get(1).sendKeys(String.valueOf(priceTo));
        filterPrimaryButton.get(0).click();

        js.scrollPageDown(4,1000,0);
        js.scrollPageDown(4,0,1000);

        wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));
        NumberFormat format = NumberFormat.getNumberInstance();

        for(int i=0;i<productPrice.size();i++){
            try{
                Number number = format.parse(productPrice.get(i).getAttribute("outerText"));
                if(Double.parseDouble(number.toString()) < priceTo ){
                    proPrice.add(Double.parseDouble(number.toString()));
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        double avg =0, subtotal = 0;
        for(int j=0;j<proPrice.size();j++){
            subtotal = subtotal + proPrice.get(j);
            avg = subtotal/proPrice.size();
        }
        System.out.println(avg);
        assert_().withMessage("Test Failed").that(avg).isLessThan(priceTo);

        return this;
    }

    public SearchFilterSection byBrands(String brand){

        filterMoreButton.get(2).click();
        System.out.println(brandListALL.size());

        int found=0;
        for(int i=0;i<brandListALL.size();i++){
            if(brandListALL.get(i).getAttribute("outerText").contains(brand)){
                brandListALL.get(i).click();
                found=1;
                break;
            }
        }

        assert_().withMessage("Brands not found").that(found).isEqualTo(1);
        wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));

        try{
            wait(10000);
        }catch(Exception e){

        }
        js.scrollPageDown(4,1000,0);
        js.scrollPageDown(4,0,1000);

        return this;
    }

    public SearchFilterSection byShopType(){

        shopType.forEach((e)->{
            e.click();
            wait.until(ExpectedConditions.visibilityOf(productsListPlaceholder));
        });

        return this;
    }
}
