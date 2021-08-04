package common.driver;

import common.driver.browsers.ChromeWebDriver;
import common.driver.browsers.EdgeWebDriver;
import common.driver.browsers.FirefoxWebDriver;
import common.helper.ReadConfig;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class RemoteWebDriver {

    protected WebDriver driver;
    protected EventFiringWebDriver eventHandler;

    protected void chromeStart(){
        ChromeWebDriver cw = new ChromeWebDriver();
        driver = cw.getDriver();
        eventHandler = new EventFiringWebDriver(driver);
        RemoteWebDriverListener remoteWebDriverListener = new RemoteWebDriverListener();
        eventHandler.register(remoteWebDriverListener);
    }

    protected void firefoxStart(){
        FirefoxWebDriver ff = new FirefoxWebDriver();
        driver = ff.getDriver();
    }

    protected void edgeStart(){
        EdgeWebDriver ew = new EdgeWebDriver();
        driver = ew.getDriver();
    }

    protected void maxBrowserWindows(){
        driver.manage().window().maximize();
    }




}
