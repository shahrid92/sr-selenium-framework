package page;

import common.utilities.listener.actionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;

import static com.google.common.truth.Truth.assertWithMessage;


public class LoginPage extends PageObject  {

    @FindBy(css="input[name=username]")
    private WebElement UserNameTextField;

    @FindBy(css="input[name=password]")
    private WebElement PasswordTextField;

    @FindBy(css="button[type=submit]")
    private WebElement SubmitButton;

    @FindBy(css=".oxd-topbar-header-breadcrumb > h6")
    private WebElement dashboardTitle;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage LoginAction(String UserName,String Password){
        wait.until(ExpectedConditions.visibilityOf(UserNameTextField));
        wait.until(ExpectedConditions.visibilityOf(PasswordTextField));
        wait.until(ExpectedConditions.elementToBeClickable(PasswordTextField));

        UserNameTextField.sendKeys(UserName);
        PasswordTextField.sendKeys(Password);
        SubmitButton.click();

        return this;
    }

    public void verifyDashboardTitle(){
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
        assertWithMessage("No title is found").that(dashboardTitle.getText()).contains("Dashboard");
    }

}
