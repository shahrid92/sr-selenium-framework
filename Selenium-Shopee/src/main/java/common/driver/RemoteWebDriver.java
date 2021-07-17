package common.driver;

import common.helper.ReadConfig;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

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

}
