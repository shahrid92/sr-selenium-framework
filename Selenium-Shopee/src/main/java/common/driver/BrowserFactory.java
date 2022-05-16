package common.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public enum BrowserFactory {

    CHROME{
        @Override
        public WebDriver createDriver(){
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.setHeadless(true);

            return chromeOptions;
        }


    };

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();


}
