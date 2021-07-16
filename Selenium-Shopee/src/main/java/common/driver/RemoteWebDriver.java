package common.driver;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriver {

    protected WebDriver driver;
    ChromeWebDriver_Test cw;

    public RemoteWebDriver(){

    }

    public WebDriver chromeStart(){
        cw = new ChromeWebDriver_Test();
        cw.setWebdriver(
                "webdriver.chrome.driver",
                "src/main/resources/chrome/chromedriver.exe",
                "--window-size=1400,800");
        this.driver = cw.getDriver();
        driver.get("https://www.shopee.com.my");
        driver.manage().window().maximize();
        return driver;
    }

}
