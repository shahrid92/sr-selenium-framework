package common.driver.browsers;

import common.helper.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver{

    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getDriver() {
        readConfig = new ReadConfig("chrome");
        System.setProperty(readConfig.getBrowserDriver(),readConfig.getBrowserDriverPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(readConfig.getMaxWindowsArgs());
        driver = new ChromeDriver(options);
        driver.get(readConfig.getUrl());
        return driver;
    }

}
