package common.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportClass {

    private ExtentTest test;
    private ExtentReports extent;
    private String browser;

    public ExtentReportClass(){
        extent = new ExtentReports();

        extent.setSystemInfo("os", "windows10");
        extent.setSystemInfo("Browser", "chrome");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    public ExtentTest getTest() {
        return test;
    }

    public void setTest(ExtentTest test) {
        this.test = test;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public void pass(String pass){
        this.test.pass(pass);
    }

    public void info(String info){
        this.test.info(info);
    }

    public void setExtent(ExtentReports extent) {
        this.extent = extent;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
