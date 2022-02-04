package common.driver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.driver.browsers.ChromeWebDriver;
import common.driver.browsers.EdgeWebDriver;
import common.driver.browsers.FirefoxWebDriver;
import common.helper.ReadConfig;
import common.reports.ExtentReportClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDrivers {

    protected EventFiringWebDriver eventHandler;
    protected ExtentReportClass erc = new ExtentReportClass();
    protected ExtentTest test;
    protected ExtentReports extent;
    public WebDriver driver;


    protected void chromeStartGrid(){

        ChromeWebDriver cw = new ChromeWebDriver();
        driver = cw.getRemoteDriver();
        eventHandler = new EventFiringWebDriver(driver);
        RemoteWebDriverListener remoteWebDriverListener = new RemoteWebDriverListener();
        eventHandler.register(remoteWebDriverListener);
        extent = erc.getExtent();


    }

    protected void chromeStart(){

        ChromeWebDriver cw = new ChromeWebDriver();
        driver = cw.getDriver();
        eventHandler = new EventFiringWebDriver(driver);
        extent = erc.getExtent();
    }

    protected void firefoxStart(){
        FirefoxWebDriver ff = new FirefoxWebDriver();
        //driver = ff.getDriver();
    }

    protected void edgeStart(){
        EdgeWebDriver ew = new EdgeWebDriver();
       // driver = ew.getDriver();
    }

    protected void maxBrowserWindows(){
        driver.manage().window().maximize();
    }

}
