package common.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.driver.RemoteWebDriver;
import common.reports.ExtentReportClass;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testListener implements ITestListener {

    private static final Logger LOG = LogManager.getLogger(testListener.class);
  //  private ExtentTest test;
   // private ExtentReports extent;
    //private ExtentReportClass erc ;//= new ExtentReportClass();

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

        LOG.info(arg0.getName() + "Test Completed");
    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        LOG.info("Starting Test...");
//        extent = erc.getExtent();
//        test=erc.getTest();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        LOG.info("FAILED!");
//        test.fail("failed!!");
//        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        LOG.info("Start Test : "+ arg0.getName());

//        test = extent.createTest(arg0.getName());
//        test.info("start test!");
//        test.assignDevice("device-name");
//        test.assignAuthor("author");
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
//        test.pass("PASS!!");
//        test.info(arg0.getInstanceName());
//        test.info(arg0.getHost());
//        test.info(arg0.getTestName());
//        extent.flush();

    }
}
