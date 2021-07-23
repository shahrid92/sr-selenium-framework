package common.driver.browsers;

import common.helper.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWebDriverManager {

    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(readConfig.getUrl());
        return driver;
    }

}
