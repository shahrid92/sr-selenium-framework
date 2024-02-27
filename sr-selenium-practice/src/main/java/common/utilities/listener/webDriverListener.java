package common.utilities.listener;

import common.utilities.StepsScreenShot;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;


public class webDriverListener implements WebDriverListener {

    private final WebDriver driver;
    public webDriverListener(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("After Click!");
        screenShotAction("after-click",element);
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Before Click!");
        screenShotAction("before-click",element);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("After Enter Text: "+ Arrays.toString(keysToSend));
        screenShotAction("after-text",element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Before Enter Text: "+ Arrays.toString(keysToSend));
        screenShotAction("before-text",element);
    }

    private void screenShotAction(String fileName, WebElement ele){
        try {
            StepsScreenShot.takeSnapShot(this.driver,fileName,ele);
        }catch (Exception e){
            System.out.println("Screenshot failed!");
        }
    }
}
