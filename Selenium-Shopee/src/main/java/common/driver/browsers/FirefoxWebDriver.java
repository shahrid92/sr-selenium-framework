package common.driver.browsers;

import common.helper.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver {
    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.shopee.com.my");
        return driver;
    }
}
