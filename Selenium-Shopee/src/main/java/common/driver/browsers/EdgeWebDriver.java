package common.driver.browsers;

import common.helper.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeWebDriver {

    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getDriver() {
       //readConfig = new ReadConfig("chrome");
        System.setProperty("webdriver.edge.driver","src/main/resources/edge/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.shopee.com.my");


        return driver;
    }


}
