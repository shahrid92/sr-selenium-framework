package common.driver;

import common.helper.ReadConfig;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RemoteWebDriver {

    protected WebDriver driver;
    ChromeWebDriver_Test cw;
    ReadConfig readConfig;

    public RemoteWebDriver(){

    }

    public WebDriver chromeStart(){
        cw = new ChromeWebDriver_Test();
        readConfig = new ReadConfig("chrome");
        cw.setWebdriver(
                readConfig.getBrowserDriver(),
                readConfig.getBrowserDriverPath(),
                readConfig.getMaxWindowsArgs());
        this.driver = cw.getDriver();
        driver.get(readConfig.getUrl());
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver firefoxStart(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.shopee.com.my");
        return driver;
    }

}
