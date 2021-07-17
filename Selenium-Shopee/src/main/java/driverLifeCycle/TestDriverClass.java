package driverLifeCycle;

import common.driver.RemoteWebDriver;
import common.properties.readPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


import java.util.Properties;

@Listeners(common.listener.testListener.class)

public class TestDriverClass extends RemoteWebDriver {

    private static final Logger LOG = LogManager.getLogger(TestDriverClass.class);

    @BeforeMethod
    @Parameters({"browser"})
    public void mainDriver(String browser) {
        switch(browser){
            case "chrome" :
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
