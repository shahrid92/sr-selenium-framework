package page;

import common.utilities.listener.actionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;


public class PageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait( this.driver,Duration.ofSeconds(10));
        PageFactory.initElements( this.driver, this);
    }


}
