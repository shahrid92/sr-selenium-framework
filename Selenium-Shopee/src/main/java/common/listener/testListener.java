package common.listener;

import driverLifeCycle.TestDriverClass;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testListener implements ITestListener {

    private static final Logger LOG = LogManager.getLogger(testListener.class);

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        LOG.info("Starting Test...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        LOG.info("Start Test : "+ arg0.getName());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        LOG.info(arg0.getName() + "Test Completed");
    }
}
