package driverLifeCycle;

import common.properties.readPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.Properties;

@Listeners(common.listener.testListener.class)

public class TestDriverClass  {

    /*
    *  TODO:
    *   1. Add test listeners
    *   2. Add more test cases
    *   3. Seperate get config values
    *   4. screenshot failed test case at itestlistener
    *
    *
    *
    *
    *
    *
    *
    * */

    protected WebDriver driver;
    private Properties p;
    private String url;
    private String browserDriver,browserDriverPath;
    private String headlessArgs,disableGpuArgs,maxWindowsArgs;
    private static final Logger LOG = LogManager.getLogger(TestDriverClass.class);

    @BeforeMethod
    @Parameters({"browser"})
    public void mainDriver(String browser) {

        switch(browser){
            case "chrome" :
                url = readPropertiesFile.Property().getProperty("targetUrl");
                browserDriver = readPropertiesFile.Property().getProperty("driver.chrome");
                browserDriverPath = readPropertiesFile.Property().getProperty("driver.chrome.path");
                headlessArgs = readPropertiesFile.Property().getProperty("chrome.options.headless");
                disableGpuArgs = readPropertiesFile.Property().getProperty("chrome.options.gpu");
                maxWindowsArgs = readPropertiesFile.Property().getProperty("chrome.options.windows");
                break;

            case "firefox":
                break;

            case "IE":
                break;

        }

        //Set System Property
        System.setProperty(browserDriver,browserDriverPath);

        //Set Headless Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments(headlessArgs);
        options.addArguments(disableGpuArgs);
        options.addArguments(maxWindowsArgs);

        this.driver = new ChromeDriver(options);

        LOG.info("Starting Webdriver " + browser);

        //Max Screen Size
        driver.manage().window().maximize();
        this.driver.get(url);
    }

    @AfterMethod
    public void closingDriver(){
        LOG.info("Terminating WebDriver");
        driver.close();
        driver.quit();
    }
}
