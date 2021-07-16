package driverLifeCycle;

import common.driver.RemoteWebDriver;
import common.helper.JsExecuteHelper;
import common.properties.readPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

@Listeners(common.listener.testListener.class)

public class TestDriverClass extends RemoteWebDriver {

    //protected WebDriver driver;
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
                System.out.println("START!!");
                //RemoteWebDriver rw = new RemoteWebDriver();
                chromeStart();
                break;

            case "firefox":
                break;

            case "IE":
                break;

        }

        //Set System Property
      //  System.setProperty(browserDriver,browserDriverPath);

        //Set Headless Options
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments(headlessArgs);
        //options.addArguments(disableGpuArgs);
       // options.addArguments(maxWindowsArgs);

       // this.driver = new ChromeDriver(options);

        LOG.info("Starting Webdriver " + browser);

        //Max Screen Size
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void closingDriver(){
        LOG.info("Terminating WebDriver");
        driver.close();
        driver.quit();
    }
}
