package page;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;


import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PIMPage extends PageObject {

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameTxtField;
    @FindBy(css = "input[name='middleName']")
    private WebElement middleNameTxtField;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameTxtField;

    @FindBy(css = ".oxd-grid-2 > div > div > div:nth-child(2) > input")
    private WebElement employeeID;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private List<WebElement> inputFields;

    @FindBy(css = ".oxd-table-card .oxd-table-cell:nth-child(9) .bi-pencil-fill")
    private WebElement editButton;

    @FindBy(css = ".oxd-autocomplete-text-input--before + input")
    private List<WebElement> inputTextFields;

    @FindBy(css = "input.oxd-input")
    private List<WebElement> reportsInputs;

    @FindBy(css = "button > i.bi-plus")
    private WebElement addReportsPIM;

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public PIMPage EnterFirstName(String name) {

        wait.until(ExpectedConditions.visibilityOf(firstNameTxtField)).sendKeys(name);

        return this;
    }

    public PIMPage EnterMiddleName(String name) {

        wait.until(ExpectedConditions.visibilityOf(middleNameTxtField)).sendKeys(name);

        return this;
    }

    public PIMPage EnterLastName(String name) {

        wait.until(ExpectedConditions.visibilityOf(lastNameTxtField)).sendKeys(name);

        return this;
    }

    public PIMPage EnterEmployeeID(String id) {

        wait.until(ExpectedConditions.visibilityOf(employeeID)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        wait.until(ExpectedConditions.visibilityOf(employeeID)).sendKeys(id);
        return this;
    }

    public PIMPage EnterEmployeeName(String name) {

        wait.until(ExpectedConditions.visibilityOf(inputFields.get(0))).isDisplayed();
        System.out.println(inputFields.size());
        inputFields.get(0).sendKeys(name);

        return this;
    }

    public PIMPage clickEditButton() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
        return this;
    }

    public PIMPage searchEmpName(String name) {
        wait.until(ExpectedConditions.visibilityOf(inputTextFields.get(0))).sendKeys(name);
        return this;
    }

    public PIMPage setReportNameAs(String name) {

        wait.until(ExpectedConditions.visibilityOf(addReportsPIM)).click();

        CommonSteps cs = new CommonSteps(this.driver);

        cs.verifyPageText("Add Report");

        reportsInputs.stream()
                .skip(1)
                .findAny()
                .ifPresent(e -> {
                    wait.until(ExpectedConditions.visibilityOf(e))
                            .sendKeys(name);
                });


        cs.clickByText("Save");

        return this;
    }


}
