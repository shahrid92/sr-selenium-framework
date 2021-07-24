package common.driver.browsers;

import common.helper.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver {
    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getDriver() {
        readConfig = new ReadConfig("firefox");
        System.setProperty(readConfig.getBrowserDriver(),readConfig.getBrowserDriverPath());
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(Boolean.valueOf(readConfig.getHeadlessArgs()));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(readConfig.getUrl());
        return driver;
    }
}
