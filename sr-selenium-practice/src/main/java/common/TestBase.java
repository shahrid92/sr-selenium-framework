package common;

import common.utilities.ReadConfigFile;
import common.utilities.TestEnum;
import static common.utilities.TestEnum.BASEURL;
import static common.utilities.TestEnum.BROWSER;

import common.utilities.listener.actionListener;
import common.utilities.listener.webDriverListener;
import listener.ListenerTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Listeners;


@Listeners({ListenerTest.class,actionListener.class})

public class TestBase {

    public WebDriver drivers;
    public WebDriver driver;
    public static long globalTimestamp;
    public void setupBrowser() {
        ChromeOptions options;
        ReadConfigFile prop = new ReadConfigFile();
        TestEnum browser = TestEnum.valueOf(prop.getProperties(BROWSER.toString()));
        String baseUri = prop.getProperties(BASEURL.toString());

        switch (browser) {
            case CHROME:
                options = new ChromeOptions();
                //options.addArguments("--headless=new");
                //options.setBrowserVersion("119.0.6045.106");
                //options.setCapability("browserVersion", "119.0.6045.106");
                options.addArguments("--remote-allow-origins=*");
                drivers = new ChromeDriver(options);
                createNewFolder();
                break;
            case FIREFOX:
                break;
            case EDGE:
                break;
        }

        webDriverListener wdl = new webDriverListener(drivers);
        EventFiringDecorator<WebDriver> d = new EventFiringDecorator<>(wdl);

        this.driver = d.decorate(drivers);
        this.driver.manage().window().maximize();
        this.driver.get(baseUri);

    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void tearDown() {

        if (driver != null)
        {
            try
            {
                driver.quit();
                //driver.close();
            }
            catch (WebDriverException e) {
                System.out.println("***** CAUGHT WEBDRIVEREXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }

        }
    }

    public static void createNewFolder(){
        globalTimestamp = System.currentTimeMillis();
    }

    //TODO: js execute, cucumber, rest assured,, allure/extent report, sql, paramatization
    //TODO: https://www.youtube.com/watch?v=w9sfxQH62Yo&ab_channel=SaravananSeenivasan
    //TODO: add more test cases
}
