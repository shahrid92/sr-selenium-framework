package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static com.google.common.truth.Truth.assertWithMessage;

public class AdminPage extends PageObject {

    @FindBy(xpath = "(//*[@class=\"oxd-select-wrapper\"])[1]")
    private WebElement selectUserRole;

    @FindBy(xpath = "(//*[@class=\"oxd-select-wrapper\"])[2]")
    private WebElement selectStatus;

    @FindBy(css = ".oxd-autocomplete-text-input--before + input")
    private WebElement employeeNameTxt;

    @FindBy(css = "input:nth-child(1)")
    private List<WebElement> userNameTxt;

    @FindBy(css = "[type=password]")
    private List<WebElement> passTextField;

    @FindBy(css = "[role=listbox]")
    private WebElement usernameListBox;

    @FindBy(css = "input.oxd-input:nth-child(1)")
    private WebElement usernameTextField;

    @FindBy(css = ".oxd-select-text")
    private List<WebElement>  adminPageSelectFields;

    @FindBy(css = ".oxd-table-card:nth-child(1) > .oxd-table-row > .oxd-table-cell:nth-child(2)")
    private WebElement recordListUsername;

    @FindBy(css = " .oxd-table-card:nth-child(1) > .oxd-table-row > .oxd-table-cell:nth-child(6) .oxd-icon-button:nth-child(2)")
    private WebElement editButton;

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void UserRoleSelection(){
        wait.until(ExpectedConditions.visibilityOf(selectUserRole)).click();

    }

    public void StatusSelection(){
        wait.until(ExpectedConditions.visibilityOf(selectStatus)).click();

    }

    public AdminPage EnterEmployeeName(String text){
        wait.until(ExpectedConditions.visibilityOf(employeeNameTxt)).sendKeys(text);
        new CommonSteps(driver)
                .verifyPageText(text);
        return this;
    }

    public AdminPage SelectEmployeeName(){
        System.out.println(wait.until(ExpectedConditions.visibilityOf(usernameListBox)).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(usernameListBox)).click();
        return this;
    }

    public AdminPage EnterUserName(String text){
        wait.until(ExpectedConditions.visibilityOf(userNameTxt.get(0))).sendKeys(text);
        return this;
    }

    public void EnterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOf(passTextField.get(0))).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(passTextField.get(1))).sendKeys(pass);
    }

    public void EnterSearchUsername(String text){
        wait.until(ExpectedConditions.visibilityOf(usernameTextField)).sendKeys(text);
    }

    public void validateRecordFoundUsername(String expectedText){
        String username = wait.until(ExpectedConditions.visibilityOf(recordListUsername)).getText();
        assertWithMessage("Username not found!").that(username).contains(expectedText);
    }

    public void selectbyUserRole(String userRole){
        wait.until(ExpectedConditions.visibilityOf(adminPageSelectFields.get(0))).click();
    }

    public void clickEdit(){
        String username = wait.until(ExpectedConditions.visibilityOf(editButton)).getText();
    }



}
