package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends PageObject {

    @FindBy(css="input[name='firstName']")
    private WebElement firstNameTxtField;
    @FindBy(css="input[name='middleName']")
    private WebElement middleNameTxtField;

    @FindBy(css="input[name='lastName']")
    private WebElement lastNameTxtField;

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public PIMPage EnterFirstName(String name){

        wait.until(ExpectedConditions.visibilityOf(firstNameTxtField)).sendKeys(name);

        return this;
    }

    public PIMPage EnterMiddleName(String name){

        wait.until(ExpectedConditions.visibilityOf(middleNameTxtField)).sendKeys(name);

        return this;
    }

    public PIMPage EnterLastName(String name){

        wait.until(ExpectedConditions.visibilityOf(lastNameTxtField)).sendKeys(name);

        return this;
    }


}
