package pageObjectRepo.demosqa;

import org.openqa.selenium.WebDriver;
import pageObjectRepo.PageObject;
import common.helper.RandomGenData;

import java.util.Random;

public class checkboxPage extends PageObject {

    public checkboxPage(WebDriver driver){
        super(driver);
    }

    public checkboxPage randomSelectCheckbox(){

        // click + button
        optionsElements.get(0).click();
        LOG.info("Click options '+' button");

        Random rand = new Random();
        int index = RandomGenData.RandomInt(rand,0,checkBoxTreeElements.size()-1);
        LOG.info("Index number : "+index);
        checkBoxTreeElements.get(index).click();
        LOG.info("Selecting "+checkBoxTreeElements.get(index).getText());
        // click - button
        optionsElements.get(1).click();
        LOG.info("Click options '-' button");

        return this;
    }

}
