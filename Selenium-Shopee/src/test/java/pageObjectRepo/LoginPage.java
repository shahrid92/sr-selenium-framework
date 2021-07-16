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

    @FindBy(css = "div[role='button'] > div:nth-child(2)")
    private WebElement GotItButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage loginByGoogle(){
        System.out.println("Found -- 1");
        login.forEach((e)->{
            System.out.println("Searching... "+e.getAttribute("outerText"));
            if(e.getAttribute("outerText").contains("Google")){
                System.out.println("Found");
                assert_().withMessage("Login Failed").that(e.getAttribute("outerText")).contains("Google");
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                Set<String> s1 = driver.getWindowHandles();
                Iterator<String> i1 = s1.iterator();
                while(i1.hasNext())
                {

                    if(driver.switchTo().window(i1.next()).getTitle().contains("Sign in – Google accounts")){

                        inputEmail.sendKeys("shahridzuan.aws@gmail.com");
                        login2.click();
                        GotItButton.click();
                        gmailAccLists.forEach((g)->{
                            System.out.println(g.getAttribute("data-identifier"));
                        });
                    }

                }


            }
        });

        return this;
    }


}
