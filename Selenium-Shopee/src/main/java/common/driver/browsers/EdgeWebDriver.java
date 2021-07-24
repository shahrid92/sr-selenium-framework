package common.driver.browsers;

import common.helper.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeWebDriver {

    private WebDriver driver;
    ReadConfig readConfig;

    public WebDriver getDriver() {
        readConfig = new ReadConfig("edge");
        System.setProperty(readConfig.getBrowserDriver(),readConfig.getBrowserDriverPath());
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(readConfig.getUrl());
        return driver;
    }


}
