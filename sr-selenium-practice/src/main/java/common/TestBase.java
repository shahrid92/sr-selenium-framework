package common;

import common.utilities.ReadConfigFile;
import common.utilities.TestEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    protected WebDriver driver;


    public void setupBrowser() {
        ChromeOptions options;
        ReadConfigFile prop = new ReadConfigFile();
        TestEnum browser = TestEnum.valueOf(prop.getProperties("browser"));
        switch (browser) {
            case CHROME:
                options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                break;
            case EDGE:
                break;
        }

        driver.get("https://www.google.com");

    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void tearDown() {
        driver.close();
        driver.quit();
    }
}
