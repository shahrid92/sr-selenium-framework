package BaseClass;

import common.driver.RemoteWebDrivers;
import common.helper.ReadConfig;
import common.properties.readPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(common.listener.testListener.class)

public class TestBase extends RemoteWebDrivers {

    private static final Logger LOG = LogManager.getLogger(TestBase.class);
    private ReadConfig readConfig;
    private readPropertiesFile  readPropertiesFile;
    @BeforeClass
    public void createReport(){

    }

    @BeforeMethod
    @Parameters({"browser","properties"})
    public void mainDriver(String browser,final ITestContext testContext,String properties) {
        readPropertiesFile = new readPropertiesFile(properties);
        readConfig = new ReadConfig(browser);
        switch(browser){
            case "chrome" :
                if(readConfig.getMode().contains("grid")){
                    chromeStartGrid();
                }else{
                    chromeStart();
                }
                break;
            case "chrome-grid" :

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
        //System.out.println(testContext.getName());
        test = extent.createTest("test1");

        test.info("start test!");
        test.assignDevice("device-name");
        test.assignAuthor("author");


    }

    @AfterMethod
    public void closingDriver(){
        extent.flush();
        LOG.info("Terminating WebDriver");
        driver.close();
        driver.quit();
    }


}
