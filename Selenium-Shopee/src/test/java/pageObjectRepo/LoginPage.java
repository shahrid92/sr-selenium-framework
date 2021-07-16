package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.google.common.truth.Truth.assert_;

public class LoginPage extends PageObject {

    @FindBy(css = "button")
    private List<WebElement> login;

    @FindBy(css = "[data-authuser]")
    private List<WebElement> gmailAccLists;

    @FindBy(css = "input[type='email']")
    private WebElement inputEmail;

    @FindBy(css = "button")
    private WebElement login2;

    @FindBy(css = ".RveJvd")
    private List<WebElement> GotItButton;

    @FindBy(css = ".RveJvd")
    private WebElement UnknownElements;

    @FindBy(css=".stardust-toast__container")
    private WebElement googleFailedToast;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage loginByGoogle(){

        login.forEach((e)->{
            if(e.getAttribute("outerText").contains("Google")){

                assert_().withMessage("Login Failed").that(e.getAttribute("outerText")).contains("Google");
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                wait.until(ExpectedConditions.invisibilityOf(googleFailedToast));
                e.click();

                String winHandleBefore = driver.getWindowHandle();
                Set<String> s1 = driver.getWindowHandles();
                Iterator<String> i1 = s1.iterator();
                while(i1.hasNext())
                {

                    if(driver.switchTo().window(i1.next()).getTitle().contains("Sign in – Google accounts")){

                        inputEmail.sendKeys("shahridzuan.aws@gmail.com");
                         login2.click();
                         wait.until(ExpectedConditions.elementToBeClickable(GotItButton.get(1)));
                         GotItButton.get(1).click();
                         driver.close();

                    }

                }

                driver.switchTo().window(winHandleBefore);
                e.click();
                wait.until(ExpectedConditions.visibilityOf(googleFailedToast));

            }
        });

        return this;
    }


}
