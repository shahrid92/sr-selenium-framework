package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

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
        return this;
    }

    public AdminPage EnterUserName(String text){
        System.out.println(userNameTxt.size());
        wait.until(ExpectedConditions.visibilityOf(userNameTxt.get(0))).sendKeys(text);
        return this;
    }

    public void EnterPassword(String pass){
        wait.until(ExpectedConditions.visibilityOf(passTextField.get(0))).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(passTextField.get(1))).sendKeys(pass);
    }

}
