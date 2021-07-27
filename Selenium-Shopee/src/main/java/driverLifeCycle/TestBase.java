package driverLifeCycle;

import common.driver.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

@Listeners(common.listener.testListener.class)

public class TestBase extends RemoteWebDriver {

    private static final Logger LOG = LogManager.getLogger(TestBase.class);

    @BeforeMethod
    @Parameters({"browser"})
    public void mainDriver(String browser) {
        switch(browser){
            case "chrome" :
                chromeStart();
                break;

            case "firefox":
                firefoxStart();
                break;

            case "edge":
                edgeStart();
                break;

        }

        LOG.info("Starting Webdriver " + browser);

        maxBrowserWindows();

    }

    @AfterMethod
    public void closingDriver(){
        LOG.info("Terminating WebDriver");
        driver.close();
      //  driver.quit();
    }
}
