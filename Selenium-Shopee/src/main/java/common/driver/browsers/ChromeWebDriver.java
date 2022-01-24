package common.driver.browsers;

import common.helper.ReadConfig;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ChromeWebDriver{

    private static final Logger LOG = LogManager.getLogger(ChromeWebDriver.class);
    private RemoteWebDriver remoteWebDriver;
    private WebDriver driver;
    private ReadConfig readConfig;


    public RemoteWebDriver getRemoteDriver() {
    try {
        LOG.info("Starting Chrome Webdriver...");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        readConfig = new ReadConfig("chrome");
        String huburl = readConfig.getGridurl();
        System.setProperty(readConfig.getBrowserDriver(), readConfig.getBrowserDriverPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(readConfig.getMaxWindowsArgs());
        options.setHeadless(true);
        remoteWebDriver = new RemoteWebDriver(new URL(huburl), options);
        remoteWebDriver.get(readConfig.getUrl());
        return remoteWebDriver;

    }catch(MalformedURLException e){
        e.printStackTrace();
        }
        return remoteWebDriver;
    }

    public WebDriver getDriver() {
        readConfig = new ReadConfig("chrome");
        System.setProperty(readConfig.getBrowserDriver(),readConfig.getBrowserDriverPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(readConfig.getMaxWindowsArgs());
        driver = new ChromeDriver(options);
        driver.get(readConfig.getUrl());
        return driver;
    }
}
